package Challenge3_Switch;

public class Day_of_the_week​ {

    public static void printDayOfWeek(int day) {
        String dayOfTheWeek = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };

        System.out.println(day + " - " + dayOfTheWeek);
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 7; i++) {
            printDayOfWeek(i);
        }
    }
}