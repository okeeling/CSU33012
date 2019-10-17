import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DAGTest {

	@Test
	public void testEmptyTree() {
		DAG tree = new DAG();
		assertEquals("Lowest common ancestor of empty tree:", -1, tree.functionLCADAG(0, 0));
	}
	
	@Test
	public void testOneNodeTree() {
		DAG tree = new DAG();
		tree.root = new NodeDAG(1);
		assertEquals("Lowest common ancestor of a one node tree:", -1, tree.functionLCADAG(1, 0));
	}
	
	@Test
	public void testSevenNodeTree() {
		DAG tree = new DAG();
		tree.root = new NodeDAG(1);
		tree.root.left = new NodeDAG(2);
		tree.root.right = new NodeDAG(3);
		tree.root.left.left = new NodeDAG(4);
		tree.root.left.right = new NodeDAG(5);
		tree.root.right.left = new NodeDAG(6);
		tree.root.right.right = new NodeDAG(7);
		assertEquals("LCA of 1 and 2:", 1, tree.functionLCADAG(1, 2));
		assertEquals("LCA of 2 and 3:", 1, tree.functionLCADAG(2, 3));
		assertEquals("LCA of 2 and 4:", 2, tree.functionLCADAG(2, 4));
		assertEquals("LCA of 4 and 5:", 2, tree.functionLCADAG(4, 5));
		assertEquals("LCA of 6 and 7:", 3, tree.functionLCADAG(6, 7));	
	}
	
	@Test
	public void testNonExistentNode() {
		DAG tree = new DAG();
		tree.root = new NodeDAG(1);
		tree.root.left = new NodeDAG(2);
		tree.root.right = new NodeDAG(3);
		tree.root.left.left = new NodeDAG(4);
		tree.root.left.right = new NodeDAG(5);
		tree.root.right.left = new NodeDAG(6);
		tree.root.right.right = new NodeDAG(7);
		assertEquals("LCA of 4 and 41:", -1, tree.functionLCADAG(4, 41));
		assertEquals("LCA of 2 and 785:", -1, tree.functionLCADAG(2, 785));
	}
	
	@Test
	public void testOutOfOrder() {
		DAG tree = new DAG();
		tree.root = new NodeDAG(50);
		tree.root.left = new NodeDAG(30);
		tree.root.right = new NodeDAG(10);
		tree.root.left.left = new NodeDAG(40);
		tree.root.left.right = new NodeDAG(70);
		tree.root.right.left = new NodeDAG(20);
		tree.root.right.right = new NodeDAG(60);
		assertEquals("LCA of tree is out of order", 50, tree.functionLCADAG(60, 40));
		assertEquals("LCA of tree is out of order", 30, tree.functionLCADAG(30, 40));
		assertEquals("LCA of tree is out of order", 10, tree.functionLCADAG(60, 20));
		assertEquals("LCA of tree is out of order", 50, tree.functionLCADAG(70, 20));
	}
}
