package Challenge5_Exceptions;

public class Calculator {

    public static void inputThenPrintSumAndAverage() {

        int sum = 0;
        int count = 0;

        while (true) {
            String input = System.console().readLine();

            try {
                int number = Integer.parseInt(input);
                sum += number;
                count++;
            } catch (NumberFormatException e) {
                break;
            }
        }

        double avg = count == 0 ? 0 : (double) sum / count;

        System.out.println("SUM = " + sum + " AVG = " + Math.round(avg));
    }

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }
}