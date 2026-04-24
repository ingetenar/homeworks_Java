package Challenge4_Loops;

public class Prime_numbers {

    public static boolean isPrime(int number) {
        if (number <= 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }

        return true;
    }

    public static int countPrimes(int start, int end) {
        int count = 0;

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(1, 20));
    }
}