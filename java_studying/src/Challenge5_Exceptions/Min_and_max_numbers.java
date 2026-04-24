package Challenge5_Exceptions;

public class Min_and_max_numbers {
    public static void main(String[] args) {

        Integer min = null;
        Integer max = null;

        while (true) {
            System.out.println("Enter a number:");

            String input = System.console().readLine();

            try {
                int number = Integer.parseInt(input);

                if (min == null || number < min) {
                    min = number;
                }

                if (max == null || number > max) {
                    max = number;
                }

            } catch (NumberFormatException e) {
                break;
            }
        }

        if (min != null && max != null) {
            System.out.println("Min = " + min);
            System.out.println("Max = " + max);
        } else {
            System.out.println("No valid numbers entered");
        }
    }
}