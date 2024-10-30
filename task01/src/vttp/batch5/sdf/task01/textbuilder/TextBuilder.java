package vttp.batch5.sdf.task01.textbuilder;


import java.util.List;
import java.util.stream.Collectors;
import vttp.batch5.sdf.task01.Utilities;
import vttp.batch5.sdf.task01.comparator.BikeEntryComparator;
import vttp.batch5.sdf.task01.constants.Format;
import vttp.batch5.sdf.task01.constants.Holiday;
import vttp.batch5.sdf.task01.constants.Position;
import vttp.batch5.sdf.task01.constants.Weather;
import vttp.batch5.sdf.task01.models.BikeEntry;

public class TextBuilder {
    private final List<BikeEntry> bikeEntries;
    private final String template = Format.FORMAT.getTemplate();

    public TextBuilder(List<BikeEntry> bikeEntries) {
        this.bikeEntries = bikeEntries;
    }

    public String generateOutput(){
        return replaceQuotations(getTopFiveEntrys(new BikeEntryComparator()));
    }

    public List<BikeEntry> getTopFiveEntrys(BikeEntryComparator bikeEntryComparator){
        return bikeEntries.stream().sorted(bikeEntryComparator.reversed()).limit(5).collect(Collectors.toList());
    }

    private String replaceQuotations(List<BikeEntry> bikeEntries) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < bikeEntries.size(); i++){
            String replaced = template.replaceAll("<position>", Position.getPosition(i + 1) + " (position)")
            .replaceAll("<season>", Utilities.toSeason(bikeEntries.get(i).getSeason()) + " (season)")
            .replaceAll("<day>", Utilities.toWeekday(bikeEntries.get(i).getWeekday()) + " (day)")
            .replaceAll("<month>", Utilities.toMonth(bikeEntries.get(i).getMonth()) + " (month)")
            .replaceAll("<total>", String.valueOf(bikeEntries.get(i).getCasual() + bikeEntries.get(i).getRegistered()) + " (total)")
            .replaceAll("<weather>", Weather.getWeather(bikeEntries.get(i).getWeather()) + " (weather)")
            .replaceAll("<holiday>", Holiday.getHoliday(bikeEntries.get(i).isHoliday()));

            sb.append(replaced);
            if(i != bikeEntries.size() - 1){
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    

    
}
