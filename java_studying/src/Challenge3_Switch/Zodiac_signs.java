package Challenge3_Switch;

public class Zodiac_signs {

    public static String getZodiac(int day, int month) {
        return switch (month) {
            case 1 -> (day <= 19) ? "Capricorn" : "Aquarius";
            case 2 -> (day <= 18) ? "Aquarius" : "Pisces";
            case 3 -> (day <= 20) ? "Pisces" : "Aries";
            case 4 -> (day <= 19) ? "Aries" : "Taurus";
            case 5 -> (day <= 20) ? "Taurus" : "Gemini";
            case 6 -> (day <= 20) ? "Gemini" : "Cancer";
            case 7 -> (day <= 22) ? "Cancer" : "Leo";
            case 8 -> (day <= 22) ? "Leo" : "Virgo";
            case 9 -> (day <= 22) ? "Virgo" : "Libra";
            case 10 -> (day <= 22) ? "Libra" : "Scorpio";
            case 11 -> (day <= 21) ? "Scorpio" : "Sagittarius";
            case 12 -> (day <= 21) ? "Sagittarius" : "Capricorn";
            default -> "Invalid";
        };
    }

    public static String getZodiac(String date) {
        String[] parts = date.split("\\.");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        return getZodiac(day, month);
    }

    public static String getZodiac(int date) {
        int day = date % 100;
        int month = date / 100;
        return getZodiac(day, month);
    }

    public static void main(String[] args) {
        System.out.println(getZodiac(26, 12));
        System.out.println(getZodiac("23.08"));
        System.out.println(getZodiac(1203));
    }
}