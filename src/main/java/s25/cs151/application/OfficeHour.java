package s25.cs151.application;

public class OfficeHour {
    private int id;
    private String semester;
    private String year;
    private String days;

   public OfficeHour(int id, String sem, String year, String days) {
       this.id = id;
       this.semester = sem;
       this.year = year;
       this.days = days;
   }

   public int getId() {return id;};
   public String getSemester() {return semester;}
   public String getYear() {return year;}
   public String getDays() {return days;}

}
