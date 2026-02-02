# My view on Stack and Queue

Alright team, we start with Queue (video filing issue). Queue is an interface not a class to be instantiated. If done so, will result in auto-generated overridden series of a chunk of methods/functions of queue which looks as follows:-

package Pranaya.StackQueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class queueEx1 {
public static void main(String[] args) {
Queue<Integer> w = new Queue<Integer>() {
@Override
public boolean add(Integer integer) {
return false;
}

            @Override
            public boolean offer(Integer integer) {
                return false;
            }

            @Override
            public Integer remove() {
                return 0;
            }

            @Override
            public Integer poll() {
                return 0;
            }

            @Override
            public Integer element() {
                return 0;
            }

            @Override
            public Integer peek() {
                return 0;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Integer> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Integer> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }
        }
    }
}

## The First Interview Exercise - Reversing a Queue
Well, since I had a few constraints on this exercise to strictly use add(), remove(), isEmpty() queue functions, I thought of a similar approach I did for String reversal. I converted the Queue into Array and basically reverse for looped it. Using the queue.add added the reversed array elements. While Mosh used a better approach of Stack implmentation where he cut paste the elements of queue into stack using push from Stack and remove from Queue, check if the Stack is empty again, to re put the elements from Stack to Queue as Stack does LIFO and Queue takes is as FIFO, hence the element reversal makes much more sense.

## The Second Interview Exercise - Adding to Queue using Array

As this exercise was rather more complicated with the use of fields, constructor and property, the tutorial has two pointers implemented in order check the array index bounds, as we create the function for enqeuue and dequeue, I understood how the private field integers front and rear (the two pointers) contributes for the respective function interms of adding the queueArray implementation to Array, so that we could use the enqueue and dequeue without having to worry about Queue instantiation (array handles it)
### Use of circular Arrays (one of the most important data structure concept) 
The concept aligns with binary modulus congruency cycle, every index limit gets repitive like a clock work. The modulus index placement for key elements have been introduced here.
**rear = (rear + 1) % items.length;** <--- implementation of circular arrays

## The Third Interview Exercise (also a popular DSA question) - Implementing queues using two Stacks
This was rather a simpler algorithm. Queue works in a FIFO mechanism, meaning that dequeuing the queue will take the first element and enqueuing it will add the element to the last. How could we achieve this using Stack (given the constraint of how we could only access the top element in a stack1). We creatively use double stacks, where you enqueue on stack 1 and push it to stack 2 reversing the element order so if you dequeue stack2, the first element on the stack1 will be taken and remove. In order to do that stack2 must always be empty so that the dequeue for queue makes sense.


## The Fourth Interview Exercise - Creating the Array based PriorityQueue using insert method
As the default priorityQueue sorts the elements in order of their ASCII size, the array implementation is simple. Having a full array, inserting a number to make sure it's in priority order, we use compare the elements from the end and expand the array making sure that the element being compared gets shifted to the right, without having to lose any elements (happens when you loop the index from the front). With that mechanism, a value such as 2 gets stored in its order, expanding the array with one more element and through index shifting. Later when implemented a remove method, it removes all the elements in a sequencial order for PriorityQueue.

#### WELL THAT WAS ALL FOR QUEUE - MOVING ONTO STACKS NOW 

---


# My view on Stacks
Did you know that Stacks application seems to be much more vast than we think? Daily applications such as implementing the undo feature, building compilers, evaluating expressions to even building navigation (in webbrowser going forward and backward).

## The First Interview Exercise - Reverse a string (Basic Stack Implementation)

it was simple, using foreach enhanced, push the string to char and pop and return the element to "returned". The LIFO makes it more practicable for using Stacks in reverse problems

## The Second Interview Exercise - Check Balanced Expression

A rather interesting problem, this one. Given a string, we need to check if any given type of opening bracket matches with the closing bracket. For the simpler implementation at first, we just start with one type of bracket, check the conditions. If it's an opening bracket, push it to stack, any closing bracket comes in, you pop the recent stack and check if it matches, if not the isBalanced function returns false. One thing that I realised upon practicing with problem with Mosh was the importance of refarctoring. Instead of a long messy if conditionals, cast that string literal into ArrayList with Arrays.asList() function. You could refactor and extract a given var variable into a private field through field declaration as well (just go to menu--> refactor --> extract to field. Makes the code much cleaner)

## Building Stacks from scratch using Arrays
This was an interesting problem to provide you insights on how each of the stack function works. With every self built functions like push, pop, peek, and isEmpty, we need to understand the characteristical difference between these two topics, one being a class, another being an interface. so push uses teh Arraylist add with index++, pop decrements the count and gets you the element you're looking for, pop removes the elemetns and decrements the index. is empty checks if the count == 0. Using toString remvoes the empty 0 spaces, which Stack doesn't show.