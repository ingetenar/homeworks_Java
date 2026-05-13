package Challenge13_2D_arrays;

import java.util.Random;

class Stone {
    protected int x;
    protected int y;

    public Stone(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public char getSymbol() {
        return '#';
    }
}

class Weed extends Stone {
    protected boolean alive = true;
    protected Random random = new Random();

    public Weed(int x, int y) {
        super(x, y);
    }

    public boolean isAlive() {
        return alive;
    }

    public void die() {
        alive = false;
    }

    public char getSymbol() {
        return 'W';
    }

    public void grow(Stone[][] pond) {
        if (!alive) return;

        // Weed иногда создаёт новую Weed рядом
        if (random.nextInt(100) < 30) {
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int i = 0; i < dx.length; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (isInside(pond, newX, newY) && pond[newY][newX] == null) {
                    pond[newY][newX] = new Weed(newX, newY);
                    break;
                }
            }
        }
    }

    protected boolean isInside(Stone[][] pond, int x, int y) {
        return y >= 0 && y < pond.length && x >= 0 && x < pond[0].length;
    }
}

class Fish extends Weed {
    private int hunger = 0;
    private final int maxHunger = 5;

    public Fish(int x, int y) {
        super(x, y);
    }

    @Override
    public char getSymbol() {
        return 'F';
    }

    public void live(Stone[][] pond) {
        if (!alive) return;

        // Сначала рыба пытается съесть Weed рядом
        if (eatWeed(pond)) {
            hunger = 0;
            return;
        }

        // Если не поела — становится голоднее
        hunger++;

        if (hunger >= maxHunger) {
            die();
            pond[y][x] = null;
            return;
        }

        // Если еды рядом нет — двигается случайно
        move(pond);
    }

    private boolean eatWeed(Stone[][] pond) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (isInside(pond, newX, newY)) {
                Stone object = pond[newY][newX];

                // Важно: Fish extends Weed, поэтому проверяем, что это Weed, но не Fish
                if (object instanceof Weed && !(object instanceof Fish)) {
                    pond[newY][newX] = null;

                    pond[y][x] = null;
                    x = newX;
                    y = newY;
                    pond[y][x] = this;

                    return true;
                }
            }
        }

        return false;
    }

    private void move(Stone[][] pond) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int randomDirection = random.nextInt(4);

        for (int i = 0; i < 4; i++) {
            int direction = (randomDirection + i) % 4;

            int newX = x + dx[direction];
            int newY = y + dy[direction];

            if (isInside(pond, newX, newY) && pond[newY][newX] == null) {
                pond[y][x] = null;

                x = newX;
                y = newY;

                pond[y][x] = this;
                return;
            }
        }
    }
}

public class A_pond_model {
    public static void main(String[] args) {
        int width = 12;
        int height = 8;

        Stone[][] pond = new Stone[height][width];

        createBorders(pond);

        pond[2][2] = new Weed(2, 2);
        pond[2][4] = new Weed(4, 2);
        pond[4][5] = new Weed(5, 4);
        pond[5][8] = new Weed(8, 5);

        pond[3][3] = new Fish(3, 3);
        pond[5][6] = new Fish(6, 5);

        pond[3][8] = new Stone(8, 3);
        pond[4][8] = new Stone(8, 4);

        for (int cycle = 1; cycle <= 30; cycle++) {
            System.out.println("Cycle " + cycle);
            printPond(pond);
            runCycle(pond);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Simulation interrupted");
            }
        }
    }

    public static void createBorders(Stone[][] pond) {
        int height = pond.length;
        int width = pond[0].length;

        for (int y = 0; y < height; y++) {
            pond[y][0] = new Stone(0, y);
            pond[y][width - 1] = new Stone(width - 1, y);
        }

        for (int x = 0; x < width; x++) {
            pond[0][x] = new Stone(x, 0);
            pond[height - 1][x] = new Stone(x, height - 1);
        }
    }

    public static void runCycle(Stone[][] pond) {
        int height = pond.length;
        int width = pond[0].length;

        Stone[][] objectsCopy = new Stone[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                objectsCopy[y][x] = pond[y][x];
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Stone object = objectsCopy[y][x];

                if (object instanceof Fish) {
                    Fish fish = (Fish) object;

                    if (fish.isAlive()) {
                        fish.live(pond);
                    }

                } else if (object instanceof Weed) {
                    Weed weed = (Weed) object;

                    if (weed.isAlive()) {
                        weed.grow(pond);
                    }
                }
            }
        }
    }

    public static void printPond(Stone[][] pond) {
        for (int y = 0; y < pond.length; y++) {
            for (int x = 0; x < pond[y].length; x++) {
                if (pond[y][x] == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(pond[y][x].getSymbol() + " ");
                }
            }
            System.out.println();
        }

        System.out.println();
    }
}