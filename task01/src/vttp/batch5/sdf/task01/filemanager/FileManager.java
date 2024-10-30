package vttp.batch5.sdf.task01.filemanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import vttp.batch5.sdf.task01.models.BikeEntry;

public class FileManager {
    private final String fileName = "day.csv";
    private final String path = "/Users/remuslum/Downloads/vttp_sdf/vttp_b5_assessment_template/task01";
    private final String separator = File.separator;

    public FileManager(){
        
    }

    public List<BikeEntry> readFile() throws IOException {
        List<BikeEntry> fileContents = new ArrayList<>();
        File file = new File(path + separator + fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        String line = "";
        String[] headers = br.readLine().split(",");

        while((line = br.readLine()) != null){
            String[] inputs = line.split(",");
            fileContents.add(BikeEntry.toBikeEntry(inputs));
        }
        br.close();
        return fileContents;
    }
}
