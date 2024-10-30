package vttp.batch5.sdf.task02.board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Board {
    private final int SIZE = 3;
    private final char[][] board = new char[SIZE][SIZE];

    public Board() {

    }

    public char[][] generateBoard(String textFile){
        try {
            File file = new File(textFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();

            String line = "";
            int count = 0;
            while((line = br.readLine()) != null){
                if(!(line.contains(".") || line.contains("X") || line.contains("O"))){
                    System.out.println("File does not contain TTT configuration");
                    break;
                }
                sb.append(line);
                if(count < 2){
                    sb.append(",");
                }
                count++;
            }
            String[] inputs = sb.toString().split(",");
            for(int i = 0; i < inputs.length; i++){
                char[] temp = inputs[i].toCharArray();
                System.arraycopy(temp, 0, board[i], 0, temp.length);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("File does not exist");
        }
        return board;
    }

    public String printBoard(char[][] gameBoard){
        StringBuilder sb = new StringBuilder();
        for (char[] row : gameBoard) {
            for (char space : row) {
                sb.append(space);
            }
            sb.append("\n"); 
        }
        return sb.toString();
    }


}
