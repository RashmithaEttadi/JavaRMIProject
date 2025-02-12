package store;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface CustomerService extends Remote {
    boolean login(String email, String password) throws RemoteException;
    void addToCart(Product product, Integer quantity) throws RemoteException;
    void removeFromCart(Product product) throws RemoteException;
    Order purchase(ShoppingCart cart) throws RemoteException;
}

