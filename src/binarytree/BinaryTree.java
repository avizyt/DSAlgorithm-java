package binarytree;

import com.sun.source.tree.Tree;

public class BinaryTree {
    TreeNode root;

    BinaryTree() {
        root = null;
    }

    void insert(int val) {
        root = insertRec(root, val);
    }

    private TreeNode insertRec(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (val < root.val) {
            root.left = insertRec(root.left, val);
        } else if (val > root.val) {
            root.right = insertRec(root.right, val);
        }

        return root;
    }

    // Utility function to print the decorative tree
    void displayTree() {
        printDecorativeTree(root, "", true);
    }

    private void printDecorativeTree(TreeNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.val);
            printDecorativeTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printDecorativeTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    void preOrderTraversal(TreeNode root){
        if (root != null){
            System.out.print(root.val + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    void  postOrderTraversal(TreeNode root){
        if (root != null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }

    int treeHeight(TreeNode root){
        if (root == null){
            return -1;
        }
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    void mirror(TreeNode root){
        if (root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirror(root.left);
            mirror(root.right);
        }
    }

    boolean search(TreeNode root, int val){
        if (root == null){
            return false;
        }
        if (val == root.val){
            return true;
        }else if (val < root.val){
            return search(root.left, val);
        }else {
            return search(root.right, val);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);

        tree.displayTree();

        System.out.println("Inorder traversal of the binary tree:");
        System.out.println(tree.treeHeight(tree.root));
        System.out.println(tree.search(tree.root, 6));
    }
}
