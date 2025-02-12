package store;
import java.util.List;
import java.io.Serializable;

public class Administrator implements Serializable {
    private int id;
    private String name;
    private String email;

    public Administrator(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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
    public Customer createUser(Customer customer) {
        // Logic to create a new customer account (e.g., persist data)
        return customer;
    }

    public void updateUser(Customer customer) {
        // Logic to update existing customer information
    }

    public void removeUser(Customer customer) {
        // Logic to remove a customer account
    }

    public List<Product> getProducts() {
        return null;
        // Logic to retrieve all products
    }

    public void updateProduct(Product product) {
        // Logic to modify product details
    }

    public void removeProduct(Product product) {
        // Logic to remove a product from the store
    }
}
