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
public BinaryTree duplicateTree;
public BinaryTree binaryTree10;
public ArrayList<Integer> testList;

    @BeforeEach
    public void setUp() {

        testList = new ArrayList<>();

        binaryTree = new BinaryTree();
        binaryTree10 = new BinaryTree();
        duplicateTree = new BinaryTree();

        binaryTree10.addNode(5);
        binaryTree10.addNode(2);
        binaryTree10.addNode(7);
        binaryTree10.addNode(3);
        binaryTree10.addNode(6);
        binaryTree10.addNode(4);
        binaryTree10.addNode(8);
        binaryTree10.addNode(9);
        binaryTree10.addNode(1);

        duplicateTree.addNode(5);
        duplicateTree.addNode(3);
        duplicateTree.addNode(2);
        duplicateTree.addNode(5);
        duplicateTree.addNode(3);


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
    public void testgetInOrderArrayShouldReturnOnlyNodeOfTreeAsAnArray() {
        binaryTree.addNode(5);
        ArrayList<Integer> testInOrder = binaryTree.getInOrderList();
        assertArrayEquals(new Integer[]{5}, testInOrder.toArray());
    }

    @Test
    public void testgetInOrderArrayShouldReturnInOrderArrayOfThreeNodesAddedinDescendingOrder() {
        binaryTree.addNode(5);
        binaryTree.addNode(3);
        binaryTree.addNode(2);

        testList = binaryTree.getInOrderList();
        assertArrayEquals(new Integer[]{2,3,5}, testList.toArray());
    }

    @Test
    public void testgetInOrderArrayShouldReturnInOrderArrayOfTenNodesAddedInRandomOrder() {
        testList = binaryTree10.getInOrderList();
        assertArrayEquals(new Integer[]{1,2,3,4,5,6,7,8,9}, testList.toArray());

    }

    @Test
    public void testgetInOrderArrayShouldReturnInOrderArrayOfFromBinaryTreeWithDuplicates() {

        testList = duplicateTree.getInOrderList();
        assertArrayEquals(new Integer[]{2,3,3,5,5}, testList.toArray());

    }

    @Test
    public void testgetPreOrderArrayShouldReturnOnlyNodeOfTreeAsAnArray() {
        binaryTree.addNode(5);
        testList = binaryTree.getPreOrderList();
        assertArrayEquals(new Integer[]{5}, testList.toArray());
    }


    @Test
    public void testgetPreOrderArrayShouldReturnPreOrderArrayOfTenNodesAddedInRandomOrder() {
        testList = binaryTree10.getPreOrderList();
        assertArrayEquals(new Integer[]{5,2,1,3,4,7,6,8,9}, testList.toArray());

    }

    @Test
    public void testGetPreOrderArrayShouldReturnPreOrderArrayOfFromBinaryTreeWithDuplicates() {
        testList = duplicateTree.getPreOrderList();
        assertArrayEquals(new Integer[]{5,3,2,3,5}, testList.toArray());
    }

    @Test
    public void gestGetPostOrderArrayShouldReturnOnlyNodeOfTreeAsAnArray() {
        binaryTree.addNode(5);
        testList = binaryTree.getPostOrderList();
        assertArrayEquals(new Integer[]{5}, testList.toArray());
    }

    @Test
    public void testgetPostOrderArrayShouldReturnPostOrderArrayOfTenNodesAddedInRandomOrder() {
        testList = binaryTree10.getPostOrderList();
        assertArrayEquals(new Integer[]{1, 4, 3, 2, 6, 9, 8, 7, 5}, testList.toArray());
    }

    @Test
    public void testGetPostOrderArrayShouldReturnPostOrderArrayOfFromBinaryTreeWithDuplicates() {
        testList = duplicateTree.getPostOrderList();
        assertArrayEquals(new Integer[]{3,2,5,3,5}, testList.toArray());
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
