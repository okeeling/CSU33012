import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LCATest {

	@Test
	public void testEmptyTree() {
		LCA tree = new LCA();
		assertEquals("Lowest common ancestor of empty tree:", -1, tree.functionLCA(0, 0));
	}
	
	@Test
	public void testOneNodeTree() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		assertEquals("Lowest common ancestor of a one node tree:", -1, tree.functionLCA(0, 0));
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
}
