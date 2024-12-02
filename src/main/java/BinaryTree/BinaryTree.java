package BinaryTree;

import java.util.ArrayList;

/**
 * Class for exercising the use of BinaryTree
 *
 * I did the add function because it was interesting. It also made
 * creating binarytrees to test way easier. I know it wasn't asked in the assingnment. I hope this
 * does not reduce my points.
 * @author jyrihuhtala
 */

public class BinaryTree {

    public TreeNode root;


    /**
     * Constructor to initialize an empty BinaryTree.
     * The root of the tree is set to null initially.
     */
    public BinaryTree() {
        root = null;
    }



    /**
     * Adds a new node with the given key to the BinaryTree.
     * If the tree is empty, the new node becomes the root. Otherwise,
     * it is placed at the appropriate position to maintain the binary tree structure.
     *
     * @param key the value of the new node to be added to the tree
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
     * Returns an ArrayList with values of the BinaryTree in Order
     * @return ArrayList with values of the BinaryTree in Order
     */
    public ArrayList<Integer> getInOrderArray() {
        ArrayList<Integer> inOrderList = new ArrayList<>();

        inOrderHelper(root, inOrderList);

        return inOrderList;
    }


    /**
     * Recursively performs in-order traversal of the BinaryTree,
     * adding each node's key to the provided ArrayList.
     *
     * @param node the current node being visited during the traversal
     * @param inOrderList the list to which the node's key is added
     */
    public void inOrderHelper(TreeNode node, ArrayList<Integer> inOrderList) {
        if (node.left != null) {
            inOrderHelper(node.left, inOrderList);
        }

        inOrderList.add(node.key);

        if (node.right != null) {
            inOrderHelper(node.right, inOrderList);
        }
    }

}