package BinaryTrees;

import java.util.Scanner;

public class Implementation {
    private static class Node {
        int data;
        Node left,right;
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }    
    private Node populate(Scanner scanner){
        System.out.println("Enter root value : ");
        int data = scanner.nextInt();
        Node root = new Node(data);
        populate(scanner, root);
        return root;
    }
    private void populate(Scanner scanner, Node root) {
        // TODO Auto-generated method stub
        System.out.println("Enter left child of " + root.data + " Opt True/False ");
        boolean val = scanner.nextBoolean();
        if (val) {
            int data = scanner.nextInt();
            root.left = new Node(data);
            populate(scanner, root.left);
        }
        System.out.println("Enter right child of " + root.data + " Opt True/False ");
        boolean val2 = scanner.nextBoolean();
        if (val2) {
            int data = scanner.nextInt();
            root.right = new Node(data);
            populate(scanner, root.right);
        }
    }
    public static void display(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        display(root.left);
        display(root.right);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Implementation tree = new Implementation();
        Node root = tree.populate(scanner);
        System.out.println("Binary Tree created with root value: " + root.data);
        display(root);
        scanner.close();
    }
}
