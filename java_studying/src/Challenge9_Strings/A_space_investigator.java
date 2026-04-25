package Challenge9_Strings;

public class A_space_investigator {

    public static String spaceInvestigator(String text) {

        System.out.println("Original: " + text);

        text = removeExtraSpaces(text);
        text = removeSpacesBeforePunctuation(text);
        text = addSpaceAfterPunctuation(text);
        text = fixDecimalNumbers(text);
        text = fixDashes(text);
        text = trimText(text);

        System.out.println("Fixed: " + text);

        return text;
    }

    public static String removeExtraSpaces(String text) {
        System.out.println("Fixing multiple spaces...");
        return text.replaceAll("\\s+", " ");
    }

    public static String removeSpacesBeforePunctuation(String text) {
        System.out.println("Removing spaces before punctuation...");
        return text.replaceAll(" \\.", ".")
                   .replaceAll(" ,", ",")
                   .replaceAll(" !", "!")
                   .replaceAll(" \\?", "?");
    }

    public static String addSpaceAfterPunctuation(String text) {
        System.out.println("Adding space after punctuation...");
        return text.replaceAll("([.,!?])([^\\s])", "$1 $2");
    }

    public static String fixDecimalNumbers(String text) {
        System.out.println("Fixing decimal numbers...");
        return text.replaceAll("(\\d) \\.(\\d)", "$1.$2");
    }

    public static String fixDashes(String text) {
        System.out.println("Fixing dashes...");
        return text.replaceAll(" \\- ", "-");
    }

    public static String trimText(String text) {
        System.out.println("Trimming text...");
        return text.trim();
    }

    public static void main(String[] args) {

        String text = "  Hello  ,world !This is  a test .  Number 3 .14 and 5 - 6 example! ";

        spaceInvestigator(text);
    }
}
