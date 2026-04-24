package Challenge5_Exceptions;

public class Invalid_numbers {
    public static void main(String[] args) {

        int count = 1;
        int sum = 0;

        while (count <= 5) {
            System.out.println("Enter number #" + count + ":");

            String input = System.console().readLine();

            try {
                int number = Integer.parseInt(input);

                if (number < 0) {
                    System.out.println("Invalid number");
                } else {
                    sum += number;
                    count++;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
        }

        System.out.println("Sum = " + sum);
    }
}