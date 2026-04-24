package Challenge6_Classes;

import java.io.File;
import java.util.Scanner;

public class Studio_films {

    public static void main(String[] args) {

        try {
            File file = new File("java_studying/src/films.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close();

        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}