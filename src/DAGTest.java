import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DAGTest {

	@Test
	public void testEmptyTree() {
		DAG tree = new DAG();
		assertEquals("LCA of empty tree:", -1, tree.functionLCADAG(0, 0));
	}
	
	@Test
	public void testOneNodeTree() {
		DAG tree = new DAG();
		tree.root = new NodeDAG(1);
		assertEquals("LCA of a one node tree:", -1, tree.functionLCADAG(1, 0));
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
	public void testThirteenNodeTree() {
		DAG tree = new DAG();
		tree.root = new NodeDAG(1);
		tree.root.left = new NodeDAG(2);
		tree.root.right = new NodeDAG(3);
		tree.root.left.left = new NodeDAG(4);
		tree.root.left.right = new NodeDAG(5);
		tree.root.right.left = new NodeDAG(6);
		tree.root.right.right = new NodeDAG(7);
		tree.root.left.left.left = new NodeDAG(8);
		tree.root.left.left.right = new NodeDAG(9);
		tree.root.left.right.left = new NodeDAG(10);
		tree.root.left.right.right = new NodeDAG(11);
		tree.root.right.left.left = new NodeDAG(12);
		tree.root.right.left.right = new NodeDAG(13);
		assertEquals("LCA of 1 and 12:", 1, tree.functionLCADAG(1,12));
		assertEquals("LCA of 2 and 3:", 1, tree.functionLCADAG(2,3));
		assertEquals("LCA of 12 and 13:", 6, tree.functionLCADAG(12,13));
		assertEquals("LCA of 8 and 9:", 4, tree.functionLCADAG(8,9));
		assertEquals("LCA of 4 and 13:", 1, tree.functionLCADAG(4,13));
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
	
	@Test
	public void testSameNodes(){
		DAG tree = new DAG();
		tree.root = new NodeDAG(4);
		tree.root.left = new NodeDAG(4);
		tree.root.right = new NodeDAG(4);
		tree.root.left.left = new NodeDAG(4);
		tree.root.left.right = new NodeDAG(4);
		tree.root.right.left = new NodeDAG(4);
		tree.root.right.right = new NodeDAG(4);
		assertEquals("LCA of 4 and 4: ", 4, tree.functionLCADAG(4, 4));
	}
	
	@Test 
	public void unevenTree() { 
		DAG tree = new DAG();
		tree.root = new NodeDAG(1);
		tree.root.right = new NodeDAG(2);
		tree.root.right.right = new NodeDAG(3);
		assertEquals("LCA of 2 and 3: ", 2, tree.functionLCADAG(2, 3));	
		assertEquals("LCA of 3 and 1: ", 1, tree.functionLCADAG(3, 1));
	}
	
	@Test
	public void testDAG1() {
	
//      1
//      |
//      ^
//	    |
//	    2 --<-- 3
//	    |       |
//	    ^       ^
//	    |       |
//	    4       5
//       \      /
//        ^    ^
//          \ /
//           6
		
		DAG graph = new DAG();
		NodeDAG root = new NodeDAG(1);
		NodeDAG nodeTwo = new NodeDAG(2);
		NodeDAG nodeThree = new NodeDAG(3);
		NodeDAG nodeFour = new NodeDAG(4);
		NodeDAG nodeFive = new NodeDAG(5);
		NodeDAG nodeSix = new NodeDAG(6);
		graph.addToGraph(root);
		graph.addToGraph(nodeTwo);
		graph.addToGraph(nodeThree);
		graph.addToGraph(nodeFour);
		graph.addToGraph(nodeFive);
		graph.addToGraph(nodeSix);
		graph.addAncestorsToNode(root, nodeTwo);
		graph.addAncestorsToNode(nodeTwo, nodeThree);
		graph.addAncestorsToNode(nodeTwo, nodeFour);
		graph.addAncestorsToNode(nodeThree, nodeFive);
		graph.addAncestorsToNode(nodeFive, nodeSix);
		graph.addAncestorToNode2(nodeFour, nodeSix, 1);
		assertEquals(5, graph.findLCADAG2(root, nodeSix, nodeFive));
		assertEquals(4, graph.findLCADAG2(root, nodeSix, nodeFour));
		assertEquals(3, graph.findLCADAG2(root, nodeSix, nodeThree));
		assertEquals(2, graph.findLCADAG2(root, nodeFour, nodeFive));
		assertEquals(2, graph.findLCADAG2(root, nodeSix, nodeTwo));
		assertEquals(1, graph.findLCADAG2(root, nodeTwo, root));
		assertEquals(1, graph.findLCADAG2(root, root, root));
	}

	@Test
	public void testDAG2() {
	
	//             3
	//            / \
	//           ^   V
	//          /     \
	//   1 ->- 2  ->-  5
	//          \     / \
	//           V   ^   V
	//            \ /     \
	//             4       6
	//            /
	//           ^
	//          /
	//         7
	
		DAG graph = new DAG();
		NodeDAG root = new NodeDAG(1);
		NodeDAG nodeTwo = new NodeDAG(2);
		NodeDAG nodeThree = new NodeDAG(3);
		NodeDAG nodeFour = new NodeDAG(4);
		NodeDAG nodeFive = new NodeDAG(5);
		NodeDAG nodeSix = new NodeDAG(6);
		NodeDAG nodeSeven = new NodeDAG(7);
		graph.addToGraph(root);
		graph.addToGraph(nodeTwo);
		graph.addToGraph(nodeThree);
		graph.addToGraph(nodeFour);
		graph.addToGraph(nodeFive);
		graph.addToGraph(nodeSix);
		graph.addToGraph(nodeSeven);
		graph.addAncestorsToNode(nodeSix, nodeFive);
		graph.addAncestorsToNode(nodeThree, nodeTwo);	
		graph.addAncestorsToNode(nodeFour, nodeTwo);
		graph.addAncestorsToNode(nodeFive, nodeThree);
		graph.addAncestorsToNode(nodeFive, nodeFour);
		graph.addAncestorsToNode(nodeFive, nodeTwo);
		graph.addAncestorsToNode(nodeTwo, root);
		graph.addAncestorsToNode(nodeFour, nodeSeven);
		assertEquals(4, graph.findLCADAG2(nodeSix, root, nodeSeven));
		assertEquals(5, graph.findLCADAG2(nodeSix, nodeThree, nodeSeven));
		assertEquals(6, graph.findLCADAG2(nodeSix, nodeFive, nodeSix));
		assertEquals(5, graph.findLCADAG2(nodeSix, nodeThree, nodeFour));
		assertEquals(4, graph.findLCADAG2(nodeSix, nodeTwo, nodeSeven));
		assertEquals(2, graph.findLCADAG2(nodeSix, root, nodeTwo));
		assertEquals(6,	graph.findLCADAG2(nodeSix, nodeSix, nodeSix));
	}
	
	@Test
	public void testEmptyGraph() {
		DAG graph = new DAG();
		assertEquals(-1, graph.findLCADAG2(null, null, null));
	}
	
	@Test
	public void testGraphOneNode() {
		DAG graph = new DAG();
		NodeDAG node = new NodeDAG(1);
		graph.addToGraph(node);
		assertEquals(1, graph.findLCADAG2(node, node, node));
	}
}
