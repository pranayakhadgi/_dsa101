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
}