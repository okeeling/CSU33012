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
		if (!findPath(root, nodeOne, nodeOnePath) || !findPath(root, nodeTwo, nodeTwoPath)) {
			if(nodeOnePath.size() == 0 && nodeTwoPath.size() == 0) {
				if(!nodeOnePath.contains(nodeOne) && !nodeTwoPath.contains(nodeTwo)) {
					System.out.println("These nodes do not exist in the tree.");
				} else {
					System.out.println("The tree is empty.");
				}
			}
			if (nodeOnePath.size() > 0 && nodeTwoPath.size() == 0) {
				System.out.println("Node 1 is present but Node 2 is not present in the tree.");
			}
			if (nodeTwoPath.size() > 0 && nodeOnePath.size() == 0) {
				System.out.println("Node 2 is present but Node 1 is not present in the tree.");
			}
		}
		int index;
		for (index = 0; index < nodeOnePath.size() && index < nodeTwoPath.size(); index++) {
			if (!nodeOnePath.get(index).equals(nodeTwoPath.get(index))) {
				break;
			}
		}
		return nodeOnePath.get(index - 1);
	}
	
	private boolean findPath(Node root, int num, List<Integer> path) {
		if (root == null) {
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
