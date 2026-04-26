package Challenge10_Composition;

public class A_smart_kitchen {
   
    static class CoffeeMaker {
        private boolean hasWorkToDo;

        public void setHasWorkToDo(boolean value) {
            this.hasWorkToDo = value;
        }

        public void brewCoffee() {
            if (hasWorkToDo) {
                System.out.println("Brewing coffee...");
                hasWorkToDo = false;
            }
        }
    }

    static class DishWasher {
        private boolean hasWorkToDo;

        public void setHasWorkToDo(boolean value) {
            this.hasWorkToDo = value;
        }

        public void doDishes() {
            if (hasWorkToDo) {
                System.out.println("Washing dishes...");
                hasWorkToDo = false;
            }
        }
    }

    static class Refrigerator {
        private boolean hasWorkToDo;

        public void setHasWorkToDo(boolean value) {
            this.hasWorkToDo = value;
        }

        public void orderFood() {
            if (hasWorkToDo) {
                System.out.println("Ordering food...");
                hasWorkToDo = false;
            }
        }
    }

    static class SmartKitchen {
        private CoffeeMaker brewMaster = new CoffeeMaker();
        private DishWasher dishWasher = new DishWasher();
        private Refrigerator iceBox = new Refrigerator();

        public void addWater() {
            brewMaster.setHasWorkToDo(true);
        }

        public void pourMilk() {
            iceBox.setHasWorkToDo(true);
        }

        public void loadDishwasher() {
            dishWasher.setHasWorkToDo(true);
        }

        public void setKitchenState(boolean coffee, boolean fridge, boolean dishes) {
            brewMaster.setHasWorkToDo(coffee);
            iceBox.setHasWorkToDo(fridge);
            dishWasher.setHasWorkToDo(dishes);
        }

        public void doKitchenWork() {
            brewMaster.brewCoffee();
            dishWasher.doDishes();
            iceBox.orderFood();
        }
    }

    public static void main(String[] args) {

        SmartKitchen kitchen = new SmartKitchen();

        System.out.println("Run 1:");
        kitchen.setKitchenState(true, true, true);
        kitchen.doKitchenWork();

        System.out.println();

        System.out.println("Run 2:");
        kitchen.addWater();
        kitchen.pourMilk();
        kitchen.loadDishwasher();
        kitchen.doKitchenWork();
    }
}