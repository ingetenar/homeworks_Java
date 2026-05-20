package Challenge21_Lambdas;

import java.util.*;

class Main {
    public static void main(String[] args) {

        String[] names = {"anna", "bob", "mike", "level", "john"};

        Arrays.setAll(names, i -> names[i].toUpperCase());
        Arrays.stream(names).forEach(System.out::println);

        Random random = new Random();

        Arrays.setAll(names, i ->
                names[i] + " " + (char) ('A' + random.nextInt(26)) + "."
        );
        Arrays.stream(names).forEach(System.out::println);

        Arrays.setAll(names, i ->
                names[i] + " " + new StringBuilder(names[i].split(" ")[0]).reverse()
        );
        Arrays.stream(names).forEach(System.out::println);

        List<String> list = new ArrayList<>(Arrays.asList(names));

        list.removeIf(s -> {
            String[] parts = s.split(" ");
            return parts[0].equalsIgnoreCase(parts[2]);
        });

        list.forEach(System.out::println);
    }
}
