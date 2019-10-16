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
			
}
