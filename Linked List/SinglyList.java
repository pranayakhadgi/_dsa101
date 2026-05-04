public class SinglyList {

    private static class Node {
    double data;
    Node next; // the pointer
    }

    private Node headPtr, tailPtr; //fields
    private int count;

    public ListNode(double data) {
        this.data = data;
        this.next = null;
    }

    public void pushFront(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null; // instantiate

        if(heatPtr == null) {
            headPtr = newNode;
            tailPtr = newNode;
            count = 1; 
        } else {
            newNode.next = headPtr;
            headPtr = newNode;
            count++;
        }
    }

    //append at the back
    public void pushBack(int data){
        Node newNode = new Node();
        newNode.data = data;// set the value
        newNode.next = null;// set the tail pointer to null

        // if the entire list is empty
        if (headPtr == null) {
            headPtr = newNode;
            tailPtr = newNode;
            count = 1;
        } else {
            tailptr.next = newNode;
            tailPtr = newNode;
            count++;
        }
    }
    public boolean insert(int index, int data){
        if(index > count || index < 0) 
            return false;
        else if(index == 0) {
            pushfront(data);
            return true;
        }
        else if(index == count) {
            pushback(data);
            return true;
        } 
        else {
            //instantiate the new node with a set head and tail pointer 
            Node prev = null;
            Node current = headPtr; 

            //once created, it nativates up through loop iteration
            for(int i = 0; i < index; ++i) {
                prev = current;
                current = current.next;
            }

            Node newNode = new Node();
            newNode.data = data;
            newNode.next = current;
            prev.next = newNode;
            count++;// increase list size
            return true;
        }
    }
    public int at(int index){
        if(index < 0 || index >= count) 
            return NOT_FOUND;

        Node currentPtr = headPtr;

        for(int i =0; i < index; i++) {
            current = current.next;
        }
        return currentPtr.data;
    }
    public boolean deleteNode(int index){
        if(index >= count || count == 0 || index < 0)
            return false;

        Node current = headPtr;

        if(index == 0) {
            headPtr = headPtr.next; //header ponits the next node
            current = null;// remoces the current head
            count--;

            //if it's the last node, updates it
            if(count == 0) tailPtr = null;
            return true;
        }
        else {
            Node prevNode = null;
            current = headPtr;
            for(int i = 0; i < index; ++i) {
                prevNode = current;
                current = current.next;
            }

            //if the node is the last node
            if(tailPtr == current) {
                tailPtr = prevNode;
            }

            // once the node's removed, we'll update the list
            prevNode.next = current.next;// shifts the nodes to the right
            current = null; // deletes the node
            count --;

            if(count == 0) 
                tailPtr = null;

            return true;

        }
    }

    public void displayNode(){
        Node currentPtr = headPtr; //starts with head
        while(currentPtr != null) {
            System.out.println(currentPtr.data +  " ");
            currentPtr = currentPtr.next; // works like i++
        }
    }
    public boolean isEmpty(){}
    public int size();
    public void clearAll();
    public int popFront();
    public int popBack();
}