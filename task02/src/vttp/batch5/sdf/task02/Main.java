package vttp.batch5.sdf.task02;

import java.util.List;
import vttp.batch5.sdf.task02.board.Board;
import vttp.batch5.sdf.task02.moves.Move;

public class Main {

	public static void main(String[] args) throws Exception {

		Board board = new Board();
		char[][] gameBoard = board.generateBoard(args[0]);
		Move move = new Move(gameBoard);
		List<List<Integer>> emptyPositions = move.getEmptyPositions();
		System.out.println(emptyPositions);

		System.out.println(move.generateUtility());


	}
}
