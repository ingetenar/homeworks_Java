package Challenge7_Static;

public class Complex_number_operation {

    private double real;
    private double imaginary;

    public Complex_number_operation(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void add(double real, double imaginary) {
        this.real += real;
        this.imaginary += imaginary;
    }

    public void subtract(double real, double imaginary) {
        this.real -= real;
        this.imaginary -= imaginary;
    }

    public static Complex_number_operation addNumbers(Complex_number_operation a, Complex_number_operation b) {
        return new Complex_number_operation(
                a.real + b.real,
                a.imaginary + b.imaginary
        );
    }

    public static Complex_number_operation subtractNumbers(Complex_number_operation a, Complex_number_operation b) {
        return new Complex_number_operation(
                a.real - b.real,
                a.imaginary - b.imaginary
        );
    }

    public String toString() {
        return real + " + " + imaginary + "i";
    }
    public static void main(String[] args) {

        Complex_number_operation c1 = new Complex_number_operation(5, 3);
        Complex_number_operation c2 = new Complex_number_operation(4, 2);

        // instance методы
        c1.add(1, 1);
        System.out.println("c1 after add: " + c1);

        c1.subtract(2, 2);
        System.out.println("c1 after subtract: " + c1);

        // static методы
        Complex_number_operation sum = Complex_number_operation.addNumbers(c1, c2);
        System.out.println("Sum: " + sum);

        Complex_number_operation diff = Complex_number_operation.subtractNumbers(c1, c2);
        System.out.println("Difference: " + diff);
    }
}