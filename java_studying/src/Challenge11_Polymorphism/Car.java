package Challenge11_Polymorphism;

public class Car {
    
protected String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        System.out.println("Starting engine...");
    }

    public void drive() {
        runEngine();
        System.out.println("Driving " + description);
    }

    protected void runEngine() {
        System.out.println("Engine is running...");
    }
}

class FuelPoweredCar extends Car {
    private int fuelLevel;
    private int horsepower;

    public FuelPoweredCar(String description, int fuelLevel, int horsepower) {
        super(description);
        this.fuelLevel = fuelLevel;
        this.horsepower = horsepower;
    }

    @Override
    public void startEngine() {
        System.out.println("Fuel car engine started with key.");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Fuel level: " + fuelLevel);
        System.out.println("Horsepower: " + horsepower);
    }
}

class ElectricCar extends Car {
    private int batteryLevel;
    private int range;

    public ElectricCar(String description, int batteryLevel, int range) {
        super(description);
        this.batteryLevel = batteryLevel;
        this.range = range;
    }

    @Override
    public void startEngine() {
        System.out.println("Electric motor powered on silently.");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Battery level: " + batteryLevel + "%");
        System.out.println("Range: " + range + " km");
    }
}

class HybridCar extends Car {
    private int fuelLevel;
    private int batteryLevel;

    public HybridCar(String description, int fuelLevel, int batteryLevel) {
        super(description);
        this.fuelLevel = fuelLevel;
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void startEngine() {
        System.out.println("Hybrid system started.");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Fuel level: " + fuelLevel);
        System.out.println("Battery level: " + batteryLevel + "%");
    }
}

class Main {
    public static void main(String[] args) {

        Car fuelCar = new FuelPoweredCar("BMW M5", 80, 600);
        Car electricCar = new ElectricCar("Tesla Model S", 95, 650);
        Car hybridCar = new HybridCar("Toyota Prius", 50, 70);

        Car[] cars = {fuelCar, electricCar, hybridCar};

        for (Car car : cars) {
            System.out.println("\nRuntime type: " + car.getClass().getSimpleName());
            car.startEngine();
            car.drive();
        }
    }
}