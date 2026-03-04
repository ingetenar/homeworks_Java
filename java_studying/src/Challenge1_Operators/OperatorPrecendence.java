package Challenge1_Operators;
public class Operator_precendence {
    public static void main(String[] args) {
        double a = 20;
        double b = 80;
        double result = (a + b) * 100;
        double reminder = result % 40;
        boolean isNoReminder = (reminder == 0);
        System.out.println(isNoReminder);
        if (!isNoReminder) {
            System.out.println("got some remainder");
        }
    }
}

