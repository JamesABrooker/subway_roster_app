import java.util.Collections;
import java.lang.Character;
import java.util.List;
import java.util.stream.*;

record Day(String day, Hours hours) {

    public void printDay(){
        System.out.println(day+": "+hours.toString());
    }

    public Day returnDay(){
        return this;
    }
}

class Hours {
    private String startHour;
    private String endHour;

    public Hours(String startHour, String endHour){
        if(checkHour(startHour)) System.out.println("Start is valid");
        else System.out.println("Start time is invalid");
        if(checkHour(endHour)) System.out.println("End is valid");
        else System.out.println("End time is invalid");

        if(checkHour(startHour) && checkHour(endHour))System.out.println("Hours are valid");
        else System.out.println("Hours are invalid");
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

    @Override
    public String toString(){
        return "";
    }
}
