package Challenge14_Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class A_grocery_list {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> groceryList = new ArrayList<>();

        boolean running = true;

        while (running) {
            printMenu();

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                continue;
            }

            switch (choice) {
                case 0:
                    running = false;
                    break;

                case 1:
                    System.out.println("Enter items to add, separated by commas:");
                    String addInput = scanner.nextLine();
                    addItems(groceryList, addInput);
                    printSortedList(groceryList);
                    break;

                case 2:
                    System.out.println("Enter items to remove, separated by commas:");
                    String removeInput = scanner.nextLine();
                    removeItems(groceryList, removeInput);
                    printSortedList(groceryList);
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("Available actions:");
        System.out.println("0 - to shutdown");
        System.out.println("1 - to add item(s) to list (comma delimited list)");
        System.out.println("2 - to remove any items (comma delimited list)");
        System.out.println("Enter a number for which action you want to do:");
    }

    public static void addItems(ArrayList<String> groceryList, String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String trimmedItem = item.trim();

            if (!trimmedItem.isEmpty() && !groceryList.contains(trimmedItem)) {
                groceryList.add(trimmedItem);
            }
        }
    }

    public static void removeItems(ArrayList<String> groceryList, String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String trimmedItem = item.trim();
            groceryList.remove(trimmedItem);
        }
    }

    public static void printSortedList(ArrayList<String> groceryList) {
        Collections.sort(groceryList);

        System.out.println("Grocery list:");

        if (groceryList.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (String item : groceryList) {
                System.out.println(item);
            }
        }
    }
}