public class HeapType<T> {
    private T[] elements; //dynamic array
    private int numElements;

    public HeapType(){
       elements = new T[capacity];
       numElements = 0;
    }

    public void ReheapDown(int root, int bottom){
        int maxChild, rightChild, leftChild;

        leftChild = root * 2 + 1;
        rightChild = root * 2 + 2;

        if(leftChild <= bottom) {
            if(leftChild == bottom) {
                maxChild = leftChild;
            } else { // two children
                if (elements[leftChild].CompareTo(elenents[rightChild]) <= 0)
                    maxChild = rightChild;
                else 
                    maxChild = leftChild;
            }

            // compare max child with parent
            if(elements[root].CompareTo(elements[maxChild]) < 0) {
                Swap(root, maxChild);
               ReheapDown(maxChild, bottom); 
            }
        }
    }

    public void ReheapUp(int root, int bottom){
        
    }
}