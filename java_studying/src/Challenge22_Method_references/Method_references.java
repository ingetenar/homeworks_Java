package Challenge22_Method_references;

import java.util.*;
import java.util.function.UnaryOperator;

class Main {
    public static void main(String[] args) {

        String[] names = {"Arvo", "Liisa", "Janis", "Liga", "Jonas", "Mindaugas", "Emma", "Nils"};

        List<UnaryOperator<String>> transformations = new ArrayList<>();

        transformations.add(String::toUpperCase);

        Random random = new Random();
        transformations.add(s -> s + " " + (char) ('A' + random.nextInt(26)) + ".");

        transformations.add(s -> {
            String first = s.split(" ")[0];
            return s + " " + new StringBuilder(first).reverse();
        });

        transformations.add(String::trim);

        applyTransformations(names, transformations);
    }

    static void applyTransformations(String[] array, List<UnaryOperator<String>> ops) {

        for (UnaryOperator<String> op : ops) {
            Arrays.setAll(array, i -> op.apply(array[i]));
            Arrays.stream(array).forEach(System.out::println);
            System.out.println("--------");
        }
    }
}