package Challenge15_LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

class Place {
    private String town;
    private int distance;

    public Place(String town, int distance) {
        this.town = town;
        this.distance = distance;
    }

    public String getTown() {
        return town;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return town + " - " + distance + " km from Tallinn";
    }
}

public class Places_to_visit {
    public static void main(String[] args) {
        LinkedList<Place> places = new LinkedList<>();

        addPlace(places, new Place("Tallinn", 0));
        addPlace(places, new Place("Pärnu", 127));
        addPlace(places, new Place("Viljandi", 147));
        addPlace(places, new Place("Tartu", 179));
        addPlace(places, new Place("Põlva", 224));
        addPlace(places, new Place("Võru", 246));

        Scanner scanner = new Scanner(System.in);
        ListIterator<Place> iterator = places.listIterator();

        boolean forward = true;
        boolean running = true;

        printMenu();

        if (iterator.hasNext()) {
            System.out.println("Visiting " + iterator.next());
        }

        while (running) {
            System.out.println("Enter action:");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "f":
                case "forward":
                    if (!forward) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        forward = true;
                    }

                    if (iterator.hasNext()) {
                        System.out.println("Visiting " + iterator.next());
                    } else {
                        System.out.println("End of the list");
                        forward = false;
                    }
                    break;

                case "b":
                case "backward":
                    if (forward) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        forward = false;
                    }

                    if (iterator.hasPrevious()) {
                        System.out.println("Visiting " + iterator.previous());
                    } else {
                        System.out.println("Start of the list");
                        forward = true;
                    }
                    break;

                case "l":
                case "list":
                case "list places":
                    printPlaces(places);
                    break;

                case "m":
                case "menu":
                    printMenu();
                    break;

                case "q":
                case "quit":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid action");
                    break;
            }
        }

        scanner.close();
    }

    public static void addPlace(LinkedList<Place> places, Place newPlace) {
        if (places.isEmpty()) {
            places.add(newPlace);
            return;
        }

        for (Place place : places) {
            if (place.getTown().equalsIgnoreCase(newPlace.getTown())) {
                return;
            }
        }

        ListIterator<Place> iterator = places.listIterator();

        while (iterator.hasNext()) {
            Place currentPlace = iterator.next();

            if (newPlace.getDistance() < currentPlace.getDistance()) {
                iterator.previous();
                iterator.add(newPlace);
                return;
            }
        }

        places.add(newPlace);
    }

    public static void printPlaces(LinkedList<Place> places) {
        System.out.println("Places to visit:");

        for (Place place : places) {
            System.out.println(place);
        }
    }

    public static void printMenu() {
        System.out.println("Available actions:");
        System.out.println("(F)orward");
        System.out.println("(B)ackward");
        System.out.println("(L)ist Places");
        System.out.println("(M)enu");
        System.out.println("(Q)uit");
    }
}