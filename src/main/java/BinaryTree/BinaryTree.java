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
        else {
            addHelper(key, root);
        }
    }

    /**
     * Helper function to recursively travel the BinaryTree to a place where new TreeNode should be added.
     * @param key keyvalue of the TreeNode to be added
     * @param root comparable TreeNode
     */
    public void addHelper(int key, TreeNode root) {
        if (key <= root.key) {
            if (root.left == null) {
                root.left = new TreeNode(key);
            }
            else {
                addHelper(key, root.left);
            }
        }else if (key > root.key) {
            if (root.right == null) {
                root.right = new TreeNode(key);
            }
            else {
                addHelper(key, root.right);
            }
        }


    }

    /**
     * @return root of the BinaryTree
     */
    public TreeNode getRoot() {
        return root;
    }
}
