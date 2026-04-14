package Pranaya.StackQueue;

public class stack_fromScratch_main {
    public static void main(String[] args) {
        stack_fromScratch stack = new stack_fromScratch();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        System.out.println(stack.peek());
    }
}
