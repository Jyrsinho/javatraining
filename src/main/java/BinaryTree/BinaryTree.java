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
        } else {
            addHelper(key, root);
        }
    }

    /**
     * Helper function to recursively travel the BinaryTree to a place where new TreeNode should be added.
     *
     * @param key  keyvalue of the TreeNode to be added
     * @param root comparable TreeNode
     */
    public void addHelper(int key, TreeNode root) {
        if (key <= root.key) {
            if (root.left == null) {
                root.left = new TreeNode(key);
            } else {
                addHelper(key, root.left);
            }
        } else if (key > root.key) {
            if (root.right == null) {
                root.right = new TreeNode(key);
            } else {
                addHelper(key, root.right);
            }
        }
    }

    /**
     * Prints the Binary Tree In Order
     */
    public void printBinaryTree(String order) {
        ArrayList<Integer> printList = new ArrayList<>();

        switch (order) {
            case "preorder":
                printList = getPreOrderList();
                break;
            case "inorder":
                printList = getInOrderList();
                break;
            case "postorder":
                printList = getPostOrderList();
                break;
            default:
                break;
        }

        for (Integer i : printList) {
            System.out.print(i + ", ");
        }
    }


    /**
     * Returns an ArrayList with values of the BinaryTree in Order
     *
     * @return ArrayList with values of the BinaryTree in Order
     */
    public ArrayList<Integer> getInOrderList() {
        // create an arraylist to store the key values of the Binary Tree's Nodes
        ArrayList<Integer> inOrderList = new ArrayList<>();
        // calls helper function to recursively go through the BinaryTree in Order.
        inOrderHelper(root, inOrderList);

        return inOrderList;
    }


    /**
     * Recursively performs in-order traversal of the BinaryTree,
     * adding each node's key to the provided ArrayList.
     *
     * @param node        the current node being visited during the traversal
     * @param inOrderList the list to which the node's key is added
     */
    public void inOrderHelper(TreeNode node, ArrayList<Integer> inOrderList) {
        // move left in the BinaryTree until we find the leftmost Node
        if (node.left != null) {
            inOrderHelper(node.left, inOrderList);
        }

        // Add Node's key value to the arraylist
        inOrderList.add(node.key);

        // move right in the BinaryTree until we find the rightmost Node
        if (node.right != null) {
            inOrderHelper(node.right, inOrderList);
        }
    }


    /**
     * Returns an ArrayList with values of the BinaryTree in PreOrder
     *
     * @return ArrayList with values of the BinaryTree in PreOrder
     */
    public ArrayList<Integer> getPreOrderList() {
        // create an arraylist to store the key values of the Binary Tree's Nodes
        ArrayList<Integer> preOrderList = new ArrayList<>();
        // calls helper function to recursively go through the BinaryTree in PreOrder.
        preOrderHelper(root, preOrderList);

        return preOrderList;

    }

    /**
     * Recursively performs pre-order traversal of the BinaryTree,
     * adding each node's key to the provided ArrayList.
     *
     * @param node         the current node being visited during the traversal
     * @param preOrderList the list to which the node's key is added
     */
    public void preOrderHelper(TreeNode node, ArrayList<Integer> preOrderList) {
        // Add Node's key value to the arraylist
        preOrderList.add(node.key);

        // move left in the BinaryTree until we find the leftmost Node
        if (node.left != null) {
            preOrderHelper(node.left, preOrderList);
        }


        // move right in the BinaryTree until we find the rightmost Node
        if (node.right != null) {
            preOrderHelper(node.right, preOrderList);
        }
    }


    /**
     * Returns an ArrayList with values of the BinaryTree in Post Order
     *
     * @return ArrayList with values of the BinaryTree in Post Order
     */
    public ArrayList<Integer> getPostOrderList() {
        // create an arraylist to store the key values of the Binary Tree's Nodes
        ArrayList<Integer> postOrderList = new ArrayList<>();
        // calls helper function to recursively go through the BinaryTree in Order.
        postOrderHelper(root, postOrderList);

        return postOrderList;
    }


    /**
     * Recursively performs post-order traversal of the BinaryTree,
     * adding each node's key to the provided ArrayList.
     *
     * @param node          the current node being visited during the traversal
     * @param postOrderList the list to which the node's key is added
     */
    public void postOrderHelper(TreeNode node, ArrayList<Integer> postOrderList) {
        // move left in the BinaryTree until we find the leftmost Node
        if (node.left != null) {
            postOrderHelper(node.left, postOrderList);
        }

        // move right in the BinaryTree until we find the rightmost Node
        if (node.right != null) {
            postOrderHelper(node.right, postOrderList);
        }

        postOrderList.add(node.key);
    }


    /**
     * Class for Nodes of the Binary Tree
     */
    public static class TreeNode {

        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        System.out.println("Intialiazed empty Binary Tree");
        System.out.println();

        int [] values = {5,3,2,4,7,6,9,10,1,8} ;
        for (int value : values) {
            System.out.println("Added to the BinaryTree Node with value: " + value);
            binaryTree.addNode(value);
        }

        System.out.println();
        System.out.println("Printing Binary Tree InOrder: ");
        binaryTree.printBinaryTree("inorder");
        System.out.println();

        System.out.println("Printing Binary Tree  PostOrder: ");
        binaryTree.printBinaryTree("postorder");
        System.out.println();

        System.out.println("Printing Binary Tree PreOrder: ");
        binaryTree.printBinaryTree("preorder");
    }
}
