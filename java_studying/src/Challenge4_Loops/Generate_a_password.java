package Challenge4_Loops;

public class Generate_a_password {

    public static String generatePassword(int length) {
        if (length < 8) return "Invalid";

        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String special = "!@#$%^&*";
        String all = lower + upper + digits + special;

        StringBuilder password = new StringBuilder();

        password.append(lower.charAt((int)(Math.random() * lower.length())));
        password.append(upper.charAt((int)(Math.random() * upper.length())));
        password.append(digits.charAt((int)(Math.random() * digits.length())));
        password.append(special.charAt((int)(Math.random() * special.length())));

        for (int i = 4; i < length; i++) {
            password.append(all.charAt((int)(Math.random() * all.length())));
        }

        for (int i = 0; i < password.length(); i++) {
            int randomIndex = (int)(Math.random() * password.length());
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(randomIndex));
            password.setCharAt(randomIndex, temp);
        }

        return password.toString();
    }

    public static void main(String[] args) {
        System.out.println(generatePassword(10));
    }
}