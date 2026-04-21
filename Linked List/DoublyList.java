public class DoublyList{
    private class Node{
        int data;
        //two pointers
        Node next;
        Node prev;
    }

    public DoublyList(){

    }

    public void push_front(int value){
        Node newNode = createNewNode(value);

        if(head != null) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        else {
            head = newNode;
            tail = newNode;
        }
        count++;
    }

    public void push_back(int value) {
        Node newNode = createNewNode(value);

        if(tail != null){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        else {
            head = newNode;
            tail = newNode;
        }
        count ++;
    }

    public void insert_after(Node prevNode, int value) {
        if(prevNode == null){
            System.out.println("The given previous node cannot be null");
            return;
        }

        Node nextNode = prevNode.next; // store the next node 

        // create the new node
        Node newNode = createNewNode(value);
        newNode.next = nextNode;
        newNode.prev = prevNode;

        if(nextNode != null) 
            nextNode.prev = newNode;
        else 
            tail = newNode;

        count++;
    }

    public bool insert(int index, int value){
        if(index < 0 || index > size)
            return false;
        
        if(index == 0)
            push_front(value);
        else if(index == size)
            push_back(value);
        else {
            Node current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
            insert_after(current.prev, value);
        }
        return true;
    }


    // FORWARD TRAVERSAL
    public void displayList(){
        Node node = head;

        while(node != null) {
            System.out.println(node.data + "<==>");
            node = node.next;
        }
        if(node == null)
            System.out.println("END");
    }
    
    // BACKWARD TRAVERSAL
    public void displayListBackwards(){
        Node node = tail;

        while(node != null) {
            System.out.println(node.data + "<==>");
            node = node.prev;
        }

        if(node == null)
            System.out.println("END");
    }

    public bool elementAT(int index, out T value){
        if(index > = count || index < 0)
            return false;
        Node current = headPtr;

        //searches for the value
        for(int i = 0; i < index; ++i) {
            current = current.next;
        }
        value = current.data;
        return true;
    }

    public boolean pop_front(out int data) {
        if(count == 0 || head == null)
            return false;

        data = head.data;

        if(head.next == null){
            tail = null;
            head = null;
            count = 0;
            return true;
        }

        Node prevHead = head;
        head = head.next;//the head is now the second node
        head.prev = null; //deletion
        prevHead = null;
        count--;
        return true;
    }

    public boolean pop_back(out int data) {
        if(count == 0 || tail == null) 
            return false;

        data = tail.data;

        if(head  == tail) {
            head = null;
            tail = null;
            count = 0;
            return true;
        }

        Node prevTail = tail;
        tail = tail.prev;
        tail.next = null;
        prevTail = null;
        count--;
        return true;
    }

    public void ClearAll(){
        Node currentPtr = head;
        Node tempPtr = null;

        while(currentPtr != null) {
            tempPtr = currentPtr.next;
            currentPtr = null;
            currentPtr = tempPtr;
        }
        head = null;
        tail = null;
        count = 0;
    }

    public bool deleteAfter(Node prevNode) {
        if(prevNode == null) 
            return false;

        Node nodeDelete = prevNode.next; //sets the node to be deleted

        if(nodeDelete == null)
            return false;

        Node nextNode = nodeDelete.next; // recorded the next node


        prevNode.next = nextNode;

        if(nextNode != null)
            nexNode.prev = prevNode;

        nodeDelete = null; // deletion
        count--;
        return true;
    }

    public boolean deleteNodeAtIndex(int index) {
        int value = 0;

        if(index < 0 || index > count)
            return false;

        if(index == 0){
            pop_front(index);
            return true;
        } else if(index == count){
            pop_back(index);
            return true;
        } else {
            Node current = head;
            for(int i = 0; i < index; ++i){
                current = current.next;
            }
            deleteAfter(current);
            return true
        }
    }

    public boolean reverseList(){
        if(count == 0 || head == null) 
            return false;

        Node front = head;
        Node back = tail;
        for(int i = 0; i < count/2; i++){

            //swapping the elements
            int temp = front.data;
            front.data = back.data;
            back.data = temp;
        }
        return true;
    }

    public boolean deleteAll(int searchVal){
        if(count == 0 || head == null)
            return false;

        Node prevNode = null; 
        Node current = head;
        while(current != null) {
            if(current.data == searchVal){
                if(prevNode == null){
                    tempNode = current.next;
                    current = tempNode;
                    current.prev = null;
                }
                else {
                    prevNode.next = current.next;
                    Node nextNdoe = prevNode.next;
                    if(nextNode != null)
                        nextNode.prev = prevNode;
                }
            }
            else{
                prevNode = current;
                current = current.next;
            }
        }
    }
}