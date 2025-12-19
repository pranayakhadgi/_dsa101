//Interview Question 1: My approach

package Pranaya.StackQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class queueEx1 {
    public static void main(String[] args){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        reverse(queue);
        System.out.println(queue);
    }

    public static void reverse(Queue<Integer> queue){
        Object[] arr = queue.toArray(); //gets all the elemetns as Arrays

        queue.clear();

        for(var i = arr.length -1; i >=0; i--) {
            queue.add((Integer)arr[i]);
        }

    }
}
