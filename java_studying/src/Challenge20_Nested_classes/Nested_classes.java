package Challenge20_Nested_classes;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

class Meal {

    class Item {
        private final String name;
        private final String type;
        private final double price;

        Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        public String toString() {
            return name + " (" + type + ") : " + price;
        }
    }

    class Burger extends Item {
        private final List<Item> toppings = new ArrayList<>();

        Burger(String name, double price) {
            super(name, "Burger", price);
        }

        void addToppings(String... toppingNames) {
            for (String t : toppingNames) {
                double cost = switch (t.toLowerCase()) {
                    case "cheese", "lettuce" -> 0;
                    default -> 1.0;
                };
                toppings.add(new Item(t, "Topping", cost));
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(super.toString());
            for (Item t : toppings) {
                sb.append("\n  ").append(t);
            }
            return sb.toString();
        }
    }

    private final Burger burger;

    Meal() {
        burger = new Burger("Basic Burger", 5.0);
    }

    void addBurgerToppings(String... toppings) {
        burger.addToppings(toppings);
    }

    void printMeal() {
        System.out.println(burger);
    }
}

record Employee(String firstName, String lastName, LocalDate hireDate) {}

class Main {

    static void processEmployees(List<Employee> list) {

        class LocalEmployee {
            private final String fullName;
            private final int yearsWorked;

            LocalEmployee(Employee e) {
                this.fullName = e.firstName() + " " + e.lastName();
                this.yearsWorked = Period.between(e.hireDate(), LocalDate.now()).getYears();
            }

            public String toString() {
                return fullName + " - " + yearsWorked;
            }
        }

        List<LocalEmployee> localList = new ArrayList<>();
        for (Employee e : list) {
            localList.add(new LocalEmployee(e));
        }

        localList.sort(new Comparator<LocalEmployee>() {
            public int compare(LocalEmployee o1, LocalEmployee o2) {
                return o1.fullName.compareTo(o2.fullName);
            }
        });

        for (var e : localList) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        Meal meal = new Meal();
        meal.addBurgerToppings("cheese", "bacon", "onion");
        meal.printMeal();

        List<Employee> employees = List.of(
                new Employee("John", "Smith", LocalDate.of(2015, 1, 10)),
                new Employee("Anna", "Brown", LocalDate.of(2018, 5, 20)),
                new Employee("Mike", "Davis", LocalDate.of(2012, 3, 15))
        );

        processEmployees(employees);
    }
}
