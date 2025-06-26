import java.util.List;

record Worker(String name, String number, List<Hours> hours) {

    public boolean addShift(Shift shift) {
        return false;
    }

    public boolean removeShift(Shift shift) {
        return false;
    }

    // returns true if 2 given hours overlap, false otherwise
    public boolean overlapShift(Shift shift1, Shift shift2) {
        if(!shift1.day().equals(shift2.day())) return false;

        //checks that shift does not start in the middle of the other shift
        if(shift1.hours().getStartHourAsInt() > shift2.hours().getStartHourAsInt() &&
                shift1.hours().getStartHourAsInt() < shift2.hours().getEndHourAsInt()) return true;
        if(shift2.hours().getStartHourAsInt() > shift1.hours().getStartHourAsInt() &&
                shift2.hours().getStartHourAsInt() < shift1.hours().getEndHourAsInt()) return true;
        if(shift1.hours().getEndHourAsInt() > shift2.hours().getStartHourAsInt() &&
                shift1.hours().getEndHourAsInt() < shift2.hours().getEndHourAsInt()) return true;
        if(shift2.hours().getEndHourAsInt() > shift1.hours().getStartHourAsInt() &&
                shift2.hours().getEndHourAsInt() < shift1.hours().getEndHourAsInt()) return true;

        //checks that shift is not contained inside the hours of the other shift
        if(shift1.hours().getStartHourAsInt() <= shift2.hours().getStartHourAsInt()
                && shift1.hours().getEndHourAsInt() > shift2.hours().getStartHourAsInt()) return true;
        if(shift2.hours().getStartHourAsInt() <= shift1.hours().getStartHourAsInt()
                && shift2.hours().getEndHourAsInt() > shift1.hours().getStartHourAsInt()) return true;

        //checks that if the hours are equal, the starting minutes are different
        if(shift1.hours().getStartHourAsInt() == shift2.hours().getEndHourAsInt()){
            if(shift1.hours().getStartMinAsInt() < shift2.hours().getEndMinAsInt()) return true;
        }
        if(shift1.hours().getEndHourAsInt() == shift2.hours().getStartHourAsInt()){
            if(shift2.hours().getStartMinAsInt() < shift1.hours().getEndMinAsInt()) return true;
        }

        /*
        Checks correctly if start hours are equal, think about checking if shift overlaps
        where start and end are in the same hour? Cases like:
            1: 12:00 - 12:45
            2: 12:30 - 18:30
        Think about it and fix tomorrow
         */

        return false;
    }

}

record Shift(Day day, Hours hours) {}
