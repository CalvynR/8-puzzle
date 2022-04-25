import java.util.*;

public class BFS {

	initialize stasis = new initialize();
	private board initialNode;

	public BFS(board node) {
		this.initialNode = node;
	}

	public boolean search() {

		logistics logi = new logistics(); // a class that has the visited HashMap

		board node = initialNode;
		logi.queue.add(node); // start Node is added to queue

		while (!(logi.queue.isEmpty())) { // loop keeps going as long as queue is not empty
			node = logi.queue.remove(); // remove or pop the node
			logi.visited.put(node.hashCode(), node); // places node in visited hashMap
			if (node.isFinished()) { // if goal is found, a path is created and a path is printed
				pathing p = new pathing(initialNode, node, logi);
				p.printPath();
				stasis.setCurr(node.getMatrix());
				return true;
			}

			steps s = new steps(); // function that provides node's children
			List<board> list = s.stepper(node);
			for (board temp : list) {
				boolean key = logi.visited.containsKey(temp.hashCode());
				if (key == false) {
					if (!(logi.queue.contains(temp))) {
						logi.queue.add(temp);
						
					}
				}
			}

		}

		return false;
	}

}