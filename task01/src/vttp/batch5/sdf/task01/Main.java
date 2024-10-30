package vttp.batch5.sdf.task01;

import java.io.IOException;
import java.util.List;
import vttp.batch5.sdf.task01.filemanager.FileManager;
import vttp.batch5.sdf.task01.models.BikeEntry;
import vttp.batch5.sdf.task01.textbuilder.TextBuilder;


public class Main {

	public static void main(String[] args) throws IOException{
		FileManager fileManager = new FileManager();
		List<BikeEntry> fileContents = fileManager.readFile();

		TextBuilder textBuilder = new TextBuilder(fileContents);
		System.out.println(textBuilder.generateOutput());
		
	}
}
