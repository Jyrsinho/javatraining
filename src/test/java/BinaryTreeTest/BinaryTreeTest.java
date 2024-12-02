package BinaryTreeTest;

import BinaryTree.BinaryTree;
import BinaryTree.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeTest {

public BinaryTree binaryTree;

    @BeforeEach
    public void setUp() {
        binaryTree = new BinaryTree();
    }

    @Test
    public void testShouldAddNodesToBinaryTree() {
        binaryTree.addNode(5);
        assertEquals(5 ,binaryTree.root.key);
    }

    @Test
    public void testShouldAddNodeSmallerThanRootToBinaryTreesLeftBranch() {
        binaryTree.addNode(5);
        binaryTree.addNode(3);
        TreeNode leftNode = binaryTree.root.left;
        assertEquals(3 , leftNode.key);
    }

    @Test
    public void testShouldAddNodeSameSizeASRootToTreesLeftBranch() {
        binaryTree.addNode(5);
        binaryTree.addNode(5);
        TreeNode leftNode = binaryTree.root.left;
        assertEquals(5 , leftNode.key);
    }

    @Test
    public void testShouldAddNodeBiggerThanRootToTreesRightBranch() {
        binaryTree.addNode(5);
        binaryTree.addNode(8);
        TreeNode rightNode = binaryTree.root.right;
        assertEquals(8 , rightNode.key);
    }

    @Test
    public void testShouldAdTwoNodesSmallerThanRootToTheLeftBranch() {
        binaryTree.addNode(5);
        binaryTree.addNode(3);
        binaryTree.addNode(2);
        TreeNode leftNode = binaryTree.root.left;
        TreeNode leftMostNode = binaryTree.root.left.left;

        assertEquals(3, leftNode.key);
        assertEquals(2 , leftMostNode.key);
    }

    @Test
    public void testShouldAddThreeNodesLargerThanRootToTheRightBranch() {
        binaryTree.addNode(5);
        binaryTree.addNode(8);
        binaryTree.addNode(10);
        binaryTree.addNode(12);
        TreeNode rightmostNode = GetRightMostNode(binaryTree.root);
        assertEquals(12 , rightmostNode.key);
    }


    @Test
    public void testShouldReturnOnlyNodeOfTreeAsAnArray() {
        binaryTree.addNode(5);
        ArrayList<Integer> testInOrder = binaryTree.getInOrderArray();
        assertArrayEquals(new Integer[]{5}, testInOrder.toArray());
    }

    @Test
    public void testShouldReturnInOrderArrayOfThreeNodesAddedinDescendingOrder() {
        binaryTree.addNode(5);
        binaryTree.addNode(3);
        binaryTree.addNode(2);

        ArrayList<Integer> testInOrder = binaryTree.getInOrderArray();
        assertArrayEquals(new Integer[]{2,3,5}, testInOrder.toArray());
    }


// --------------------------------------------------------------------------------------------------------------------

    /**
     * Returns the leftmost Node in the BinaryTree
     * @param root root of the tree
     * @return the leftmost Node in the BinaryTree
     */
    public static TreeNode GetLeftMostNode(TreeNode root) {
        TreeNode currentNode = root;
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    /**
     * Returns the rightmost Node in the BinaryTree
     * @param root of the tree
     * @return the rightmost Node in the BinaryTree
     */
    public static TreeNode GetRightMostNode(TreeNode root) {
        TreeNode currentNode = root;
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode;
    }

}
