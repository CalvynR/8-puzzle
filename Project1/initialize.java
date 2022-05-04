
public class initialize {
	public int[][] initial = new int[3][3]; // state to start puzzle with
	public int[][] end_state = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } }; // when the game is finished
	public int[][] current = new int[3][3]; // the current state of the board, starts out the same as the initial state
											// but will be the matrix that is changed

	public void creation() {

		// loop for inputting a different initial state
		/*
		 * Scanner initial_state = new Scanner (System.in); for (int i = 0; i <
		 * initial.length; i++) { for (int j = 0; j < initial[i].length; j++) { int var
		 * = initial_state.nextInt(); initial[i][j] = var;}}
		 */

		// Filling out initial state, for easy testing and running
		initial[0][0] = 1;initial[0][1] = 4;initial[0][2] = 2;
		initial[1][0] = 3;initial[1][1] = 7;initial[1][2] = 5;
		initial[2][0] = 0;initial[2][1] = 6;initial[2][2] = 8;
		// setting current state = to initial state
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				current[i][j] = initial[i][j];
			}
		}
		initPrint();
		board currentNode = new board(current);	//instances local to creation
		BFS start = new BFS(currentNode);
		start.search();				//changed to "start" from "sample_space" in github, if nonfunctional, revert back

	}

//Method to print out initial state
	public void initPrint() {
		System.out.println("Initial State: ");
		for (int i = 0; i < initial.length; i++) {
			for (int j = 0; j < initial[i].length; j++) {
				System.out.print("[" + initial[i][j] + "]");
				if (j == 2) {
					System.out.println();
				}
			}
		}
	}

//method to print out current state
	public void currPrint() {
		System.out.println("Current State: ");
		for (int i = 0; i < current.length; i++) {
			for (int j = 0; j < current[i].length; j++) {
				System.out.print("[" + current[i][j] + "]");
				if (j == 2) {
					System.out.println();
				}
			}
		}
	}

//method to print out end/goal state
	public void endPrint() {
		System.out.println("End State: ");
		for (int i = 0; i < end_state.length; i++) {
			for (int j = 0; j < end_state[i].length; j++) {
				System.out.print("[" + end_state[i][j] + "]");
				if (j == 2) {
					System.out.println();
				}
			}
		}
	}

	public void setInit(int[][] init) {
		this.initial = init;
	}

	public void setCurr(int[][] curr) {
		this.current = curr;
	}

	public void setEnd(int[][] end) {
		this.end_state = end;
	}

	public int[][] getInit() {
		return initial;
	}

	public int[][] getCurr() {
		return current;
	}

	public int[][] getEnd() {
		return end_state;
	}
}
