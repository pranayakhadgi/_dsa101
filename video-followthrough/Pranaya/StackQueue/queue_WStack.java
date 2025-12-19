package Pranaya.StackQueue;

import java.util.Stack;

public class queue_WStack {
    private Stack<Integer> stack1; //for enqueue
    private Stack<Integer> stack2;

    public queue_WStack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int x){
        stack1.push(x);
    }

    public int dequeue(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw getQueueIsEmpty();
        }

        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    private static RuntimeException getQueueIsEmpty() {
        return new RuntimeException("Queue is empty");
    }

    //adding a boolean helper
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
