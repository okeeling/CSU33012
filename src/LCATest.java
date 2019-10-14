import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LCATest {

	@Test
	public void testEmptyTree() {
		LCA tree = new LCA();
		assertEquals("Lowest common ancestor of empty tree:", -1, tree.functionLCA(0, 0));
	}

}
