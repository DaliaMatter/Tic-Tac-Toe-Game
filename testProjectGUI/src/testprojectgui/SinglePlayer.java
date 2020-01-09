package testprojectgui;

import java.util.Random;


public class SinglePlayer {

	public int easyLevel(Game game) {
		int position;
		Random rand = new Random();
		position = rand.nextInt(8);
		while (game.board.emptyBoard[position].getSymbol() != 'E') {
			position = rand.nextInt(8);
		}
		return position;
	}

	public int hardLevel(Game game) {
		int position;
		position = lookForWinOrBlock('O', game); // Try to win
		if (position == -1) {
			position = lookForWinOrBlock('X', game); // Block in player
			if (position == -1) {
				position = lookForCorner(game);
				if (position == -1) {
					position = lookForOpenSpace(game);
				}
			}
		}
		return position;
	}

	public int lookForWinOrBlock(char symbol, Game game) {
		int index = 0;
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		for (int i = 0, j = 0; i < 3; i++) {
			// Horizontal case
			if (lastCell(j++, j++, j++, game)) {
				return j - 1;
			}
			if (secondCell(index++, index++, index++, game)) {
				return index - 2;
			}
			if (firstCell(index1++, index1++, index1++, game)) {
				return index - 3;
			}
			// Vertical case
			if (lastCell(i, i + 3, i + 6, game)) {
				return i;
			}
			if (secondCell(index2, index2 + 3, index2 + 6, game)) {
				return index - 3;
			}
			if (firstCell(index3, index3 + 3, index3 + 6, game)) {
				return index - 6;
			}
		}
		// DIAGONAL TESTS
		if (lastCell(0, 4, 8, game)) {
			return 8;
		}
		if (secondCell(0, 4, 8, game)) {
			return 4;
		}
		if (firstCell(0, 4, 8, game)) {
			return 0;
		}
		if (lastCell(2, 4, 6, game)) {
			return 6;
		}
		if (secondCell(2, 4, 6, game)) {
			return 4;
		}
		if (firstCell(2, 4, 6, game)) {
			return 2;
		}
		return -1;
	}

	public int lookForCorner(Game game) {
		if (game.board.emptyBoard[0].getSymbol() != 'E') {
			if (lastCell(6, 2, 8, game)) {
				return 8;
			} else if (secondCell(6, 2, 8, game)) {
				return 2;
			} else if (firstCell(6, 2, 8, game)) {
				return 6;
			}
		} else if (game.board.emptyBoard[6].getSymbol() != 'E') {
			if (lastCell(0, 2, 8, game)) {
				return 8;
			} else if (secondCell(0, 2, 8, game)) {
				return 2;
			} else if (firstCell(0, 2, 8, game)) {
				return 0;
			}
		} else if (game.board.emptyBoard[2].getSymbol() != 'E') {
			if (lastCell(6, 0, 8, game)) {
				return 8;
			} else if (secondCell(6, 0, 8, game)) {
				return 0;
			} else if (firstCell(6, 0, 8, game)) {
				return 6;
			}
		} else if (game.board.emptyBoard[8].getSymbol() != 'E') {
			if (lastCell(6, 2, 0, game)) {
				return 0;
			} else if (secondCell(6, 2, 0, game)) {
				return 2;
			} else if (firstCell(6, 2, 0, game)) {
				return 6;
			}
		} else if (game.board.emptyBoard[0].getSymbol() == 'E') {
			return 0;
		} else if (game.board.emptyBoard[2].getSymbol() == 'E') {
			return 2;
		} else if (game.board.emptyBoard[6].getSymbol() == 'E') {
			return 6;
		} else if (game.board.emptyBoard[8].getSymbol() == 'E') {
			return 8;
		}
		return -1;
	}

	public int lookForOpenSpace(Game game) {
		for (int i = 0; i < 9; i++) {
			if (game.board.emptyBoard[i].getSymbol() == 'E') {
				return i;
			}
		}
		return -1;
	}

	private boolean lastCell(int cell1, int cell2, int cell3, Game game) {
		if (game.board.emptyBoard[cell1].getSymbol() == (game.board.emptyBoard[cell2].getSymbol())
				&& (game.board.emptyBoard[cell3].getSymbol()) == 'E') {
			return true;
		}
		return false;
	}

	private boolean secondCell(int cell1, int cell2, int cell3, Game game) {
		if (game.board.emptyBoard[cell1].getSymbol() == (game.board.emptyBoard[cell3].getSymbol())
				&& (game.board.emptyBoard[cell2].getSymbol()) == 'E') {
			return true;
		}
		return false;
	}

	private boolean firstCell(int cell1, int cell2, int cell3, Game game) {
		if (game.board.emptyBoard[cell2].getSymbol() == (game.board.emptyBoard[cell3].getSymbol())
				&& (game.board.emptyBoard[cell1].getSymbol()) == 'E') {
			return true;
		}
		return false;
	}

}
