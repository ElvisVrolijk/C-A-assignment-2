package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private Scanner sc = new Scanner(System.in);

    private MinMaxHeap userHeap;

    public static void main(String[] args) {
        // write your code here
        new Main().run();
    }

    private void run() {

        boolean exit = false;

        while (!exit) {
            options();

            int userOption = sc.nextInt();

            switch (userOption) {
                case 1:
                    makeList();
                    break;
                case 2:
                    if (userHeap == null) {
                        System.out.println("Must create a list first!");
                    } else {
                        insert();
                    }
                    break;
                case 3:
                    if (userHeap == null) {
                        System.out.println("Must create a list first!");
                    } else {
                        delete();
                    }
                    break;
                case 4:
                    removeMin();
                    break;
                case 5:
                    removeMax();
                    break;
                case 6:
                    test();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("invalid input!");
                    break;
            }
        }

    }

    private void removeMax() {
        System.out.println("Current Min Max Heap:  ");
        for (Integer integer : userHeap.getQueueArray()) {
            System.out.print(integer + " ");
        }

        System.out.println("");
        System.out.println("Removing Max: " + userHeap.getMax());
        userHeap.removeMax();

        System.out.println("New Min Max Heap: ");
        for (Integer integer : userHeap.getQueueArray()) {
            System.out.print(integer + " ");
        }

    }

    private void removeMin() {
        System.out.println("Current Min Max Heap:  ");
        for (Integer integer : userHeap.getQueueArray()) {
            System.out.print(integer + " ");
        }

        System.out.println("");
        System.out.println("Removing Min: " + userHeap.getMin());
        userHeap.removeMin();

        System.out.println("New Min Max Heap: ");
        for (Integer integer : userHeap.getQueueArray()) {
            System.out.print(integer + " ");
        }
    }

    /**
     * intro to the program
     */

    private void options() {
        System.out.println();
        System.out.println("Please enter a number!");
        System.out.println("1. Make a list and create a Min Max Heap.");
        System.out.println("2. Insert number. (must create a list first: option 1)");
        System.out.println("3. Delete number. (must create a list first: option 1)");
        System.out.println("4. Remove Min. (must create a list first: option 1)");
        System.out.println("5. Remove Max. (must create a list first: option 1)");
        System.out.println("6. Run example.");
        System.out.println("7. Exit program.");

    }

    /**
     * enter number to create a list and make a min max heap
     */

    private void makeList() {
        System.out.println("Enter numbers (Example : 1,2,3,100,etc)");
        String userList = sc.next();
        String[] numbers = userList.split(",");

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            list.add(number);
        }

        System.out.println("");
        System.out.println("Numbers entered:");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

        userHeap = new MinMaxHeap(list);
        userHeap.prioritize();

        System.out.println("");
        System.out.println("Prioritized list (Min Max Heap): ");
        for (Integer integer : userHeap.getQueueArray()) {
            System.out.print(integer + " ");
        }

        System.out.println("");

        System.out.println("Get min: " + userHeap.getMin());

        System.out.println("Get max: " + userHeap.getMax());
    }

    /**
     * add entered number
     */

    private void insert() {
        System.out.println("Enter a number.");
        int number = sc.nextInt();

        System.out.println("Number entered");
        System.out.println(number);

        userHeap.insert(number);

        System.out.println("New Min Max Heap: ");
        for (Integer integer : userHeap.getQueueArray()) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    /**
     * delete selected number
     */

    private void delete() {
        System.out.println("Current heap: ");
        for (Integer integer : userHeap.getQueueArray()) {
            System.out.print(integer + " ");
        }

        System.out.println("");
        System.out.println("which number you want to delete?");
        int number = sc.nextInt();

        userHeap.delete(number);

        System.out.println("New Min Max Heap: ");
        for (Integer integer : userHeap.getQueueArray()) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    /**
     * test (example on how the program works)
     */
    private void test() {
        List<Integer> list = new ArrayList<>();
        list.add(18);
        list.add(5);
        list.add(14);
        list.add(20);
        list.add(45);
        list.add(33);
        list.add(8);
        list.add(11);
        list.add(1);
        list.add(42);
        list.add(30);

        System.out.println("Inserting: ");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

        MinMaxHeap minMaxHeap = new MinMaxHeap(list);
        minMaxHeap.prioritize();
        System.out.println("");
        System.out.println("Min Max Heap: ");
        for (Integer integer : minMaxHeap.getQueueArray()) {
            System.out.print(integer + " ");
        }

        System.out.println("");

        System.out.println("Get min: " + minMaxHeap.getMin());

        System.out.println("Get max: " + minMaxHeap.getMax());

        System.out.println("");
        System.out.println("Deleting: ");
        System.out.println("1 5 45 18");
        minMaxHeap.delete(1);
        minMaxHeap.delete(5);
        minMaxHeap.delete(45);
        minMaxHeap.delete(18);

        System.out.println("New Min Max Heap: ");
        for (Integer integer : minMaxHeap.getQueueArray()) {
            System.out.print(integer + " ");
        }


    }


}
