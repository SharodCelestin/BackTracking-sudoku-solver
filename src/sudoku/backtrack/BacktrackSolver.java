/**
 * This material is based upon work supported by 
 * the National Science Foundation under Grant No. 1140753.
 */

package sudoku.backtrack;

import sudoku.util.Solver;
import sudoku.util.board.SudokuBoard;

/**
 * A sudoku solver which employs plain backtracking to finish a puzzle.
 */
public class BacktrackSolver implements Solver {

	public BacktrackSolver(SudokuBoard board) {

	}

	public void solve(SudokuBoard board) {
		int start = board.size() * board.size();
		for (int i = 0; i < start; i++) {
			if (board.valueAt(i) == 0) {
				start = i;
				break;
			}

		}
		if (start == (start + 1)) {
			System.out.println("no empty cells");
			return;
		}
		if (solve(board, start)) {
			System.out.println("it has completed");

		} else {
			System.out.println("No solution");
		}
	}

	public boolean solve(SudokuBoard board, int cell) {
		if (cell == board.size() * board.size()) {
			return true;
		}
		int next = board.size() * board.size();
		for (int i = 0; i < board.size() * board.size(); i++) {
			if (board.valueAt(i) == 0) {
				next = i;
				cell = next;
				break;
			}

		}
		for (int num = 1; num <= board.size(); num++) {
			if (board.isLegal(num, cell)) {

				board.move(num, cell);
				if (board.isSolved()) {
					System.out.println(board);
					return true;

				}

				if (solve(board, next)) {
					return true;
				}
					board.unmove();
				
			}
		}

		return false;
	}

}