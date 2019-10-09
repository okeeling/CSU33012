// Implement a function that can calculate the lowest common ancestor in a graph, that may be structured as a binary tree.

import java.util.ArrayList;
import java.util.List;

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
	List<Integer> nodeOnePath = new ArrayList<>();
	List<Integer> nodeTwoPath = new ArrayList<>();
	
	private int findLCA(Node root, int nodeOne, int nodeTwo) {
		return -1;
	}
	
	private boolean findPath(Node root, int num, List<Integer> path) {
		
		if(root == null) {
			
			return false;
			
		} else { 
			
			path.add(root.data);
			
			if (root.data == num) {
				return true;
			}
			
			if (root.left != null) {
				findPath(root.left, num, path);
			}
			
			if (root.right != null) {
				findPath(root.right, num, path);
			}
			
			path.remove(path.size() - 1);
			
			return false;
			
		}
		
	}
	
}
