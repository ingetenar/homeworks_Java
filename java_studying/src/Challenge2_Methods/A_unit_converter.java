package Challenge2_Methods;

public class A_unit_converter {

    public static double convertToCentimeters(int inches) {
        return inches * 2.54;
    }

    public static double convertToCentimeters(int feet, int inches) {
        int totalInches = feet * 12 + inches;
        return convertToCentimeters(totalInches);
    }

    public static void main(String[] args) {
        System.out.println(convertToCentimeters(10));       
        System.out.println(convertToCentimeters(5, 8));      
    }
}
