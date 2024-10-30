package vttp.batch5.sdf.task01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import vttp.batch5.sdf.task01.comparator.BikeEntryComparator;
import vttp.batch5.sdf.task01.filemanager.FileManager;
import vttp.batch5.sdf.task01.models.BikeEntry;
import vttp.batch5.sdf.task01.textbuilder.TextBuilder;


public class Main {

	public static void main(String[] args) throws IOException{
		FileManager fileManager = new FileManager();
		List<BikeEntry> fileContents = fileManager.readFile();
		BikeEntryComparator bikeEntryComparator = new BikeEntryComparator();
		Collections.sort(fileContents, Collections.reverseOrder(bikeEntryComparator));
		List<BikeEntry> top5Entries = new ArrayList<>();

		// Get Top 5 entries
		for(int i = 0; i < 5; i++){
			top5Entries.add(fileContents.get(i));
		}

		TextBuilder textBuilder = new TextBuilder(top5Entries);
		System.out.println(textBuilder.replaceQuotations());
		
	}
}
