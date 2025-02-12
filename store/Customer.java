package store;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Customer implements Serializable{

    private int id;
    
    private String name;
    private String email;
    private String hashedPassword;
    private String shippingAddress;
    private List<Order> orders; // Association with Order

    public Customer(int id, String name, String email, String hashedPassword, String shippingAddress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.shippingAddress = shippingAddress;
        this.orders = new ArrayList<>();
    }

    // Getters and setters for all attributes
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void register() {
    
    }

    public boolean login(String email, String password) {
        return false;
    }

    public void addToCart(Product product, int quantity) {
    }

    public void removeFromCart(Product product) {
    }

    public Order purchase(ShoppingCart cart) {
        Order order = new Order(cart);
        orders.add(order); 
        return order;
    }

}
