package Challenge4_Loops;

public class Fibonacci_numbers {

    public static boolean isFibonacci(int n) {
        if (n < 0) return false;

        int a = 0;
        int b = 1;

        while (b <= n) {
            if (b == n || n == 0) return true;
            int temp = a + b;
            a = b;
            b = temp;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isFibonacci(13));
        System.out.println(isFibonacci(10));
    }
}