package Challenge6_Classes;

public class Bank_account_Main {
    public static void main(String[] args) {

        Bank_account acc = new Bank_account("12345", 1000.0, "Mark", "test@mail.com", "123456");

        acc.deposit(500);
        acc.withdraw(300);
        acc.withdraw(2000);
    }
}
