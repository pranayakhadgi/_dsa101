
public class main2 {
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree(3);
        bst.insertElement(10);
        bst.insertElement(5);
        bst.insertElement(15);
        bst.insertElement(2);
        bst.insertElement(7);
        bst.insertElement(12);
        bst.insertElement(18);
        bst.inOrder(0);
        bst.preOrder(0);
        bst.postOrder(0);
    }
}