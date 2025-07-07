package BinaryTrees;

public class BSTImplementation {
    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    private Node root;
    public BSTImplementation() {
        root = null;
    }
    public void insert(int data) {
        root = insert(root, data);
    }
    public void populateSorted(int data){
        populateSorted(1,data);
    }
    private void populateSorted(int start, int end) {
        // TODO Auto-generated method stub
        int mid = start + (end - start) / 2;
        if (start > end) {
            return;
        }
        insert(mid);
        populateSorted(start, mid - 1);
        populateSorted(mid + 1, end);
    }
    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        // If data is equal, do nothing (no duplicates allowed)
        return node;
    }
    public boolean search(int data) {
        return search(root, data);
    }
    private boolean search(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (data < node.data) {
            return search(node.left, data);
        } else if (data > node.data) {
            return search(node.right, data);
        } else {
            return true; // data found
        }
    }
    public boolean balanced() {
        return isBalanced(root);
    }
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false; // not balanced
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }
    private int height(Node node) {
        // TODO Auto-generated method stub
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    public void display() {
        display(root);
    }
    private void display(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        display(node.left);
        display(node.right);
        // System.out.println();
    }
    private void displayPretty(Node node, String prefix, boolean isLeft) {
        if (node == null) {
            return;
        }
        System.out.print(prefix);
        System.out.print(isLeft ? "├── Left -  " : "└── Right - ");
        System.out.println(node.data);
        displayPretty(node.left, prefix + (isLeft ? "│   " : "    "), true);
        displayPretty(node.right, prefix + (isLeft ? "│   " : "    "), false);
    }
    public static void main(String[] args) {
        // BSTImplementation bst = new BSTImplementation();
        // bst.insert(10);
        // bst.insert(5);
        // bst.insert(15);
        // bst.insert(3);
        // bst.insert(7);
        // bst.insert(12);
        // bst.insert(18);
        // bst.display();
        // System.out.println();
        // bst.displayPretty(bst.root, "", true);
        // System.out.println();
        // System.out.println("Search 7: " + bst.search(7)); // true
        // System.out.println("Search 20: " + bst.search(20)); // false
        // System.out.println("Is balanced: " + bst.balanced()); // true

        // // Insert more nodes to make it unbalanced
        // bst.insert(1);
        // System.out.println("Is balanced after inserting 1: " + bst.balanced()); // false

        // Populate sorted BST
        BSTImplementation sortedBst = new BSTImplementation();
        sortedBst.populateSorted(1, 10);
        System.out.println("Sorted BST:");
        sortedBst.display();
        System.out.println();
        sortedBst.displayPretty(sortedBst.root, "", true);
    }
}
