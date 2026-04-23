package Challenge3_Switch;

public class Phone_numbers {

    public static String getCountry(String phone) {
        if (phone == null || phone.length() < 2 || phone.charAt(0) != '+') {
            return "Unknown";
        }

        String code = phone.substring(1, 4);

        return switch (code) {
            case "372" -> "Estonia";
            case "371" -> "Latvia";
            case "370" -> "Lithuania";
            case "7"   -> "Kazakhstan/Russia";
            case "358" -> "Finland";
            case "46"  -> "Sweden";
            case "47"  -> "Norway";
            case "49"  -> "Germany";
            case "48"  -> "Poland";
            case "44"  -> "UK";
            default -> "Unknown";
        };
    }

    public static String getCountry(long phone) {
        String number = String.valueOf(phone);

        if (number.startsWith("372")) return "Estonia";
        if (number.startsWith("371")) return "Latvia";
        if (number.startsWith("370")) return "Lithuania";
        if (number.startsWith("7")) return "Kazakhstan/Russia";
        if (number.startsWith("358")) return "Finland";
        if (number.startsWith("46")) return "Sweden";
        if (number.startsWith("47")) return "Norway";
        if (number.startsWith("49")) return "Germany";
        if (number.startsWith("48")) return "Poland";
        if (number.startsWith("44")) return "UK";

        return "Unknown";
    }

    public static void main(String[] args) {
        System.out.println(getCountry("+3721234567"));
        System.out.println(getCountry(371987654321L));
    }
}