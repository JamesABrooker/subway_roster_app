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

    }

    /*
    Sorts through String to check that given hour is a string that matches
    the 24 hour clock time
     */
    private boolean checkHour(String hour){
        char[] hourArray = hour.toCharArray();
        if(hourArray.length == 5
                && hourArray[0] == '1' || hourArray[0] == '0' || hourArray[0] == '2'
                && Character.isDigit(hourArray[1])
                && hourArray[2] == ':'
                && Character.isDigit(hourArray[3])){
                    int charThree = (int)hourArray[3];
                        if(charThree >= 0 && charThree <= 5
                        && Character.isDigit(hourArray[4])){
                            int charFour = (int)hourArray[4];
                            if(charFour == 0 || charFour == 5){
                                return true;
                                }
                        }
                }

        return false;
    }

    @Override
    public String toString(){
        return "";
    }
}