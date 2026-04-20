class BinarySearchTree {
    private int size, level;
    private int[] array;
    final const int NULL_VALUE = 2147483647; //we define one

    //constructor
    BinarySearchTree(int level) {
        this.level = level;
        this.size = extendSize(level); // 2^(level+1) -1
        System.out.println(this.size);
        this.array = new int[this.size];
        for (int x = 0; x < this.size; x++)
        {
            array[x] = NULL_VALUE
        }
    }

    public void insertElement(int item){
        int currentIndex = 0;
        System.out.println("Adding item" + item);
        while(true){
            if(currentIndex >= size) reallocate();
            if (array[currentIndex] == NULL_VALUE){
                array[currentIndex] = item;
                System.out.println(" Inserted at index: " + currentIndex);
                break;
            }
            else if (array[currentIndex] <= item) {
                if(array[currentIndex] == item){
                    System.out.println(" Item " + item + " already exists at index " + currentIndex);
                    break;
                }
                else { 
                    System.out.println(" Moving to the right " );
                    currentIndex = (2 * currentIndex + 2);
                    //left branch gets the (2 * currentIndex + 1)
                }
            }
        }
    }

    public void reallocate(){
        System.out.println("Reallocating");
        this.level = this.level + 1; // increasing the level of tree
        int tempSize = extendSize(this.level);

        int tempArray[] = new int[tempSize];
        for(int i=0; i<size; i++){
            // copy the elements of the previous array
            tempArray[i] = this.array[i];
        }

        // fill the remaining elements with NULL_VALUe
        for( int i = size; i<tempSize; i++){
            tempArray[i] = NULL_VALUE;
        }

        // remove the memory of the previous array
        this.array = null;
        this.array = tempArray; // temp takes the spot
        size = tempSize; // size is updated
    }
    public void searchElement(int searchValue){
        int currentIndex = 0;
        while(true) {
            if (currentIndex >= size || array[currentIndex] == NULL_VALUE){
                System.out.println("Item not found!");
                break;
            }

            //BASE CASE
            if(array[currentIndex] == searchValue_){
                System.out.println("found!");
                break;
            } 
            //GENERAL CASE
            else if (array[currentIndex] < searchValue){
                currentIndex = (2 * currentIndex + 2);
            } else {
                currentIndex = (2 * currentIndex + 1);
            }
        }
    }
    public void inOrder(int currentIndex){
        if(currentIndex >= size) return;

        if(array[currentIndex] != NULLVALUE) {
            inOrder(2 * currentIndex + 1);
            //parent
            System.out.println(array[currentIndex]);
            inOrder(2 * currentIndex + 2);
        }
    }
    public void preOrder(int currentIndex){
        if(currentIndex >= size) return;

        if(array[currentIndex] != NULLVALUE) {
            System.out.println(array[currentIndex]);
            preOrder(2 * currentIndex + 1);
            preOrder(2 * currentIndex + 2);
        }
    }
    public void postOrder(int currentIndex){
        if(currentIndex >= size) return;

        if(array[currentIndex] != NULLVALUE) {
            postOrder(2 * currentIndex + 1);
            postOrder(2 * currentIndex + 2);
            System.out.println(array[currentIndex]);
        }
    }

    public void parentOfNode(int childIndex){
        if(childIndex >= size || array[childIndex] == NULL_VALUE){
            System.out.println("Invalid index");
            return;
        }
        int parentIndex = (childIndex - 1) / 2;
        System.out.println("Parent of " + array[childIndex] + " is " + array[parentIndex]);
    }

    public int extendSize(int level){
        return (int) Math.pow(2, level + 1) - 1;
    }

    public bool deleteElement(int data){
        return delete(root, data);
    }

    private bool delete(int currentIndex, int data) {
        if(array[currentIndex] == NULL_VALUE)
            return false; // no value found

        if(data < array[currentIndex])
            return delete(2 * currentIndex + 1, data);
        else if(data > array[currentIndex])
            return delete(2 * currentIndex + 2, data);
        else {
            
        }
    }

    private bool deleteNode(int currentIndex){
        int left = 2 * currentIndex + 1;
        int right = 2 * currentIndex + 2;

        //...
        else { // case 2 : two nodes
            int preIndex = getPredecesor(left);
            array[currentIndex] = elementAt(preIndex);
            return deleteNode(preIndex);
        }
        return false;
    }

    private int getPredecesor(int currentIndex){
        while(array[currentIndex] != NULL_VALUE){
            currentIndex = 2 * currentIndex + 2;
        }
        return currentIndex;
    }

    private int getSuccessor(int currentIndex){
        while(array[currentIndex] != NULL_VALUE){
            currentIndex = 2 * currentIndex + 1;
        }
        return currentIndex;
    }
};