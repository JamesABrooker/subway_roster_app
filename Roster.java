import java.util.*;

class Roster {
    private final Set<Day> days;
    private Set<Worker> workers;
    private Map<Day,List<Hours>> coveredHours = new HashMap<>();

    public Roster(Set<Day> days, Set<Worker> workers){
        this.days = days;
        this.workers = workers;
        for(Day day : days) {
            List<Hours> hoursInDay = new ArrayList<>();
            hoursInDay.add(day.hours);
            coveredHours.put(day, hoursInDay);
        }

        for(Worker worker : workers) {
            for(Shift s: worker.shifts()) addHours(s);
        }
    }

    public void addHours(Shift shift){
        coveredHours.put(shift.day(),shift.hours().replaceHour(coveredHours.get(shift.day())));
    }


}
