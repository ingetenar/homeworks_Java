package Challenge6_Classes;

public class Calculator_Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        calculator.setFirstNumber(5.0);
        calculator.setSecondNumber(4);

        System.out.println("add = " + calculator.getAdditionResult());
        System.out.println("subtract = " + calculator.getSubtractionResult());

        calculator.setFirstNumber(5.25);
        calculator.setSecondNumber(2);

        System.out.println("multiply = " + calculator.getMultiplicationResult());
        System.out.println("divide = " + calculator.getDivisionResult());
    }
}