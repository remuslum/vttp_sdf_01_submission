package vttp.batch5.sdf.task01.constants;

public enum Holiday {
    YES("a holiday"),
    NO("not a holiday");

    private final String result;

    private Holiday(String result){
        this.result = result;
    }

    public String getResult(){
        return this.result;
    }

    public static String getHoliday(boolean isHoliday){
        return isHoliday ? YES.getResult() : NO.getResult();
    }
}
