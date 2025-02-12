package store;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

public class Order implements Serializable{

    private int id;
    private Customer customer; // Association with Customer (one-to-many)
    private List<Product> products; // Association with Product (many-to-many)
    private Date orderDate;
    private OrderStatus status; // Enum for order status (e.g., placed, processing, shipped, delivered, canceled)

    public Order(ShoppingCart cart) {
        this.products = new ArrayList<>(cart.getItems()); 
        this.orderDate = new Date();
        this.status = OrderStatus.PLACED; // Set initial status
        // customer.getOrders().add(this); // Update customer's order list (association)
        for (Product product : products) {
            product.addOrder(this); // Update product's order list (association)
        }
    }

    // Getters and setters for all attributes

    public void updateStatus(OrderStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

   
}

