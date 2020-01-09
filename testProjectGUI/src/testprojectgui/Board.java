
/*
 *  This class responsible of create game board that carry Empty User "Players" which will fill 
 * with player X or O when game start and give each Cell in board position to make access easy
 */

package testprojectgui;

public class Board {

	public User[] emptyBoard;

	public Board() {
		emptyBoard = new User[9];
		for (int i = 0; i < 9; i++) {
			emptyBoard[i] = new User();
		}
	}

	/*
	 * Initialize Board with Empty Users to assign User and add him in board when
	 * play start
	 */
	public boolean AddToBoard(User Player, int position) {
		if (emptyBoard[position].getSymbol() == 'E') {
			emptyBoard[position] = Player;
			return true;
		}
		return false;
	}

}
