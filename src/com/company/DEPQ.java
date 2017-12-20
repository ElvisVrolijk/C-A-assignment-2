package com.company;

import java.util.List;

import static java.util.Collections.swap;

public class DEPQ {
    private List<Integer> queueArray;

    public DEPQ(List<Integer> queueArray) {
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

    public void put(int x) {
        queueArray.add(x);
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

    public void prioritize() {
        for (int i = 0; i < queueArray.size(); i++) {
            int level = (int) (Math.log(i + 1) / Math.log(2)) % 2;

            // Check if min (level = 0)
            if (level == 0) {
                // Parent
                int parentPosition = i - (i / 2 + 1);
                if (parentPosition >= 0) {
                    int parent = queueArray.get(parentPosition);

                    // Node
                    int nodePosition = i;
                    int node = queueArray.get(nodePosition);

                    if (node > parent) {
                        // Node becomes parent (by getting parents position)
                        swap(queueArray, nodePosition, parentPosition);

                        // GrandParent
                        int maxParentPosition = parentPosition - (parentPosition / 2 + 1);
                        int grandParentPosition = maxParentPosition - (maxParentPosition / 2 + 1);
                        if (grandParentPosition >= 0) {
                            int grandParent = queueArray.get(grandParentPosition);
                            int newNodePosition = parentPosition;
                            int newNode = queueArray.get(newNodePosition);
                            if (newNode > grandParent) {
                                swap(queueArray, parent, grandParentPosition);
                            }
                        }
                    }
                }
            }

            // Check if max (level = 1)
            if (level == 1) {
                // Parent
                int parentPosition = i - (i / 2 + 1);
                if (parentPosition >= 0) {
                    int parent = queueArray.get(parentPosition);

                    // Node
                    int nodePosition = i;
                    int node = queueArray.get(nodePosition);

                    if (node < parent) {
                        // Node becomes parent (by getting parents position)
                        swap(queueArray, nodePosition, parentPosition);

                        // GrandParent
                        int minParentPosition = parentPosition - (parentPosition / 2 + 1);
                        int grandParentPosition = minParentPosition - (minParentPosition / 2 + 1);
                        if (grandParentPosition >= 0) {
                            int grandParent = queueArray.get(grandParentPosition);
                            int newNodePosition = parentPosition;
                            int newNode = queueArray.get(newNodePosition);
                            if (newNode < grandParent) {
                                swap(queueArray, parentPosition, grandParentPosition);
                            }
                        }
                    }
                }
            }
        }
    }

}
