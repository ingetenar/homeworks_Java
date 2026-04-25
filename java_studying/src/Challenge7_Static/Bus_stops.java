package Challenge7_Static;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bus_stops {

    public record BusStop(String id, String name, double latitude, double longitude, String area) {

        public static double getDistance(BusStop a, BusStop b) {
            final double R = 6371;

            double lat1 = Math.toRadians(a.latitude);
            double lon1 = Math.toRadians(a.longitude);
            double lat2 = Math.toRadians(b.latitude);
            double lon2 = Math.toRadians(b.longitude);

            double dlat = lat2 - lat1;
            double dlon = lon2 - lon1;

            double h = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
                    Math.cos(lat1) * Math.cos(lat2) *
                            Math.sin(dlon / 2) * Math.sin(dlon / 2);

            double c = 2 * Math.atan2(Math.sqrt(h), Math.sqrt(1 - h));

            return R * c;
        }

        public static boolean isSameArea(BusStop a, BusStop b) {
            return a.area.equalsIgnoreCase(b.area);
        }
    }

    public static List<BusStop> readStops(String path) {
        List<BusStop> list = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length < 5) {
                    continue;
                }

                String id = parts[0];
                String name = parts[1];
                String area = parts[2];
                double latitude = Double.parseDouble(parts[3]);
                double longitude = Double.parseDouble(parts[4]);

                list.add(new BusStop(id, name, latitude, longitude, area));
            }

            scanner.close();

        } catch (Exception e) {
            System.out.println("Error reading file");
        }

        return list;
    }

    public static BusStop getRandomStop(List<BusStop> list) {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {

        System.out.println("Reading bus stops data...");
        List<BusStop> stops = readStops("java_studying/src/stops.txt");

        if (stops.isEmpty()) {
            System.out.println("No bus stops found");
            return;
        }

        System.out.println("Calculating distances between bus stops...");
        System.out.println("Checking if bus stops are in the same area...\n");

        for (int i = 0; i < 5; i++) {
            BusStop a = getRandomStop(stops);
            BusStop b = getRandomStop(stops);

            double distance = BusStop.getDistance(a, b);
            boolean same = BusStop.isSameArea(a, b);

            System.out.printf("Distance between %s in %s and %s in %s is %.1f km\n",
                    a.name(), a.area(), b.name(), b.area(), distance);

            System.out.println("Are they in the same area? " + same);
        }
    }
}