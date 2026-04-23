package Challenge2_Methods;

public class Ceasar_cipher {

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int shifted = (c - base + shift) % 26;
                if (shifted < 0) shifted += 26;
                result.append((char) (base + shifted));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static String encrypt(String text) {
        return encrypt(text, 3);
    }

    public static void main(String[] args) {
        System.out.println(encrypt("Hello World", 5));
        System.out.println(encrypt("Hello World"));
    }
}