package binarytree;

public class BinaryTree {
    Tree root;

    BinaryTree() {
        root = null;
    }

    void insert(int val) {
        root = insertRec(root, val);
    }

    private Tree insertRec(Tree root, int val) {
        if (root == null) {
            root = new Tree(val);
            return root;
        }

        if (val < root.val) {
            root.left = insertRec(root.left, val);
        } else if (val > root.val) {
            root.right = insertRec(root.right, val);
        }

        return root;
    }

    void inorderTraversal(Tree root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);

        System.out.println("Inorder traversal of the binary tree:");
        tree.inorderTraversal(tree.root);
    }
}
