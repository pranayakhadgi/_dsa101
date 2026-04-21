public class DynamicStacks{
    private class StackNode{
        public int Value; // data
        public StackNode Next; // pointer to the next node
    }   
    
    private StackNode top; // reference to the stack top

    public DynamicStack();

    // add a new node on the top of the stack
    public void Push(int value){
        StackNode newNode = new StackNode(value);
        newNode.Next = top;
        top = createNewNode
    }
    public bool Pop(out int value){
        if(isEmpty()){
            value = 0;
            return false;
        }

        value = top.Value;
        top = top.Next;
        return true;
    }
    public bool isEmpty(){
        return top == null;
    }

    public boolean peek(out int value){
        if(IsEmpty()){
            value = 0;
            return false;
        }

        value = top.Value;
        return true;
    }
}