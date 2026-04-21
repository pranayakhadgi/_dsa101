package Pranaya.StackQueue;

public class priorityQueue {
    private int[] toArray;
    private int count;

    public priorityQueue(int capacity){
        toArray = new int[capacity];
        count = 0;
    }

    public void toInsert(int x) {
        if(isFull()) {
            throw new IllegalStateException("Queue is full");
        }

        int i;
        //use the if conditionals to check from the back
        for(i = count - 1; i >= 0; i--) {
            if (toArray[i] > x) {
                toArray[i + 1] = toArray[i];//will this increse the size of the Array assuming I used ArrayList
            } else break;//found the value to be working for
        }

        toArray[i + 1] = x;
        count++;

        System.out.println("Inserted: " + x);
    }

    public int remove() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int removed = toArray[0];
        //shifting all elements left
        for(int i =0; i< count -1; i++){
            toArray[i] = toArray[i+1];
        }

        count--;
        System.out.println("Removed: " + removed);

        return removed;
    }

    public boolean isEmpty() {  // ADDED THIS METHOD
        return count == 0;
    }

    public boolean isFull() {
        return count == toArray.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < count; i++) {
            sb.append(toArray[i]);
            if (i < count - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Test it - FIXED THE METHOD CALLS
    public static void main(String[] args) {
        priorityQueue queue = new priorityQueue(6);  // Changed to priorityQueue

        queue.toInsert(1);
        queue.toInsert(3);  // Changed from insert() to toInsert()
        queue.toInsert(5);
        queue.toInsert(7);
        queue.toInsert(2);  // Should insert in sorted position

        System.out.println("\nFinal queue: " + queue);

        System.out.println("\nRemoving elements in priority order:");
        while (!queue.isEmpty()) {
            queue.remove();
        }
    }
}