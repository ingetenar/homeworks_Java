package Challenge8_Inheritance;

import java.util.ArrayList;
import java.util.Random;

class Stone {
    protected int x;
    protected int y;

    public Stone(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void show() {
        System.out.println("Stone at (" + x + ", " + y + ")");
    }
}

class Weed extends Stone {
    private boolean alive = true;

    public Weed(int x, int y) {
        super(x, y);
    }

    public boolean isAlive() {
        return alive;
    }

    public void grow() {
        System.out.println("Weed grows at (" + x + ", " + y + ")");
    }

    public void die() {
        alive = false;
        System.out.println("Weed died at (" + x + ", " + y + ")");
    }

    @Override
    public void show() {
        System.out.println("Weed at (" + x + ", " + y + ")");
    }
}

class Fish extends Weed {
    private Random random = new Random();

    public Fish(int x, int y) {
        super(x, y);
    }

    public void move(ArrayList<Stone> objects) {
        int newX = x + random.nextInt(3) - 1;
        int newY = y + random.nextInt(3) - 1;

        if (newX < 0) newX = 0;
        if (newY < 0) newY = 0;
        if (newX > 9) newX = 9;
        if (newY > 9) newY = 9;

        boolean placeIsBlocked = false;

        for (Stone object : objects) {
            if (object != this && object.x == newX && object.y == newY) {
                if (object instanceof Stone && !(object instanceof Fish)) {
                    placeIsBlocked = true;
                    break;
                }
            }
        }

        if (!placeIsBlocked) {
            x = newX;
            y = newY;
            System.out.println("Fish moved to (" + x + ", " + y + ")");
        } else {
            System.out.println("Fish cannot move to (" + newX + ", " + newY + ")");
        }
    }

    @Override
    public void show() {
        System.out.println("Fish at (" + x + ", " + y + ")");
    }
}

public class A_pond_model {
    public static void main(String[] args) {
        ArrayList<Stone> pond = new ArrayList<>();

        pond.add(new Stone(1, 1));
        pond.add(new Stone(5, 5));

        pond.add(new Weed(2, 2));
        pond.add(new Weed(6, 6));

        pond.add(new Fish(3, 3));
        pond.add(new Fish(7, 7));

        System.out.println("Initial pond:");
        showPond(pond);

        System.out.println("\nLifecycle simulation:");

        for (int day = 1; day <= 5; day++) {
            System.out.println("\nDay " + day);

            for (Stone object : pond) {
                if (object instanceof Fish) {
                    Fish fish = (Fish) object;
                    fish.move(pond);
                } else if (object instanceof Weed) {
                    Weed weed = (Weed) object;
                    weed.grow();
                }
            }

            System.out.println("Current pond:");
            showPond(pond);
        }
    }

    public static void showPond(ArrayList<Stone> pond) {
        for (Stone object : pond) {
            object.show();
        }
    }
}