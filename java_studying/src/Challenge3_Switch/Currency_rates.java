package Challenge3_Switch;

public class Currency_rates​ {

    public static double euroToCurrency(double amount, String currency) {
        return switch (currency.toUpperCase()) {
            case "SEK" -> amount * 11.0;
            case "NOK" -> amount * 11.5;
            case "DKK" -> amount * 7.45;
            case "PLN" -> amount * 4.5;
            case "CZK" -> amount * 25.0;
            case "HUF" -> amount * 390.0;
            case "RON" -> amount * 5.0;
            case "BGN" -> amount * 1.96;
            case "CHF" -> amount * 0.95;
            case "GBP" -> amount * 0.85;
            default -> -1;
        };
    }

    public static double currencyToEuro(double amount, String currency) {
        return switch (currency.toUpperCase()) {
            case "SEK" -> amount / 11.0;
            case "NOK" -> amount / 11.5;
            case "DKK" -> amount / 7.45;
            case "PLN" -> amount / 4.5;
            case "CZK" -> amount / 25.0;
            case "HUF" -> amount / 390.0;
            case "RON" -> amount / 5.0;
            case "BGN" -> amount / 1.96;
            case "CHF" -> amount / 0.95;
            case "GBP" -> amount / 0.85;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        System.out.println(euroToCurrency(100, "SEK"));
        System.out.println(currencyToEuro(1100, "SEK"));
    }
}