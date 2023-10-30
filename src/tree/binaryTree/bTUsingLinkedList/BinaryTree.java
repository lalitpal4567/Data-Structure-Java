package tree.binaryTree.bTUsingLinkedList;

import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    static Scanner input = new Scanner(System.in);
     Node root;
    BinaryTree(){
        root = null;
    }

    // insert node
    public void insert(Node node){
        if(node == null){
            System.out.print("Enter the root node: ");
            int data = input.nextInt();
            node = new Node(data);
            root = node;
        }
        System.out.print("Do you want to insert to left of " + node.data + ": ");
        boolean left = input.nextBoolean();
        if(left){
            System.out.print("Enter the node: ");
            int data = input.nextInt();
            node.left = new Node(data);
            insert(node.left);
        }
        System.out.print("Do you want to insert to right of " + node.data + ": ");
        boolean right = input.nextBoolean();
        if(right){
            System.out.print("Enter the node: ");
            int data = input.nextInt();
            node.right = new Node(data);
            insert(node.right);
        }
    }

    // display nodes
    public static void display(Node node){
        if(node == null) {
            return;
        }
        display(node.left);
        System.out.println(node.data);
        display(node.right);
    }
    public static void main(String[] args) {
        BinaryTree obj = new BinaryTree();
        obj.insert(obj.root);
        display(obj.root);
    }
}
