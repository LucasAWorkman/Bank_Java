HasMenu
interface HasMenu 
  ====================
  ====================
  string menu()
  void start()
  ====================
Notes

HasMenu is an interface
It will not be instantiated
It will be implemented by other classes
A class that implements this interface must have a menu() and start() methods
CheckingAccount
class CheckingAccount implements HasMenu
  ====================
    double balance
  ====================
    CheckingAccount()
    CheckingAccount(double balance)
    main()
    string menu()
    void start()   
    double getBalance()
    string getBalanceString()
    void setBalance(double balance)
    void checkBalance()
    private double getDouble()
    void makeDeposit()
    void makeWithdrawal
  ====================
Notes

The checking account might be the first object to build (after the interface)
It is mainly a wrapper around the balance, which is a double
It has two constructors: one with and one without a double
It will have a main so we can test it before building the other classes
menu will print out the menu and get a response
start will repeat the menu, send control to other methods, and exit as appropriate
Standard getters and setters for balance
Special getBalanceString returns balance as a nicely formatted string (String.format())
getDouble() is a convenience function.  It tries to read in a double from the user with an exception handler. if the user inputs improper data, it will return a 0.
checkBalance(), makeDeposit(), and makeWithdrawal() are all called by menu choices
Later we will add serialization for data storage
SavingsAccount
class SavingsAccount extends CheckingAccount
  ====================
    double interestRate
  ====================
    main()
    calcInterest()
    void setInterestRate()
    double getInterestRate()
  ====================
Notes

Savings account is nearly identical to CheckingAccount
It can use most of the same methods and attributes.
The only new thing is the addition of an interestRate
Add a double parameter to hold the interest rate
Add getter and setter for interest rate
calcInterest calculates the interest and adds it to the balance. For obvious reasons, we won't let the customer do this directly.
User
abstract class User implements HasMenu, Serializable
  ====================
    string userName
    string PIN
  ====================
    boolean login()
    boolean login(userName, PIN)
    void setUserName(userName)
    string getUserName()
    void setPIN(PIN)
    string getPIN()
    abstract string getReport()
  ====================
Notes

The user class is an abstract class. It will be used to create the Customer (this week) and we'll use it again to create the Admin next week.  Both user types will need logins, so the main thing the User class does is manage logins.  This requires two data members, userName and PIN. For convenience, we'll have two different (but related) login methods. One takes parameters for userName and PIN, and the other prompts the user for these values.  In any case, the method returns true if the userName and PIN match the current customer and false if they do not.

The getReport() method is abstract. 
Both the customer and admin will have reports, but they are different. This is a good example of polymorphism. 
The User class will also implement the HasMenu interface, enforcing more polymorphism.
Note that an abstract class can be compiled, but it cannot be run. So you can test the compilation of this class as soon as you've finished writing it, but if you want to see it running, you'll need to subclass it.

Customer
class Customer extends User
  ====================
    CheckingAccount checking 
    SavingsAccount savings 
  ====================
    void main()
    Customer()
    Customer(usernName, PIN)
    void start()
    string menu()
    void changePin()
    string getReport()
  ====================
Notes

The Customer class is one extension of the User class. 
This represents a single customer. 
Most of its methods are informed by the various things it inherits:
start(),
menu(),
getReport(). 
The only truly original method is changePin(), which allows you to change the PIN.
Later on we will add the ability to serialize this class for data storage.
