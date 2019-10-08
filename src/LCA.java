import java.util.ArrayList;

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
	ArrayList<Integer> pathOne = new ArrayList<>();
	ArrayList<Integer> pathTwo = new ArrayList<>();
	
	private int findLCA(Node root, int nodeOne, int nodeTwo) {
		return -1;
	}
	
}
