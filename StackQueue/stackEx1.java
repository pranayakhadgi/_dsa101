//INTERVIEW QUESTION 1: REVERSING A STRING (STACK COMES TO THE RESCUE!!!)

package Pranaya.StackQueue;

import java.util.Stack;

public class stackEx1 {
    public static void main(String[]args) {
        String str = null;
        if(str == null)
            throw new IllegalStateException();

        Stack<Character> steck = new Stack<>();


        for(var ch : str.toCharArray())
            steck.push(ch);

        StringBuilder reversed = new StringBuilder();
        while(!steck.isEmpty()) reversed.append(steck.pop());
        System.out.println(reversed);
    }
}
