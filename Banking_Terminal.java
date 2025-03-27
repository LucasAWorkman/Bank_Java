import java.util.ArrayList;
import java.util.Scanner;

public class Banking_Terminal implements HasMenu {
    private Admin admin;
    private ArrayList<Customer> customers;

    public Banking_Terminal() {
        admin = new Admin();
        customers = new ArrayList<>();
    }

    @Override
    public String menu() {
        return "Bank Menu:\n0) Exit system\n1) Login as admin\n2) Login as customer\nAction:";
    }
    
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println(menu());
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Goodbye!");
                    keepGoing = false;
                    break;
            }
        }
    }
    


    public static void main(String[] string) {

    }
}
