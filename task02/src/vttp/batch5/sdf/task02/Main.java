package vttp.batch5.sdf.task02;

import vttp.batch5.sdf.task02.board.Board;
import vttp.batch5.sdf.task02.moves.Move;

public class Main {

	public static void main(String[] args) {
		try {
			Board board = new Board();
			char[][] gameBoard = board.generateBoard(args[0]);
			if (gameBoard.length != 0){
				System.out.println(board.printBoard(gameBoard));
				Move move = new Move(gameBoard);
				System.out.println(move.generateUtility());
			}
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid TTT configuration file");
		}
	}
}
