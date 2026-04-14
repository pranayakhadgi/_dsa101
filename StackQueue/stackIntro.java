package Pranaya.StackQueue;

import java.sql.SQLOutput;
import java.util.Stack;

public class stackIntro {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        var x = stack.pop();
        System.out.println(x);
        stack.empty();//return bool value
    }
}
