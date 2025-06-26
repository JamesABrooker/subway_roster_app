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
    }
}
