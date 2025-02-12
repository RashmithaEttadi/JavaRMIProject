package store;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl extends UnicastRemoteObject implements ProductService {
    protected ProductServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<Product> getAllProducts() throws RemoteException {
        List<Product> dummyProducts = new ArrayList<>();
        dummyProducts.add(new Product(1, "TShirt", "CalvinKlein", 50.0, 100));
        dummyProducts.add(new Product(2, "Trousers", "UnderArmour", 80.0, 50));
        return dummyProducts;
    }
}

