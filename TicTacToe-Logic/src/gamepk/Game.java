
/*
 * This class responsible of Game Logic that check which Player will WIN and when the Game become DRAW "No One Win"
 */

package gamepk;

import boardpk.Board;

public class Game {

	public Board board = new Board();
	private int boardCounter;
	public boolean winFlag = false;
	public boolean drawFlag = false;

	/*
	 * This Method Check which Player WIN by Looping on the board and check on 3
	 * cases of winning 1) Same Player use 3 Horizontal Cells in 3 Rows. 2) Same
	 * Player use 3 Vertical Cells in 3 Rows. 3) Same Player use 3 Diagonal Cells in
	 * Each(2) Diagonal. and check if NO ONE of them win and the board full that
	 * will be DRAW case
	 */

	public void checkWinner() {
		for (int i = 0, j = 0; i < 3; i++) {
			// Horizontal case
			if (checkSet(j++, j++, j++)) {
				winFlag = true;
			}
			// Vertical case
			if (checkSet(i, i + 3, i + 6)) {
				winFlag = true;
			}
		}
		// Diagonal case
		if (checkSet(0, 4, 8) || checkSet(2, 4, 6)) {
			winFlag = true;
		}
		// Draw case
		if (++boardCounter == 9) {
			drawFlag = true;
		}
	}

	/*
	 * This Method check if the 3 cells which send as parameters used by the same
	 * Player "had the same Symbol" and start with checking on NO ONE of this cells
	 * is Empty
	 */
	private boolean checkSet(int cell1, int cell2, int cell3) {
		if (board.emptyBoard[cell1].getSymbol() != 'E' && board.emptyBoard[cell2].getSymbol() != 'E'
				&& board.emptyBoard[cell1].getSymbol() != 'E') {
			if (boardCounter >= 4) {
				if (board.emptyBoard[cell1].getSymbol() == (board.emptyBoard[cell2].getSymbol())
						&& board.emptyBoard[cell2].getSymbol() == (board.emptyBoard[cell3].getSymbol())) {
					return true;
				}
			}
		}
		return false;
	}
}
