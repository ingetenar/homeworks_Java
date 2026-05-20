package Challenge18_Generic_classes;

import java.util.ArrayList;
import java.util.List;

interface Mappable {
    void render();

    static double[] stringToLatLon(String s) {
        String[] parts = s.split(",");
        return new double[]{
                Double.parseDouble(parts[0].trim()),
                Double.parseDouble(parts[1].trim())
        };
    }
}

abstract class Point implements Mappable {
    private final double[] location;

    Point(String location) {
        this.location = Mappable.stringToLatLon(location);
    }

    protected String location() {
        return location[0] + ", " + location[1];
    }

    public void render() {
        System.out.println("Point at " + location());
    }
}

abstract class Line implements Mappable {
    private final double[][] locations;

    Line(String... locations) {
        this.locations = new double[locations.length][];
        for (int i = 0; i < locations.length; i++) {
            this.locations[i] = Mappable.stringToLatLon(locations[i]);
        }
    }

    protected String locations() {
        StringBuilder sb = new StringBuilder();
        for (double[] loc : locations) {
            sb.append("[").append(loc[0]).append(", ").append(loc[1]).append("] ");
        }
        return sb.toString();
    }

    public void render() {
        System.out.println("Line: " + locations());
    }
}

class Park extends Point {
    private final String name;

    Park(String name, String location) {
        super(location);
        this.name = name;
    }

    public void render() {
        System.out.println("Park " + name + " at " + location());
    }
}

class River extends Line {
    private final String name;

    River(String name, String... locations) {
        super(locations);
        this.name = name;
    }

    public void render() {
        System.out.println("River " + name + " through " + locations());
    }
}

class Layer<T extends Mappable> {
    private final List<T> elements = new ArrayList<>();

    void add(T element) {
        elements.add(element);
    }

    void renderLayer() {
        for (T e : elements) {
            e.render();
        }
    }
}

class Main {
    public static void main(String[] args) {
        Layer<Mappable> layer = new Layer<>();

        layer.add(new Park("Lahemaa", "59.5, 25.5"));
        layer.add(new Park("Soomaa", "58.4, 25.0"));

        layer.add(new River("Narva", "59.3, 28.2", "59.4, 28.1"));
        layer.add(new River("Emajõgi", "58.3, 26.5", "58.4, 26.7"));

        layer.renderLayer();
    }
}