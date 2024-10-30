package vttp.batch5.sdf.task01.constants;

public enum Format {
    FORMAT("The <position> recorded number of cyclists was in <season>, on a <day> in the month of <month>.\nThere were a total of <total> cyclist. The weather was <weather>.\n<day> was <holiday>.");

    private final String template;

    private Format(String template){
        this.template = template;
    }

    public String getTemplate(){
        return this.template;
    }
}
