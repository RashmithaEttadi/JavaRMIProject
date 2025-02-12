package store;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ProductService extends Remote {
    List<Product> getAllProducts() throws RemoteException;
}


