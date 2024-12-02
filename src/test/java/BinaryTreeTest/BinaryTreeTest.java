package BinaryTreeTest;

import BinaryTree.BinaryTree;
import BinaryTree.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
    public void testShouldAddNodeBiggerThanRootToTreesRightBranch() {
        binaryTree.addNode(5);
        binaryTree.addNode(8);
        TreeNode rightNode = binaryTree.root.right;
        assertEquals(8 , rightNode.key);
    }


    @Disabled
    public void testShouldReturnOnlyNodeOfTreeAsAnArray() {
        binaryTree.addNode(5);

    }

}
