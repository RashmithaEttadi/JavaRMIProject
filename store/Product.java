package store;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Product implements Serializable {

    private int id;
    private String name;
    private String description;
    private double price;
    private int quantityInStock;
    private List<Order> orders; // Association with Order (many-to-many)

    public Product(int id, String name, String description, double price, int quantityInStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.orders = new ArrayList<>();
    }

    // Getters and setters for all attributes
    public void updateDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void updatePrice(double price) {
        this.price = price;
    }

    public void removeFromStock(int quantity) {
        this.quantityInStock -= quantity;
    }

    public void addToStock(int quantity) {
        this.quantityInStock += quantity;
    }

    public void addOrder(Order order) {
        orders.add(order); // Association with Order (many-to-many)
    }
}
