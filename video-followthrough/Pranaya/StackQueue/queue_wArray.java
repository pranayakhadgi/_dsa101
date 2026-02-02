package Pranaya.StackQueue;

import java.util.Arrays;

public class queue_wArray {
    private int[] items;
    private int front;
    private int rear;
    private int count;

    public queue_wArray(int capacity){
        items = new int[capacity];
        front = 0;    // ← ADD THIS
        rear = 0;     // ← ADD THIS
        count = 0;    // ← ADD THIS
    }

    public void enqueue(int item) {
        if (count == items.length)
            throw new IllegalStateException("Queue is full!");  // Add message
        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty())  // ← ADD THIS CHECK
            throw new IllegalStateException("Queue is empty!");
        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;  // ← DON'T FORGET THIS!
        return item;
    }

    // Add helper methods
    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty!");
        return items[front];
    }

    @Override
    public String toString(){
        // Show only the actual queue elements in order
        int[] display = new int[count];
        for (int i = 0; i < count; i++) {
            int index = (front + i) % items.length;
            display[i] = items[index];
        }
        return Arrays.toString(display);
    }
}