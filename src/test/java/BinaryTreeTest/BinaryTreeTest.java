package BinaryTreeTest;

import BinaryTree.BinaryTree;
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
        assertEquals(5 ,binaryTree.root.getKey());
    }


    @Disabled
    public void testShouldReturnOnlyNodeOfTreeAsAnArray() {
        binaryTree.addNode(5);

    }

}
