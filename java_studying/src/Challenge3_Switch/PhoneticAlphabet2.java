package Challenge3_Switch;

public class PhoneticAlphabet2 {
    public static void main(String[] args) {
        char letter = 'C';

        switch (Character.toUpperCase(letter)) {
            case 'A':
                System.out.println("A - Alfa");
                break;
            case 'B':
                System.out.println("B - Bravo");
                break;
            case 'C':
                System.out.println("C - Charlie");
                break;
            case 'D':
                System.out.println("D - Delta");
                break;
            case 'E':
                System.out.println("E - Echo");
                break;
            case 'F':
                System.out.println("F - Foxtrot");
                break;
            case 'G':
                System.out.println("G - Golf");
                break;
            case 'H':
                System.out.println("H - Hotel");
                break;
            case 'I':
                System.out.println("I - India");
                break;
            case 'J':
                System.out.println("J - Juliett");
                break;
            case 'K':
                System.out.println("K - Kilo");
                break;
            case 'L':
                System.out.println("L - Lima");
                break;
            case 'M':
                System.out.println("M - Mike");
                break;
            case 'N':
                System.out.println("N - November");
                break;
            case 'O':
                System.out.println("O - Oscar");
                break;
            case 'P':
                System.out.println("P - Papa");
                break;
            case 'Q':
                System.out.println("Q - Quebec");
                break;
            case 'R':
                System.out.println("R - Romeo");
                break;
            case 'S':
                System.out.println("S - Sierra");
                break;
            case 'T':
                System.out.println("T - Tango");
                break;
            case 'U':
                System.out.println("U - Uniform");
                break;
            case 'V':
                System.out.println("V - Victor");
                break;
            case 'W':
                System.out.println("W - Whiskey");
                break;
            case 'X':
                System.out.println("X - X-ray");
                break;
            case 'Y':
                System.out.println("Y - Yankee");
                break;
            case 'Z':
                System.out.println("Z - Zulu");
                break;
            default:
                System.out.println(letter + " - not found");
        }
    }
}