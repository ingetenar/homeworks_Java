package Challenge4_Loops;

public class Palindromic_numbers {

    public static boolean isPalindrome(int number) {
        int original = number;
        int reversed = 0;

        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        return original == reversed;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(707));
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(11212));
    }
}