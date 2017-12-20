package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private DEPQ depq;

    public static void main(String[] args) {
        // write your code here
        new Main().test();
    }

    public void test() {
//        for (int i = 0; i < 10; i++) {
//            int level = (int) (Math.log(i + 1) / Math.log(2)) % 2;
////            System.out.println("log (" + i + ") / log(2) = " + level);
//            if (i > 0) {
//                int calPar = i / 2 + 1;
//                int parentNode = i - calPar;
//                int calGrand = parentNode / 2 + 1;
//                int grandParent = parentNode - calGrand;
//
//                System.out.println("parent node of (" + i + "): " + parentNode);
//                System.out.println("grandparent node: " + grandParent);
//            }
//
//        }
        List<Integer> list = new ArrayList<>();
        list.add(18);
        list.add(5);
        list.add(14);
        list.add(20);
        list.add(45);
        list.add(33);
        list.add(4);
        list.add(11);
        list.add(1);

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        depq = new DEPQ(list);
        depq.prioritize();

        System.out.println(" ");

//        int toPrint = 1;
//        int nodeInLine = 1;
//        int i = 0;
//        String space = " ";
//        while (i < depq.getQueueArray().size()) {
//            toPrint--;
//
//            System.out.print(depq.getQueueArray().get(i));
//            i++;
//            if (toPrint == 0) {
//                nodeInLine *= 2;
//                toPrint = nodeInLine;
//                System.out.println();
//            }
//        }

        for(int i=0;i<depq.getQueueArray().size();i++){
            for(int j=0;j<Math.pow(2,i)&&j+Math.pow(2,i)<10;j++){
                System.out.print(depq.getQueueArray().get(j+(int)Math.pow(2,i)-1)+" ");

            }
            System.out.println();
        }
    }
}
