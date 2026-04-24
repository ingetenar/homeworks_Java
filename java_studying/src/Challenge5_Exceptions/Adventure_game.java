package Challenge5_Exceptions;

public class Adventure_game {
    public static void main(String[] args) {

        while (true) {
            System.out.println("LOST KINGDOM ADVENTURE");
            System.out.println("1. Enter the forest");
            System.out.println("2. Visit the village");
            System.out.println("3. Explore the cave");
            System.out.println("4. Go to the river");
            System.out.println("5. Open inventory");
            System.out.println("Q. Quit");

            String input = System.console().readLine();

            if (input.equalsIgnoreCase("Q")) {
                System.out.println("Game over");
                break;
            }

            switch (input) {
                case "1":
                    System.out.println("You enter the dark forest and hear strange sounds.");
                    break;
                case "2":
                    System.out.println("You visit the village and talk to local people.");
                    break;
                case "3":
                    System.out.println("You explore the cave and find old treasure.");
                    break;
                case "4":
                    System.out.println("You go to the river and refill your water.");
                    break;
                case "5":
                    System.out.println("Your inventory is almost empty.");
                    break;
                default:
                    break;
            }
        }
    }
}