package vttp.batch5.sdf.task01.comparator;

import java.util.Comparator;
import vttp.batch5.sdf.task01.models.BikeEntry;

public class BikeEntryComparator implements Comparator<BikeEntry>{
    
    @Override
    public int compare(BikeEntry first, BikeEntry second){
        int firstCyclists = first.getCasual() + first.getRegistered();
        int secondCyclists = second.getCasual() + second.getRegistered();
        return Integer.compare(firstCyclists, secondCyclists);
    }
}


