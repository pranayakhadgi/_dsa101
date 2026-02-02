package Mayowa;

import java.util.Arrays;

public class array_Main {
    public static void main(String[] args) {
        Array numbers = new Array(3);
        
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        System.out.println(numbers.indexOf(10));
        numbers.print();
    }    
}

