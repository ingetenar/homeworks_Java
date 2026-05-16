package Challenge1_Operators;
public class IdCode {
    public static void main(String[] args) {
        double a = 123.00;
        double b = 77.00;

        double result = (a + b) * 100.00;
        double remainder = result % 40.00;

        boolean isZero = remainder == 0.00;

        System.out.println(isZero);

        if (!isZero) {
            System.out.println("got some remainder");
        }
    }
}