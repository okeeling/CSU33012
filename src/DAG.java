import java.util.ArrayList;
import java.util.List;

class NodeDAG {
	int data;
	NodeDAG left;
	NodeDAG right;
	ArrayList<NodeDAG> ancestors; 
	 
	NodeDAG(int value) {
		data = value;
		left = right = null;
	  	ancestors = null;
	}
}

public class DAG {
	NodeDAG root;
	List<Integer> nodeOnePath = new ArrayList<>();
	List<Integer> nodeTwoPath = new ArrayList<>();
	
	private int findLCADAG(NodeDAG root, int nodeOne, int nodeTwo) {
		if(!findPathDAG(root, nodeOne, nodeOnePath) || !findPathDAG(root, nodeTwo, nodeTwoPath)) {
			if(nodeOnePath.size() == 0 && nodeTwoPath.size() == 0) {
				if(!nodeOnePath.contains(nodeOne) && !nodeTwoPath.contains(nodeTwo)) {
					System.out.println("These nodes do not exist in the tree.");
				} else {
					System.out.println("The tree is empty.");
				}
			}
			if(nodeOnePath.size() > 0 && nodeTwoPath.size() == 0) {
				System.out.println("Node 1 is present but Node 2 is not present in the tree.");
			}
			if(nodeTwoPath.size() > 0 && nodeOnePath.size() == 0) {
				System.out.println("Node 2 is present but Node 1 is not present in the tree.");
			}
			return -1;
		}
		int index;
		for(index = 0; index < nodeOnePath.size() && index < nodeTwoPath.size(); index++) {
			if(!nodeOnePath.get(index).equals(nodeTwoPath.get(index))) {
				break;
			}
		}
		return nodeOnePath.get(index - 1);
	}
	
	private boolean findPathDAG(NodeDAG root, int num, List<Integer> path) {
		if (root == null) {
			return false;	
		} else {
			path.add(root.data);
			if (root.data == num) {
				return true;
			}
			if (root.left != null && findPathDAG(root.left, num, path)) {
				return true;
			}
			if (root.right != null && findPathDAG(root.right, num, path)) {
				return true;
			}
			path.remove(path.size() - 1);
			return false;
		}
	}
	
	public void addToGraph(NodeDAG nodeOne) {
		nodeOne.ancestors = new ArrayList<NodeDAG>();
		nodeOne.ancestors.add(nodeOne);
	}
	
	public void addAncestorsToNode(NodeDAG nodeOne, NodeDAG nodeTwo) {
		int index;
		for(index = 0; index < nodeOne.ancestors.size(); index++) {
			if(!nodeTwo.ancestors.contains(nodeOne.ancestors.get(index))) {
				nodeTwo.ancestors.add(nodeOne.ancestors.get(index));
			}
		}
	 }
	 
	public void addAncestorToNode2(NodeDAG nodeOne, NodeDAG nodeTwo, int position) {
		int index;
		for(index=0; index < nodeOne.ancestors.size(); index++) {
			if(!nodeTwo.ancestors.contains(nodeOne.ancestors.get(index))) {
				nodeTwo.ancestors.add(position, nodeOne.ancestors.get(index));
			}
		}
	}
			
}
