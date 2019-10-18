import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class LCATest {

	@Test
	public void testEmptyTree() {
		LCA tree = new LCA();
		assertEquals("LCA of empty tree:", -1, tree.functionLCA(0, 0));
	}
	
	@Test
	public void testOneNodeTree() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		assertEquals("LCA of a one node tree:", -1, tree.functionLCA(1, 0));
	}
	
	@Test
	public void testSevenNodeTree() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		assertEquals("LCA of 1 and 2:", 1, tree.functionLCA(1, 2));
		assertEquals("LCA of 2 and 3:", 1, tree.functionLCA(2, 3));
		assertEquals("LCA of 2 and 4:", 2, tree.functionLCA(2, 4));
		assertEquals("LCA of 4 and 5:", 2, tree.functionLCA(4, 5));
		assertEquals("LCA of 6 and 7:", 3, tree.functionLCA(6, 7));	
	}
	
	@Test
	public void testThirteenNodeTree() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(11);
		tree.root.right.left.left = new Node(12);
		tree.root.right.left.right = new Node(13);
		assertEquals("LCA of 1 and 12: ", 1, tree.functionLCA(1, 12));
		assertEquals("LCA of 2 and 3: ", 1, tree.functionLCA(2, 3));
		assertEquals("LCA of 12 and 13: ", 6, tree.functionLCA(12, 13));
		assertEquals("LCA of 8 and 9: ", 4, tree.functionLCA(8, 9));
		assertEquals("LCA of 4 and 13: ", 1, tree.functionLCA(4, 13));
	}
	
	@Test
	public void testNonExistentNode() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		assertEquals("LCA of 4 and 41:", -1, tree.functionLCA(4, 41));
		assertEquals("LCA of 2 and 785:", -1, tree.functionLCA(2, 785));
	}
	
	@Test
	public void testOutOfOrder() {
		LCA tree = new LCA();
		tree.root = new Node(50);
		tree.root.left = new Node(30);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(40);
		tree.root.left.right = new Node(70);
		tree.root.right.left = new Node(20);
		tree.root.right.right = new Node(60);
		assertEquals("LCA of tree is out of order", 50, tree.functionLCA(60, 40));
		assertEquals("LCA of tree is out of order", 30, tree.functionLCA(30, 40));
		assertEquals("LCA of tree is out of order", 10, tree.functionLCA(60, 20));
		assertEquals("LCA of tree is out of order", 50, tree.functionLCA(70, 20));
	}
	
	@Test
	public void testSameNodes() {
		LCA tree = new LCA();
		tree.root = new Node(4);
		tree.root.left = new Node(4);
		tree.root.right = new Node(4);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(4);
		tree.root.right.right = new Node(4);
		assertEquals("LCA of 4 and 4: ", 4, tree.functionLCA(4, 4));
	}
	
	@Test 
	public void unevenTree() { 
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.right = new Node(2);
		tree.root.right.right = new Node(3);
		assertEquals("LCA of uneven tree:", 2, tree.functionLCA(2, 3));	
		assertEquals("LCA of uneven tree:", 1, tree.functionLCA(3, 1));
	}
}

