package Challenge3_Switch;

public class PhoneticAlphabet1 {

    public static String getNatoWord(char c) {
        switch (Character.toUpperCase(c)) {
            case 'A': return "Alfa";
            case 'B': return "Bravo";
            case 'C': return "Charlie";
            case 'D': return "Delta";
            case 'E': return "Echo";
            case 'F': return "Foxtrot";
            case 'G': return "Golf";
            case 'H': return "Hotel";
            case 'I': return "India";
            case 'J': return "Juliett";
            case 'K': return "Kilo";
            case 'L': return "Lima";
            case 'M': return "Mike";
            case 'N': return "November";
            case 'O': return "Oscar";
            case 'P': return "Papa";
            case 'Q': return "Quebec";
            case 'R': return "Romeo";
            case 'S': return "Sierra";
            case 'T': return "Tango";
            case 'U': return "Uniform";
            case 'V': return "Victor";
            case 'W': return "Whiskey";
            case 'X': return "X-ray";
            case 'Y': return "Yankee";
            case 'Z': return "Zulu";
            default: return "Invalid";
        }
    }

    public static void main(String[] args) {
        System.out.println(getNatoWord('c'));
        System.out.println(getNatoWord('A'));
        System.out.println(getNatoWord('1'));
    }
}