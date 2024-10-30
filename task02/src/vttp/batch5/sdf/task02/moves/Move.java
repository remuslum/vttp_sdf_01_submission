package vttp.batch5.sdf.task02.moves;
import java.util.ArrayList;
import java.util.List;

public class Move {
    private char[][] board;

    public Move(char[][] board){
        this.board = board;
    }

    public List<List<Integer>> getEmptyPositions(){
        List<List<Integer>> allEmptyPositions = new ArrayList<>();
        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[0].length; y++){
                List<Integer> row = new ArrayList<>();
                if(board[x][y] == '.'){
                    row.add(x);
                    row.add(y);
                    allEmptyPositions.add(row);
                } 
            }
        }
        return allEmptyPositions;
    }

    public char[][] createBoardCopy(){
        char[][] boardCopy = new char[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            System.arraycopy(board[i], 0, boardCopy[i], 0, board[0].length);
        }
        return boardCopy;
    }

    public char[][] place(char player, List<Integer> position){
        char[][] copyOfBoard = createBoardCopy();
        copyOfBoard[position.get(0)][position.get(1)] = player;
        return copyOfBoard;
    }

}
