package vttp.batch5.sdf.task01.constants;

public enum Weather {
    FIRST("Clear, Few clouds, Partly cloudy, Partly cloudy"),
    SECOND("Mist + Cloudy, Mist + Broken clouds, Mist + Few clouds, Mist"),
    THIRD("Light Snow, Light Rain + Thunderstorm + Scattered clouds, Light Rain + Scattered clouds"),
    FOURTH("Heavy Rain + Ice Pallets + Thunderstorm + Mist, Snow + Fog");

    private final String weather;

    private Weather(String weather) {
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }

    public static String getWeather(int position){
        return switch (position) {
            case 1 -> FIRST.getWeather();
            case 2 -> SECOND.getWeather();
            case 3 -> THIRD.getWeather();
            case 4 -> FOURTH.getWeather();
            default -> "";
        };
    }

}
