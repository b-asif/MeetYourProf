package s25.cs151.application;


public class OfficeHour {
    private String semester;
    private String year;
    private String days;

    public OfficeHour(String sem, String year, String days) {
        this.semester = sem;
        this.year = year;
        this.days = days;
    }

    public String getSemester() {return semester;}
    public String getYear() {return year;}
    public String getDays() {return days;}

}
