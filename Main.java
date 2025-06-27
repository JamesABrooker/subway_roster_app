import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    //Temporarily used for testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Start Time:");
        String h1 = sc.nextLine();
        System.out.println("End Time:");
        String h2 = sc.nextLine();

        Hours h = new Hours(h1, h2);
        System.out.println(h);

        System.out.println("Hours Worked: " + h.hoursWorked());

        Day d = new Day("Monday",h);
        Shift s = new Shift(d,h);

        List<Shift> shifts=new ArrayList<Shift>();
        shifts.add(s);
        Worker w = new Worker("james", "111111111", shifts);

        System.out.println("Hours Worked: " + w.hoursWorked());

        System.out.println("New Start Time:");
        String e1 = sc.nextLine();
        System.out.println("New End Time:");
        String e2 = sc.nextLine();
        Hours hour2 = new Hours(e1,e2);

        Shift newShift = new Shift(d,hour2);

        w.addShift(newShift);

        System.out.println("Hours Worked: " + w.hoursWorked());
    }
}
