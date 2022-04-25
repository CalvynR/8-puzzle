import java.util.*;

public class steps {

	public steps() {
	}

	public List<board> stepper(board node) {
		// stepper function that takes a state and returns a list of possible states that can be reached

		List<board> list = new ArrayList<board>();

		int x = node.getEmptyX();
		int y = node.getEmptyY();
		// System.out.println(node.stringBoard()); used for testing

		// a child is created if the zero tile can move the respective direction
		// up
		if ((y != 0 || y != 1 || y != 2) && (x != 0)) {
			board upNode = node.createChild(x - 1, y);
			upNode.setMov(Move.Up);
			list.add(upNode);
		}

		// down
		if ((y != 0 || y != 1 || y != 2) && (x != 2)) {
			board downNode = node.createChild(x + 1, y);
			downNode.setMov(Move.Down);
			list.add(downNode);
		}
		// left
		if ((x != 0 || x != 1 || x != 2) && (y != 0)) {
			board leftNode = node.createChild(x, y - 1);
			leftNode.setMov(Move.Left);
			list.add(leftNode);
		}

		// right
		if ((x != 0 || x != 1 || x != 2) && (y != 2)) {
			board rightNode = node.createChild(x, y + 1);
			rightNode.setMov(Move.Right);
			list.add(rightNode);
		}

		return list; // a list of children is returned.

	}
}
