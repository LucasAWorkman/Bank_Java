public class Admin extends Customer{
    
    String username = "Admin";
    int pin = 0000;

    public Admin() {
        this.username = "Admin";
        this.pin = 0000;
    }

    public void start(){

    }
    
    public String Menu() {
        return "Admin Menu: \n 1) Full customer report \n 2) Add user \n 3) Apply interest to savings accounts \n Action:";
    }

    public String getReport() {
        return "Admin Report: \nUsername: " + this.username + "\nPIN: " + this.pin;
    }
}
