package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private Minmaxheap minmaxheap;

    public static void main(String[] args) {
        // write your code here
        new Main().test();
    }

    public void test() {

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

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

        minmaxheap = new Minmaxheap(list);
        minmaxheap.prioritize();

        System.out.println(" ");

        for (Integer integer : minmaxheap.getQueueArray()) {
            System.out.print(integer + " ");
        }

        minmaxheap.delete(1);
        minmaxheap.delete(5);
        minmaxheap.delete(45);
        minmaxheap.delete(18);

        System.out.println(" ");

        for (Integer integer : minmaxheap.getQueueArray()) {
            System.out.print(integer + " ");
        }
    }

}
