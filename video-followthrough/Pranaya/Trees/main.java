public class main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert_item(50);
        tree.insert_item(30);
        tree.insert_item(20);
        tree.insert_item(40);
        tree.insert_item(70);
        tree.insert_item(60);

        tree.insert_value_at_leaf(80);
        tree.insert_value_at_leaf(90);

        System.out.println("Root:" + tree.root.data);

        if(tree.root.left != null) {
            System.out.println("Left Root: " + tree.root.left.data);
        }

        if(tree.root.right != null) {
            System.out.println("Right Root: " + tree.root.right.data);
        }

        //demonstrate a parent pointer for left subroot node
        if(tree.root.left != null && tree.root.left.parent != null){
            System.out.println("Parent of " + tree.root.left.data + " is: " + tree.root.left.parent.data);
        }
    }
}