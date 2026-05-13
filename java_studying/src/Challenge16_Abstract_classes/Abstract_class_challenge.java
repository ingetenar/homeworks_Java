package Challenge16_Abstract_classes;

import java.util.ArrayList;

abstract class ProductForSale {
    protected String type;
    protected double price;
    protected String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getSalesPrice(int quantity) {
        return quantity * price;
    }

    public void printPricedItem(int quantity) {
        System.out.println(quantity + " x " + type + " = " + getSalesPrice(quantity) + " euro");
    }

    public abstract void showDetails();

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}

class DesktopComputer extends ProductForSale {
    public DesktopComputer(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println("------------------------------");
        System.out.println(description);
        System.out.println("The price of the piece is " + price + " euro.");
        System.out.println(type);
    }
}

class Laptop extends ProductForSale {
    public Laptop(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println("------------------------------");
        System.out.println(description);
        System.out.println("The price of the piece is " + price + " euro.");
        System.out.println(type);
    }
}

class ComputerDesk extends ProductForSale {
    public ComputerDesk(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println("------------------------------");
        System.out.println(description);
        System.out.println("The price of the piece is " + price + " euro.");
        System.out.println(type);
    }
}

class OrderItem {
    private int quantity;
    private ProductForSale product;

    public OrderItem(int quantity, ProductForSale product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductForSale getProduct() {
        return product;
    }
}

public class Abstract_class_challenge {
    private static ArrayList<ProductForSale> productsForSale = new ArrayList<>();
    private static ArrayList<OrderItem> order = new ArrayList<>();

    public static void main(String[] args) {
        productsForSale.add(new DesktopComputer(
                "Desktop Computer",
                700.0,
                "This desktop is a modern computer"
        ));

        productsForSale.add(new Laptop(
                "Laptop",
                900.0,
                "This laptop is a modern computer"
        ));

        productsForSale.add(new ComputerDesk(
                "Computer Desk",
                100.0,
                "This desk was manufactured in Estonia"
        ));

        showProducts();

        addItemToOrder(0, 1);
        addItemToOrder(1, 2);
        addItemToOrder(2, 1);

        printOrder();
    }

    public static void showProducts() {
        for (ProductForSale product : productsForSale) {
            product.showDetails();
        }

        System.out.println("------------------------------");
    }

    public static void addItemToOrder(int productIndex, int quantity) {
        if (productIndex >= 0 && productIndex < productsForSale.size()) {
            ProductForSale product = productsForSale.get(productIndex);
            order.add(new OrderItem(quantity, product));
        }
    }

    public static void printOrder() {
        double total = 0;

        System.out.println();
        System.out.println("Sales receipt");
        System.out.println("------------------------------");

        for (OrderItem item : order) {
            ProductForSale product = item.getProduct();
            int quantity = item.getQuantity();

            product.printPricedItem(quantity);
            total += product.getSalesPrice(quantity);
        }

        System.out.println("------------------------------");
        System.out.println("Total price: " + total + " euro");
    }
}