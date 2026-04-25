package Challenge8_Inheritance;

public class Employees_Main {
    public static void main(String[] args) {

        Employees.SalariedEmployee liisi =
                new Employees.SalariedEmployee("Liisi", 1990, "2020", 24000);

        Employees.HourlyEmployee priit =
                new Employees.HourlyEmployee("Priit", 1995, "2021", 10, 45);

        System.out.println(liisi);
        System.out.println("Pay: " + liisi.collectPay());
        liisi.retire();
        System.out.println("After retire: " + liisi.collectPay());

        System.out.println();

        System.out.println(priit);
        System.out.println("Pay: " + priit.collectPay());
        System.out.println("Double pay: " + priit.getDoublePay());
    }
}