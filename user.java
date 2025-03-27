import java.io.Serializable;
import java.util.Scanner;

abstract class User implements HasMenu, Serializable {
    private String userName;
    private String PIN;

    public User() {
        this.userName = "userName";
        this.PIN = "3563";
    }

    public User(String userName, String PIN) {
        this.userName = userName;
        this.PIN = PIN;
    }

    public boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username: ");
        String inputUser = scanner.nextLine();

        System.out.println("Enter PIN: ");
        String inputPin = scanner.nextLine();

        return login(inputUser, inputPin);
        }



    public boolean login(String username, String PIN) {
        return this.userName.equals(userName) && this.PIN.equals(PIN);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }
    
    private void setPin(String PIN) {
        this.PIN = PIN;
    }

    public String getPin() {
        return this.PIN;
    }

    public abstract String getReport();
}