import java.util.ArrayList;
import java.util.Collections;
import java.lang.Character;
import java.util.List;
import java.util.Objects;
import java.util.stream.*;

class Day {
    public String day;
    public Hours hours;

    public Day(String day, Hours hours) {


        this.day = day;
        this.hours = hours;
    }

    public void printDay(){
        System.out.println(day+": "+hours.toString());
    }

    public Day returnDay(){
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day1 = (Day) o;
        return Objects.equals(day, day1.day) && Objects.equals(hours, day1.hours);
    }
}

class Hours {
    private String startHour;
    private String endHour;

    private int startHourInt;
    private int endHourInt;
    private int startMinuteInt;
    private int endMinuteInt;

    public Hours(String startHour, String endHour){
        if(checkHour(startHour)) System.out.println("Start is valid");
        else System.out.println("Start time is invalid");
        if(checkHour(endHour)) System.out.println("End is valid");
        else System.out.println("End time is invalid");

        if(checkHour(startHour) && checkHour(endHour)){
            this.startHour = startHour;
            this.endHour = endHour;
        } else {throw new IllegalArgumentException();}

        String[] parts = startHour.split(":");
        this.startHourInt = Integer.parseInt(parts[0]);
        this.startMinuteInt = Integer.parseInt(parts[1]);

        String[] parts2 = endHour.split(":");
        this.endHourInt = Integer.parseInt(parts2[0]);
        this.endMinuteInt = Integer.parseInt(parts2[1]);
    }

    public String getStartHour() {return startHour;}
    public String getEndHour() {return endHour;}

    public int getStartHourAsInt() {return startHourInt;}
    public int getEndHourAsInt() {return endHourInt;}
    public int getStartMinAsInt() {return startMinuteInt;}
    public int getEndMinAsInt() {return endMinuteInt;}

    public int hoursWorked(){
        int hoursWorked = endHourInt - startHourInt;
        int minutesWorked = endMinuteInt - startMinuteInt;
        minutesWorked = minutesWorked / 60;
        return hoursWorked + minutesWorked;
    }

    /*
    Sorts through String to check that given hour is a string that matches
    the 24-hour clock time
     */
    public boolean checkHour(String hour){
        if (hour == null || hour.length() != 5 || hour.charAt(2) != ':') return false;
        String[] parts = hour.split(":");
        try {
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            return h >= 0 && h < 24 && (m >= 0 && m < 60);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*

     */
    public List<Hours> replaceHour(List<Hours> hours){
        List<Hours> newHours = new ArrayList<>();
        int count = 0;
        for(Hours h : hours){

            int startReplace = h.getStartHourAsInt();
            int endReplace = h.getEndHourAsInt();
            int startMinReplace = h.getStartMinAsInt();
            int endMinReplace = h.getEndMinAsInt();

            if(this.endHourInt < startReplace) {
                count++;
                continue;
            }
            if(this.startHourInt == startReplace){
                if(this.startMinuteInt > startMinReplace) newHours.add(new Hours(h.getStartHour(),getStartHour()));
            }
            if(this.endHourInt == endReplace){
                if(this.endMinuteInt < endMinReplace) newHours.add(new Hours(getEndHour(),h.getEndHour()));
            }

            if(this.startHourInt == endReplace){
                if(this.startMinuteInt < endMinReplace) newHours.add(new Hours(h.getStartHour(),getStartHour()));
            }
            if(this.endHourInt == startReplace){
                if(this.endMinuteInt < startMinReplace) newHours.add(new Hours(getEndHour(),h.getEndHour()));
            }

            if(this.endHourInt < endReplace) newHours.add(new Hours(getEndHour(),h.getEndHour()));
            if(this.startHourInt > startReplace) newHours.add(new Hours(h.getStartHour(),getStartHour()));
        }
        if(count == hours.size()) return hours;
        return newHours;
    }

    @Override
    public String toString(){
        return startHour+"-"+endHour;
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hours other = (Hours)o;
        return this.startHour.equals(other.startHour) && this.endHour.equals(other.endHour);
    }
}
