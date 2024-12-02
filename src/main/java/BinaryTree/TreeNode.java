package BinaryTree;

public class TreeNode {

        int key;
        TreeNode left;
        TreeNode right;

    public TreeNode (int key) {
        this.key = key;
        left = null;
        right = null;
    }

    /**
     * @return Treenode's key value
     */
    public int getKey() {
        return this.key;
    }
}
