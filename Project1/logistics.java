import java.util.*;

public class logistics {

	//class that is used for possible moves
	public Queue<board> queue;
	public HashMap<Integer, board> visited;

	public logistics() {
		queue = new LinkedList<board>();
		visited = new HashMap<Integer, board>();
	}

}
