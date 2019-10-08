import java.util.ArrayList;
import java.util.List;

// Implement a function that can calculate the lowest common ancestor in a graph, that may be structured as a binary tree.

class Node {
	int data;
	Node left;
	Node right;
	
	Node(int value) {
		data = value;
		left = right = null;
	}
}

public class LCA {
	
	Node root;
	List<Integer> pathOne = new ArrayList<>();
	List<Integer> pathTwo = new ArrayList<>();
	
	private int findLCA(Node root, int nodeOne, int nodeTwo) {
		return -1;
	}
	
	private boolean findPath(Node root, int number, ArrayList<Integer> path) {
		return false;
	}
	
}
