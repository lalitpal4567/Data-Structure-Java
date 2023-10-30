package tree.binaryTree.bTUsingLinkedList;

class Node2{
    int data;
    Node2 left;
    Node2 right;
    Node2(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class BST {
    Node2 root;
    BST(){
        root = null;
    }

    // insert
    public Node2 insert(Node2 node, int data){
        if(node == null){
            return new Node2(data);
        }
        if(data < node.data){
            node.left = insert(node.left, data);
        }
        if(data > node.data){
            node.right = insert(node.right, data);
        }
        return node;
    }

    // preorder traversal
    public void traverse(Node2 node){
        if(node == null){
            return;
        }
        traverse(node.left);
        System.out.println(node.data);
        traverse(node.right);
    }
    public static void main(String[] args) {
        BST obj = new BST();
        obj.insert(obj.root, 10);
        obj.insert(obj.root, 50);
        obj.insert(obj.root, 30);
        obj.insert(obj.root, 40);
        obj.traverse(obj.root);
    }
}
