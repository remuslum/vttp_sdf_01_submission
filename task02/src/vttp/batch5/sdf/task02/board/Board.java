package vttp.batch5.sdf.task02.board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Board {
    private final String PATH = "/Users/remuslum/Downloads/vttp_sdf/vttp_b5_assessment_template/task02";
    private final int SIZE = 3;
    private final char[][] board = new char[SIZE][SIZE];

    public Board() {

    }

    public char[][] generateBoard(String textFile) throws IOException{
        File file = new File(PATH + File.separator + textFile);
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        StringBuilder sb = new StringBuilder();

        String line = "";
        int count = 0;
        while((line = br.readLine()) != null){
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
        return board;
    }

}
