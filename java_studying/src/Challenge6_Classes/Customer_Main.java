package Challenge6_Classes;

public class Customer_Main {
    public static void main(String[] args) {

        Customer c1 = new Customer("Mark", 2000.0, "mark@gmail.com");
        Customer c2 = new Customer();
        Customer c3 = new Customer("John", "john@mail.com");

        System.out.println(c1.getName() + " " + c1.getCreditLimit() + " " + c1.getEmailAddress());
        System.out.println(c2.getName() + " " + c2.getCreditLimit() + " " + c2.getEmailAddress());
        System.out.println(c3.getName() + " " + c3.getCreditLimit() + " " + c3.getEmailAddress());
    }
}