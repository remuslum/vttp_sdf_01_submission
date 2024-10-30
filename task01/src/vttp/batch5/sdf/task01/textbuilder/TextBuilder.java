package vttp.batch5.sdf.task01.textbuilder;

import java.util.List;
import vttp.batch5.sdf.task01.Utilities;
import vttp.batch5.sdf.task01.models.BikeEntry;

public class TextBuilder {
    private final List<BikeEntry> bikeEntries;
    private final String FORMAT = "The <position> recorded number of cyclists was in <season>, on a <day> in the month of <month>.\nThere were a total of <total> cyclists. The weather was <weather>.\n<day> was <holiday>.";
    private final String[] WEATHER = {"Clear, Few clouds, Partly cloudy, Partly cloudy", "Mist + Cloudy, Mist + Broken clouds, Mist + Few clouds, Mist", "Light Snow, Light Rain + Thunderstorm + Scattered clouds, Light Rain + Scattered clouds", "Heavy Rain + Ice Pallets + Thunderstorm + Mist, Snow + Fog"};
    private final String[] HOLIDAY = {"not a holiday", "a holiday"};
    private final String[] POSITIONS = {"highest", "second highest", "third highest", "fourth highest", "fifth highest"};

    public TextBuilder(List<BikeEntry> bikeEntries) {
        this.bikeEntries = bikeEntries;
    }

    public String replaceQuotations() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < bikeEntries.size(); i++){
            String replaced = FORMAT.replaceAll("<position>", POSITIONS[i] + " (position)")
            .replaceAll("<season>", Utilities.toSeason(bikeEntries.get(i).getSeason()) + " (season)")
            .replaceAll("<day>", Utilities.toWeekday(bikeEntries.get(i).getWeekday()) + " (day)")
            .replaceAll("<month>", Utilities.toMonth(bikeEntries.get(i).getMonth()) + " (month)")
            .replaceAll("<total>", String.valueOf(bikeEntries.get(i).getCasual() + bikeEntries.get(i).getRegistered()) + " (total)")
            .replaceAll("<weather>", WEATHER[bikeEntries.get(i).getWeather() - 1] + " (weather)")
            .replaceAll("<holiday>", HOLIDAY[bikeEntries.get(i).isHoliday() ? 1 : 0]);

            sb.append(replaced);
            if(i != bikeEntries.size() - 1){
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    

    
}
