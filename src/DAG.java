import java.util.ArrayList;

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

}
