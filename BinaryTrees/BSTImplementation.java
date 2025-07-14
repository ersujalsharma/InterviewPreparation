package BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    private void preOrderIterative(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.data + " ");
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }
    private void inOrderIterative(Node node){
        Stack<Node> stack = new Stack<>();
        while (true) {
            if(node!=null){
                stack.push(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()) break;
                node = stack.pop();
                System.out.print(node.data+" ");
                node = node.right;
            }
        }
    }
    private void PostOrderIterative(Node node){
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            stack2.push(node);
            if(node.left!=null) stack.push(node.left);
            if(node.right!=null) stack.push(node.right);
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().data+" ");
        }
    }
    private void postOrderIterativeStack1(Node node){
        Stack<Node> stack = new Stack<>();
        while(node!=null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                Node temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data+" ");
                    while(!stack.isEmpty() && temp  == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data+" ");
                    }
                }
                else{
                    node = temp;
                }
            }
        }
    }
    private static class Pair{
        Node node;
        int second;
        public Pair(Node node,int second){
            this.node = node;
            this.second = second;
        }
    }
    private void preInPostIterativeOrder(Node node){
        Stack<Pair> stack = new Stack<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        stack.push(new Pair(node, 1));
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            if(p.second == 1){
                preorder.add(p.node.data);
                p.second++;
                stack.push(p);
                if(p.node.left!=null){
                    stack.push(new Pair(p.node.left, 1));
                }
            }
            else if(p.second == 2){
                inorder.add(p.node.data);
                p.second++;
                stack.push(p);
                if(p.node.right!=null){
                    stack.push(new Pair(p.node.right, 1));
                }
            }
            else{
                postorder.add(p.node.data);
            }
        }
        System.out.println();
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
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
        sortedBst.postOrderIterativeStack1(sortedBst.root);
        sortedBst.preInPostIterativeOrder(sortedBst.root);
    }
}
