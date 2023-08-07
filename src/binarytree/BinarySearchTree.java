package binarytree;

public class BinarySearchTree {
    class Node{
        int data;
        Node left;
        Node right;
        private Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree(){
        this.root = null;
    }
    public void insert(int data){
        root = insertRec(root, data);
    }
    // helper method for insert
    private Node insertRec(Node root, int data){
        if (root == null){
            root = new Node(data);
            return root;
        }
        if (data < root.data){
            root.left = insertRec(root.left, data);
        } else if (data > root.data){
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public boolean search(int data){
        return searchRec(root, data);
    }
    private boolean searchRec(Node root, int data){
        if (root == null){
            return false;
        }
        if (data == root.data){
            return true;
        } else if (data < root.data) {
            return searchRec(root.left, data);
        }else {
            return searchRec(root.right, data);
        }

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println(bst.search(60));
        System.out.println(bst.search(90));
    }
}
