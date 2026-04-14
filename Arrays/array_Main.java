package Pranaya.Arrays;

import java.util.ArrayList;

public class array_Main {
    public static void main(String[] args) {
//        Array numbers = new Array(3);
//        numbers.insert(10);
//        numbers.insert(20);
//        numbers.insert(30);
//        numbers.insert(40);
//        numbers.removeAt(2);
//        System.out.println(numbers.indexOf(20));
//        numbers.print();

        //Vector: 100% - synchronized (single thread can access it) - too complex, for advacnced Java course
        //Arraylist: 50%
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(0);

        list.lastIndexOf(20);

        list.size();
        System.out.println(list.contains(20));
        System.out.println( list.indexOf(20));

    }
}