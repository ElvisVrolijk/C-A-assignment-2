package com.company;

import sun.plugin2.os.windows.FLASHWINFO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.swap;

public class Minmaxheap {
    private List<Integer> queueArray;

    // Node
    private int nodePosition;
    private int node;

    // Parent
    private int parentPosition;
    private int parent;

    // Grand parent
    private int grandParentPosition;
    private int grandParent;

    // Children
    private HashMap<Integer, Integer> children = new HashMap<>();

    // Child
    private int childPosition;
    private int child;

    // Grand Children
    private HashMap<Integer, Integer> grandChildren = new HashMap<>();

    // Grand child
    private int grandChildPosition;
    private int grandChild;

    private boolean hasParent = false;
    private boolean hasGrandParent = false;
    private boolean hasChild = false;
    private boolean hasGrandChild = false;


    private boolean swapped = false;

    public Minmaxheap(List<Integer> queueArray) {
        this.queueArray = queueArray;
    }


    public boolean isEmpty() {
        return queueArray.size() < 1;
    }

    public int size() {
        return queueArray.size();
    }

    public int getMin() {
        return queueArray.get(queueArray.size() - 1);
    }

    public int getMax() {
        return queueArray.get(0);
    }

    public void insert(int x) {
        queueArray.add(x);
        prioritize();
    }

    public void removeMin() {
        queueArray.remove(queueArray.size() - 1);
    }

    public void removeMax() {
        queueArray.remove(0);
    }

    public List<Integer> getQueueArray() {
        return queueArray;
    }

    /**
     * @param i is used to calculate the level (min or max)
     * @return level (0 = min , 1 = max)
     */
    private int getLevel(int i) {
        return (int) (Math.log(i + 1) / Math.log(2)) % 2;
    }

    /**
     * @param nodePosition is used to calculate parent position
     * @return parent position
     */
    private int parentPosition(int nodePosition) {
        return nodePosition - (nodePosition / 2 + 1);
    }

    /**
     * @param parentPosition is used to get parent
     * @return parent
     */
    private int getParent(int parentPosition) {
        return queueArray.get(parentPosition);
    }

    /**
     * @param nodePosition is used to calculate grand parent position
     * @return grand parent position
     */
    private int grandParentPosition(int nodePosition) {
        int parentPosition = parentPosition(nodePosition);
        return parentPosition - (parentPosition / 2 + 1);
    }

    /**
     * @param grandParentPosition is used to get grand parent
     * @return grand parent
     */
    private int getGrandParent(int grandParentPosition) {
        return queueArray.get(grandParentPosition);
    }


    /**
     * @param childPosition is used to get and add child to map
     */
    private void addChildToMap(int childPosition) {
        if (childPosition <= queueArray.size() - 1) {
            int child = queueArray.get(childPosition);
            children.put(childPosition, child);
        }
    }

    /**
     * @param grandChildPosition is used to get and add grand child to map
     */
    private void addGrandChildToMap(int grandChildPosition) {
        if (grandChildPosition <= queueArray.size() - 1) {
            int grandChild = queueArray.get(grandChildPosition);
            grandChildren.put(grandChildPosition, grandChild);
        }
    }

    /**
     *
     * @param nodePosition is used to look for nodes children
     */
    private void lookForChildren(int nodePosition) {
        children.clear();

        int child1Position = nodePosition * 2 + 1;
        int child2Position = nodePosition * 2 + 2;

        addChildToMap(child1Position);

        addChildToMap(child2Position);
    }

    /**
     * @return smallest child position
     */
    private int minChildPosition() {
        int minPosition = -10;
        for (Map.Entry map : children.entrySet()) {
            int currentPosition = (int) map.getKey();
            int currentValue = (int) map.getValue();
            if (minPosition == -10 || currentValue < queueArray.get(minPosition)) {
                minPosition = currentPosition;
            }
        }

        return minPosition;
    }

    /**
     * look for the smallest child
     */
    private void findSmallestChild() {
        lookForChildren(nodePosition);

        if (children.size() > 0) {
            childPosition = minChildPosition();
            child = children.get(childPosition);
            hasChild = true;
        } else {
            hasChild = false;
        }
    }

    /**
     * @return biggest child position
     */
    private int maxChildPosition() {
        int maxPosition = -10;
        for (Map.Entry map : children.entrySet()) {
            int currentPosition = (int) map.getKey();
            int currentValue = (int) map.getValue();
            if (maxPosition == -10 || currentValue > queueArray.get(maxPosition)) {
                maxPosition = currentPosition;
            }
        }

        return maxPosition;
    }

    /**
     * look for biggest child
     */
    private void findBiggestChild() {
        lookForChildren(nodePosition);

        if (children.size() > 0) {
            childPosition = maxChildPosition();
            child = children.get(childPosition);
            hasChild = true;
        } else {
            hasChild = false;
        }
    }

    /**
     * @param nodePosition is used to look for grand children
     */
    private void lookForGrandChildren(int nodePosition) {
        grandChildren.clear();

        int child1Position = nodePosition * 2 + 1;
        int child2Position = nodePosition * 2 + 2;

        int grandChild1Position = child1Position * 2 + 1;
        int grandChild2Position = child1Position * 2 + 2;

        int grandChild3Position = child2Position * 2 + 1;
        int grandChild4Position = child2Position * 2 + 2;

        addGrandChildToMap(grandChild1Position);
        addGrandChildToMap(grandChild2Position);

        addGrandChildToMap(grandChild3Position);
        addGrandChildToMap(grandChild4Position);
    }

    /**
     * @return smallest grand child position
     */
    private int minGrandChildPosition() {
        int minPosition = -10;
        for (Map.Entry map : grandChildren.entrySet()) {
            int currentPosition = (int) map.getKey();
            int currentValue = (int) map.getValue();
            if (minPosition == -10 || currentValue < queueArray.get(minPosition)) {
                minPosition = currentPosition;
            }

        }
        return minPosition;
    }

    /**
     * look for the smallest grand child
     */
    private void findSmallestGrandChild() {
        lookForGrandChildren(nodePosition);

        if (grandChildren.size() > 0) {

            grandChildPosition = minGrandChildPosition();
            grandChild = queueArray.get(grandChildPosition);

            hasGrandChild = true;
        } else {
            hasGrandChild = false;
        }
    }
    /**
     * look for the biggest grand child position
     */
    private int maxGrandChildPosition() {
        int maxPosition = -10;
        for (Map.Entry map : grandChildren.entrySet()) {
            int currentPosition = (int) map.getKey();
            int currentValue = (int) map.getValue();
            if (maxPosition == -10 || currentValue > queueArray.get(maxPosition)) {
                maxPosition = currentPosition;
            }
        }

        return maxPosition;
    }

    /**
     * look for the biggest grand child
     */
    private void findBiggestGrandChild() {
        lookForGrandChildren(nodePosition);

        if (grandChildren.size() > 0) {
            grandChildPosition = maxGrandChildPosition();
            grandChild = queueArray.get(grandChildPosition);

            hasGrandChild = true;
        } else {
            hasGrandChild = false;
        }
    }

    /**
     * delete and reorder the heap
     */

    public void delete(int number) {
        boolean numberExists = false;
        int numberPosition = 0;
        for (int i = 0; i < queueArray.size(); i++) {
            if (queueArray.get(i) == number) {
                numberPosition = i;
                numberExists = true;
            }
        }

        if (numberExists && numberPosition != queueArray.size() -1) {
            swap(queueArray, numberPosition, queueArray.size() - 1);

            queueArray.remove(queueArray.size() - 1);

            int level = getLevel(numberPosition);

            if (level == 0) {
                setNode(numberPosition);
                setGrandChild(nodePosition);
                int smallestGC = grandChild;

                while (hasGrandChild) {
                    if (smallestGC < node) {
                        swapNodeWithGrandChild();
                    } else {
                        break;
                    }
                }
                setParent(nodePosition);

                swapped = false;
                if (node > parent) {
                    swapNodeWithParent();
                    swapped = true;
                }

                setChild(nodePosition);
                if (hasChild) {
                    if (swapped) {
                        int biggestChild = child;
                        if (biggestChild > node) {
                            swapNodeWithChild();
                        }
                    } else {
                        int smallestChild = child;
                        if (smallestChild < node) {
                            swapNodeWithChild();
                        }
                    }
                }
            } else if (level == 1) {
                setNode(numberPosition);
                setGrandChild(nodePosition);
                int biggestGrandChild = grandChild;

                while (hasGrandChild) {
                    if (biggestGrandChild > node) {
                        swapNodeWithGrandChild();
                    } else {
                        break;
                    }
                }
                setParent(nodePosition);

                swapped = false;
                if (node < parent) {
                    swapNodeWithParent();
                    swapped = true;
                }

                setChild(nodePosition);

                if (hasChild) {
                    if (swapped) {
                        int smallestChild = child;
                        if (smallestChild < node) {
                            swapNodeWithChild();
                        }
                    } else {
                        int biggestChild = child;
                        if (biggestChild > node) {
                            swapNodeWithChild();
                        }
                    }
                }
            }
        } else {
            queueArray.remove(numberPosition);
        }
    }

    /**
     * prioritize list when number is inserted or when a list is inserted
     */

    public void prioritize() {
        for (int i = 0; i < queueArray.size(); i++) {
            int level = getLevel(i);

            // Check if min (level = 0)
            if (level == 0) {
                // Node
                setNode(i);
                // Parent
                setParent(nodePosition);
                swapped = false;
                if (hasParent) {
                    if (node > parent) {
                        // Node becomes parent (by getting parents position)
                        swapNodeWithParent();
                    }
                }

                setGrandParent(nodePosition);

                if (swapped) {
                    while (hasGrandParent) {
                        if (node > grandParent) {
                            swapNodeWithGrandParent();
                        } else {
                            break;
                        }
                    }
                } else {
                    while (hasGrandParent) {
                        if (node < grandParent) {
                            swapNodeWithGrandParent();
                        } else {
                            break;
                        }
                    }
                }
            }


            // Check if max (level = 1)
            if (level == 1) {
                // Node
                setNode(i);
                // Parent
                setParent(nodePosition);
                swapped = false;
                if (hasParent) {
                    if (node < parent) {
                        // Node becomes parent (by getting parents position)
                        swapNodeWithParent();
                    }
                }

                // GrandParent
                setGrandParent(nodePosition);
                if (swapped) {
                    while (hasGrandParent) {
                        if (node < grandParent) {
                            swapNodeWithGrandParent();
                        } else {
                            break;
                        }
                    }
                } else {
                    while (hasGrandParent) {
                        if (node > grandParent) {
                            swapNodeWithGrandParent();
                        } else {
                            break;
                        }
                    }
                }

            }
        }

    }

    ////////////////////////////////////////////////////////////////
    /// Helper methods for setting node / parent / grand parent /
    /// grand children there position and there value.
    ////////////////////////////////////////////////////////////////

    private void setNode(int i) {
        nodePosition = i;
        node = queueArray.get(nodePosition);
    }

    private void setParent(int i) {
        parentPosition = parentPosition(i);
        if (parentPosition >= 0) {
            parent = getParent(parentPosition);
            hasParent = true;
        } else {
            hasParent = false;
        }
    }

    private void setGrandParent(int i) {
        grandParentPosition = grandParentPosition(i);
        if (grandParentPosition >= 0) {
            grandParent = getGrandParent(grandParentPosition);
            hasGrandParent = true;
        } else {
            hasGrandParent = false;
        }
    }

    private void setChild(int nodePosition) {
        int level = getLevel(nodePosition);
        if (level == 0) {
            findSmallestChild();
        } else if (level == 1) {
            findBiggestChild();
        }
    }

    private void setGrandChild(int nodePosition) {
        int level = getLevel(nodePosition);

        if (level == 0) {
            findSmallestGrandChild();
        } else if (level == 1) {
            findBiggestGrandChild();
        }
    }

    ////////////////////////////////////////////////////////////////
    /// Helper methods for swapping positions
    ////////////////////////////////////////////////////////////////

    private void swapNodeWithParent() {
        swap(queueArray, nodePosition, parentPosition);
        setNode(parentPosition);

        setParent(nodePosition);
        swapped = true;
    }

    private void swapNodeWithGrandParent() {
        swap(queueArray, nodePosition, grandParentPosition);
        setNode(grandParentPosition);

        setGrandParent(nodePosition);
        swapped = true;
    }

    private void swapNodeWithChild() {
        swap(queueArray, nodePosition, childPosition);
        setNode(childPosition);

        setChild(nodePosition);
    }

    private void swapNodeWithGrandChild() {
        swap(queueArray, nodePosition, grandChildPosition);
        setNode(grandChildPosition);

        setGrandChild(nodePosition);
    }
}


