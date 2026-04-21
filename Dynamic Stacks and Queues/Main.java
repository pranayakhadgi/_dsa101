import DynamicStacks;

public class Main{
    public static void main(String[] args){
        DynamicStack stack = new DynamicStack();
        DynamicQueue queue = new DynamicQueue();

        queue.Enqueue(10);
        queue.Enqueue(20);
        queue.Enqueue(30);

        int value;
        queue.Dequeue(out value);
        System.out.println("Dequeued value: " + value);

        stack.Push(10);
        stack.Push(20);
        stack.Push(30);

        int value;
        stack.Pop(out value);
        System.out.println("Popped value: " + value);
    }
}