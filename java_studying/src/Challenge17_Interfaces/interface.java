package Challenge17_Interfaces;

interface Mappable {
    String JSON_PROPERTY = "\"properties\" : { %s }";

    String getLabel();
    String getMarker();
    Geometry getShape();

    default String toJSON() {
        return JSON_PROPERTY.formatted(
                "\"type\" : \"" + getShape() + "\", " +
                "\"label\" : \"" + getLabel() + "\", " +
                "\"marker\" : \"" + getMarker() + "\""
        );
    }

    static void mapIt(Mappable m) {
        System.out.println(m.toJSON());
    }
}

enum Geometry {
    POINT, LINE, POLYGON
}

enum Color {
    RED, GREEN, ORANGE
}

enum PointMarker {
    STAR, CIRCLE, SQUARE
}

enum LineMarker {
    SOLID, DOTTED
}

class Building implements Mappable {
    private final String name;
    private final Usage usage;

    enum Usage {
        ENTERTAINMENT, GOVERNMENT, RESIDENTIAL
    }

    Building(String name, Usage usage) {
        this.name = name;
        this.usage = usage;
    }

    public String getLabel() {
        return name + " (" + usage + ")";
    }

    public String getMarker() {
        return Color.ORANGE + " " + PointMarker.STAR;
    }

    public Geometry getShape() {
        return Geometry.POINT;
    }

    public String toJSON() {
        return JSON_PROPERTY.formatted(
                "\"type\" : \"" + getShape() + "\", " +
                "\"label\" : \"" + getLabel() + "\", " +
                "\"marker\" : \"" + getMarker() + "\", " +
                "\"name\" : \"" + name + "\", " +
                "\"usage\" : \"" + usage + "\""
        );
    }
}

class UtilityLine implements Mappable {
    private final String name;
    private final Utility utility;

    enum Utility {
        FIBER_OPTIC, ELECTRICAL
    }

    UtilityLine(String name, Utility utility) {
        this.name = name;
        this.utility = utility;
    }

    public String getLabel() {
        return name + " (" + utility + ")";
    }

    public String getMarker() {
        return Color.GREEN + " " + LineMarker.DOTTED;
    }

    public Geometry getShape() {
        return Geometry.LINE;
    }

    public String toJSON() {
        return JSON_PROPERTY.formatted(
                "\"type\" : \"" + getShape() + "\", " +
                "\"label\" : \"" + getLabel() + "\", " +
                "\"marker\" : \"" + getMarker() + "\", " +
                "\"name\" : \"" + name + "\", " +
                "\"utility\" : \"" + utility + "\""
        );
    }
}

class Main {
    public static void main(String[] args) {
        Mappable b = new Building("Sakala keskus", Building.Usage.ENTERTAINMENT);
        Mappable u = new UtilityLine("Karamelli tänav", UtilityLine.Utility.FIBER_OPTIC);

        Mappable.mapIt(b);
        Mappable.mapIt(u);
    }
}