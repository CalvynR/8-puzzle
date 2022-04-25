import java.util.*;

public class board {
	initialize stasis = new initialize();
	private int emptyX;
	private int emptyY;
	private board parent;
	private int moveCost;
	private int[][] state = stasis.current;
	private List<board> children;
	private Move moves;
	private String stringState;

	public board(int[][] state) {
		this.state = state; // the state
		this.moveCost = 1; // the moveCost
		this.children = new ArrayList<board>(); // the children of the node
		this.parent = null;

		this.stringState = stringBoard();
		this.moves = null;
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (state[i][j] == 0) {
					this.emptyX = i;
					this.emptyY = j;
					break;
				}
			}
		}
	}

	public void addChild(board child) { // adding Child to node
		child.setParent(this);
		child.setMoveCost(this.getMoveCost() + 1);
		this.children.add(child);
	}

	public boolean isFinished() { // checking if the board is complete
		boolean result = false;

		int[][] endState = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
		board endNode = new board(endState);

		result = this.equals(endNode);
		return result;
	}

	public board createChild(int a, int b) { // creating the child or possible states from current state
		int temp[][] = new int[state.length][state.length];
		for (int i = 0; i < state.length; i++)
			for (int j = 0; j < state[i].length; j++)
				temp[i][j] = state[i][j];
		temp[emptyX][emptyY] = temp[a][b];
		temp[a][b] = 0;
		board child = new board(temp);
		addChild(child); // adding Child to parent
		return child;
	}

	public String stringBoard() { // method that returns a String version of the board
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state[i].length; j++) {
				sb.append(state[i][j]);
			}
		}
		return sb.toString();
	}

	@Override
	public boolean equals(Object object) { // checks if string values of board are equal
		if (!(object instanceof board)) {  //works by comparing
			return false;
		}								   	
		board check = (board) object;
		return check.getString().equals(this.getString());
	}

	public int getX(int value) { // getting the X of a value in goalState
		int x = 0;
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (stasis.end_state[i][j] == value) {
					x = i;
				}
			}
		}
		return x;
	}
	
	// getters and setters for respective name
	public String getString() { // getting String version of Board
		return stringState;
	}

	public void setParent(board parent) {
		this.parent = parent;
	}

	public board getParent() {
		return parent;
	}

	public void setMoveCost(int moveCost) {
		this.moveCost = moveCost;
	}

	public int getMoveCost() {
		return moveCost;
	}

	public int getEmptyX() {
		return emptyX;
	}

	public int getEmptyY() {
		return emptyY;
	}

	public int[][] getMatrix() {
		return state;
	}

	public List<board> getChildren() {
		return children;
	}

	public void setChildren(List<board> childrens) {
		this.children = childrens;
	}

	public void setMov(Move d) {
		this.moves = d;
	}

	public Move getMov() {
		return moves;
	}

}