package vttp.batch5.sdf.task01.constants;

public enum Position {
    FIRST("highest"),
    SECOND("second highest"),
    THIRD("third highest"),
    FOURTH("fourth highest"),
    FIFTH("fifth highest");

    private final String position;

    private Position(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public static String getPosition(int position){
        return switch (position) {
            case 1 -> FIRST.getPosition();
            case 2 -> SECOND.getPosition();
            case 3 -> THIRD.getPosition();
            case 4 -> FOURTH.getPosition();
            case 5 -> FIFTH.getPosition();
            default -> "";
        };
    }

}
