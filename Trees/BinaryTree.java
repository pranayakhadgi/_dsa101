class BinaryTree {
    class Node {
        int data;
        Node left;
        Node right;
        Node parent;
    }

    Node root = null;

    // Creates a new node with the given value.
    public Node insert_node(int num) {
        Node newNode = new Node();
        newNode.data = num;
        newNode.left = null;
        newNode.right = null;
        newNode.parent = null;
        return newNode;
    }

    // Public insertion entry point that always starts from the root.
    public void insert_item(int num) {
        root = insert(root, num); // recursive insert returns subtree root
    }

    // Recursively inserts a value into the BST and returns subtree root.
    Node insert(Node root, int num) {
        // Base case: empty spot found
        if (root == null) {
            return insert_node(num);
        }

        if (num < root.data) {
            Node leftChild = insert(root.left, num);
            root.left = leftChild;
            leftChild.parent = root;
        } else if (num > root.data) {
            Node rightChild = insert(root.right, num);
            root.right = rightChild;
            rightChild.parent = root;
        }
        // If equal, do nothing (skip duplicates)
        return root;
    }

    // Iteratively inserts a value by walking down to the next leaf position.
    public void insert_value_at_leaf(int item) {
        if (root == null) {
            root = insert_node(item);
            return;
        }

        Node currentNode = root;
        Node parent = null;

        while (currentNode != null) {
            parent = currentNode;
            if (item < currentNode.data) {
                currentNode = currentNode.left;
            } else if (item > currentNode.data) {
                currentNode = currentNode.right;
            } else {
                return; // duplicate
            }
        }

        Node newNode = insert_node(item);
        newNode.parent = parent;

        if (item < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    public void inOrderTraversal(){
        inOrderTraversal(root);
    }

    public void preOrderTraversal(){
        preOrderTraversal(root);
    }

    public void postOrderTraversal(){
        postOrderTraversal(root);
    }

    

    private void inOrderTraversal(Node root){
        if(root != null) {
            //starts from the left - recursive
            inOrderTraversal(root.left);
            System.out.println(root.data);
            //then moves to right
            inOrderTraversal(root.right);
        }
    }

    private void preOrderTraversal(Node root){
        if (root != null) {
            //prints the root first
            System.out.println(root.data);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    private void postOrderTraversal(Node root){
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.data);
        }
    }

    public bool searchItem(int searchData) {
        return search(root, searchData);
    }

    private bool search(Node root, int searchData) {
        while(root != null) {
            if(root.data == searchData) return true;
            else if(root.data < searchData) 
                return search(root.right, searchData);
            else 
                return search(root.left, searchData);
        }
        return false;
    }


    // Deletion
    public void delete(int data) {
        root = deleteRecusrive(root, data);
    }

    private Node deleteRecursive(Node root, int data){
        while (node != null){
            if ( data < node.data) {
                node.left = deleteRecursive(root.left, data);
                return node;
            } else if (data > node.data) {
                node.right = deleteRecursive(root.right, data);
                return node;
            } else {
                // base case: node found
                return deleteNode(node);
            }
        }
    }

    private Node deleteNode(Node node) {
        // case 0 : node is a leaf
        if(node.left == null && node.right == null) {
            return null;
        }

        // case 1 : node has one child (left or right)
        else if(node.left == null) return node.right;
        else if(node.right == null) return node.left;

        // case 2 : node has two children
        else {
            Node predecessor = getPredecessor(node.left);
            // or Node successor = getSuccessor(node.right);

            node.data = predecessor.data;

            // delete the predecessor from the left subtree
            node.left = deleteRecursive(node.left, predecessor.data);

            return node;
        }
    }

    // predecessor - the largest node in the left subtree
    private Node getPredecessor(Node node) {
        Node currentRoot = node;

        while (currentRoot.right != null) {
            currentRoot = currentRoot.right;
        }

        return currentRoot;
    }

    // successor - the smallest node in the right subtree
    // an alternative for predecessor
    private Node getSuccessor(Node node) {
        Node currentRoot = node;

        while (currentRoot.left != null) {
            currentRoot = currentRoot.left;
        }

        return currentRoot;
    }

    
}