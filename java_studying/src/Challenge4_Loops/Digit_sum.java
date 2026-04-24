package Challenge4_Loops;

public class Digit_sum {

    public static int sumDigits(int number) {
        if (number < 0) return -1;

        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumDigits(125));
        System.out.println(sumDigits(7));
        System.out.println(sumDigits(-3));
    }
}