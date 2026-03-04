public class LeapYear  {
    boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeapYear checker = new LeapYear();
        System.out.println(checker.isLeapYear(2032));
    }
}