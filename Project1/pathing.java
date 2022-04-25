import java.util.*;

public class pathing {
	initialize stasis = new initialize();
	// this class provides an object that is used to trace back the path from the
	// goal
	// it then prints the path
	List<board> path;
	logistics logi; // logi object is printing details about space and time cost

	public pathing(board initialNode, board goalNode, logistics inf) { // the arguments are goalNode, logi and
																		// intialNode so a path can be found.
		path = this.getPath(initialNode, goalNode);
		this.logi = inf;
	}

	private List<board> getPath(board initialNode, board goalNode) { 
		// given a goalNode and initialNode this method uses node's parents to trace it's way back up
		board tempNode = goalNode;
		List<board> list = new ArrayList<board>();

		while (!(tempNode.equals(initialNode))) {	//builds path from goal to initial state
			list.add(tempNode);
			tempNode = tempNode.getParent();

		}
		list.add(initialNode);
		return list; // a list of the path is returned in reverse order
	}

	public void printPath() { // this method enables us to print the path in correct order from start node to
								// goal node with sufficient details.
		int size = path.size();

		for (int i = size - 1; i >= 0; i--) {
			System.out.println();
			System.out.println("Direction Moved: " + path.get(i).getMov());
			System.out.println("Move #: " + path.get(i).getMoveCost());
			System.out.println();
			System.out.println("Current State");
			System.out.println(Arrays.deepToString(path.get(i).getMatrix()).replace("], ", "]\n").replace("[[", "[")
					.replace("]]", "]").replace(", ", "][")); //unholy amount of "replaces"
		
		}
		System.out.println("\nCompleted!");
	}
}
