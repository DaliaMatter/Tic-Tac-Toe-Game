
/*
 * this class for testing ONLY
 */

package testpk;

import java.util.Scanner;

import gamepk.Game;

public class Test {

	static Game game = new Game();
	static String[] board;

	static void printBoard() {
		System.out.println("/---|---|---\\");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("/---|---|---\\");
	}

	public static void main(String[] args) {
		board = new String[9];
		boolean win = false;
		boolean draw = false;
		Scanner input = new Scanner(System.in);
		int pos;
		char turn = 'X';
		for (int i = 0; i < 9; i++) {
			board[i] = "-";
		}
		printBoard();

		while (!win && !draw) {
			if (turn == 'X') {
				pos = input.nextInt();
				game.board.emptyBoard[pos].setSymbol(turn);
				board[pos] = "X";
				turn = 'O';
				printBoard();
			} else {
				pos = input.nextInt();
				game.board.emptyBoard[pos].setSymbol(turn);
				board[pos] = "O";
				turn = 'X';
				printBoard();

			}

			game.checkWinner();
			win = game.winFlag;
			draw = game.drawFlag;
		}
		if (win) {
			System.out.println("Winer");
		} else if (draw) {
			System.out.println("Draw");
		}
	}

}
