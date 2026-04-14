package Pranaya.StackQueue;

public class queue_WStack_main {
    public static void main(String[]args){
        queue_WStack queue = new queue_WStack();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();//get 10
        queue.dequeue();//get 20
        queue.dequeue();//throws exception
        var first = queue.dequeue();
        System.out.println(first);
    }
}
