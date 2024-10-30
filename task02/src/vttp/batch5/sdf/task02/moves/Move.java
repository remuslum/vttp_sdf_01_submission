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

    public int evaluateRowWin(char[][] board){
        //Evaluate row
        for (char[] board1 : board) {
            if ((board1[0] == board1[1]) && (board1[1] == board1[2])) {
                return switch (board1[0]) {
                    case 'X' -> 1;
                    case 'O' -> -1;
                    default -> 0;
                };
            }
        }
        return 0;
    }

    public int evaluateColumnWin(char[][] board){
        //Evaluate column
        for(int i = 0; i < board[0].length; i++){
            if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i])) {
                return switch (board[0][i]) {
                    case 'X' -> 1;
                    case 'O' -> -1;
                    default -> 0;
                };
            }
        }
        return 0;   
    }

    public int evaluateDiagonalWin(char[][] board){
        //Evaluate Diagonals
        if(((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))){
            return switch (board[0][0]) {
                case 'X' -> 1;
                case 'O' -> -1;
                default -> 0;
            };
        } else if (((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]))){
            return switch (board[0][2]) {
                case 'X' -> 1;
                case 'O' -> -1;
                default -> 0;
            };
        }
        return 0;
    }

    public String generateUtility(){
        List<List<Integer>> allEmptyPositions = this.getEmptyPositions();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < allEmptyPositions.size(); i++){
            List<Integer> currentPosition = allEmptyPositions.get(i);
            int bestUtility = 0;
            char[][] newBoard = place('X', currentPosition);
            if(evaluateRowWin(newBoard) == 1 || evaluateColumnWin(newBoard) == 1 || evaluateDiagonalWin(newBoard) == 1){
                bestUtility = 1;
            } else {
                List<List<Integer>> remainingEmptyPositions = new ArrayList<>();
                remainingEmptyPositions.addAll(allEmptyPositions.subList(0, i));
                remainingEmptyPositions.addAll(allEmptyPositions.subList(i+1, allEmptyPositions.size()));
                for(List<Integer> remainingPosition:remainingEmptyPositions){
                    char[][] newBoard2 = place('O', remainingPosition);
                    if(evaluateRowWin(newBoard2) == -1 || evaluateColumnWin(newBoard2) == -1 || evaluateDiagonalWin(newBoard2) == -1){
                        bestUtility = -1;
                    }
                }

            }
            sb.append("y=");
            sb.append(currentPosition.get(1));
            sb.append(", x=");
            sb.append(currentPosition.get(0));
            sb.append(", utility=");
            sb.append(bestUtility);
            sb.append("\n");
        }
        return sb.toString();
    }

}
