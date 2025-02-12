package store;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdministratorServiceImpl extends UnicastRemoteObject implements AdministratorService {
    private List<Customer> customers;
    private List<Product> products;

    private Map<String, String> administratorCredentials;
    protected AdministratorServiceImpl() throws RemoteException {
        super();
        this.customers = new ArrayList<>();
        administratorCredentials = new HashMap<>();
        administratorCredentials.put("admin@example.com", "admin123");
        this.products = new ArrayList<>(); 
    }
   
    @Override
    public boolean login(String email, String password) throws RemoteException {
    return email.equals("admin@example.com") && password.equals("admin123");
    }

    @Override
    public void createUser(Customer customer) throws RemoteException {
        customers.add(customer);
        System.out.println("New customer created: " + customer.getName());
    }

    @Override
    public void updateUser(Customer customer) throws RemoteException {
        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                c.setName(customer.getName());
                c.setEmail(customer.getEmail());
                c.setHashedPassword(customer.getHashedPassword());
                c.setShippingAddress(customer.getShippingAddress());
                System.out.println("Customer updated: " + c.getName());
                break;
            }
        }
    }

    @Override
    public void removeUser(Customer customer) throws RemoteException {
        customers.removeIf(c -> c.getId() == customer.getId());
        System.out.println("Customer removed: " + customer.getName());
    }

    @Override
    public List<Product> getProducts() throws RemoteException {
        return products;
    }
    
    @Override
    public void addProduct(Product product) throws RemoteException {
    products.add(product);
    System.out.println("Product added: " + product.getName());
    }

    @Override
    public void updateProduct(Product product) throws RemoteException {
    for (Product p : products) {
        if (p.getId() == product.getId()) {
            p.setName(product.getName());
            p.setDescription(product.getDescription());
            p.setPrice(product.getPrice());
            p.setQuantityInStock(product.getQuantityInStock());
            System.out.println("Product updated: " + p.getName());
            break;
        }
    }
    }

    @Override
    public void removeProduct(Product product) throws RemoteException {
    products.removeIf(p -> p.getId() == product.getId());
    System.out.println("Product removed: " + product.getName());
    }

}


