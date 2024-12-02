package BinaryTree;

public class BinaryTree {

    public TreeNode root;

    public BinaryTree() {
        root = null;
    }

    /**
     * Adds node to a BinaryTree
     */
    public void addNode(int key) {
        if (root == null) {
            root = new TreeNode(key);
        }
        if (key < root.key) {
            root.left = new TreeNode(key);
        }
        if (key > root.key) {
            root.right = new TreeNode(key);
        }
    }

    /**
     * @return root of the BinaryTree
     */
    public TreeNode getRoot() {
        return root;
    }
}
