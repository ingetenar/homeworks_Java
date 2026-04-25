package Challenge7_Static;

public class Carpet_cost_calculator {

    private double width;
    private double length;
    private static double squareMeterCost = 8; 

    public Carpet_cost_calculator(double width, double length) {
        this.width = width < 0 ? 0 : width;
        this.length = length < 0 ? 0 : length;
    }

    public double getArea() {
        return width * length;
    }
    
    public double getTotalCost() {
        return getArea() * squareMeterCost;
    }

    public static void main(String[] args) {

        Carpet_cost_calculator carpet1 = new Carpet_cost_calculator(10, 12);
        Carpet_cost_calculator carpet2 = new Carpet_cost_calculator(5, 5);
        Carpet_cost_calculator carpet3 = new Carpet_cost_calculator(-2, 8);

        System.out.println("Carpet 1 cost: " + carpet1.getTotalCost());
        System.out.println("Carpet 2 cost: " + carpet2.getTotalCost());
        System.out.println("Carpet 3 cost: " + carpet3.getTotalCost());
    }
}