package store;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface AdministratorService extends Remote {
    void createUser(Customer customer) throws RemoteException;
    void updateUser(Customer customer) throws RemoteException;
    void removeUser(Customer customer) throws RemoteException;
    List<Product> getProducts() throws RemoteException;
    void addProduct(Product product) throws RemoteException; 
    void updateProduct(Product product) throws RemoteException;
    void removeProduct(Product product) throws RemoteException;
    boolean login(String email, String password) throws RemoteException; 
}

