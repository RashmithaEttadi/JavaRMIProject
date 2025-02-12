package store;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface FrontController extends Remote {
    boolean handleRequest(String serviceName, String methodName, Object... args) throws RemoteException;
    List<Product> getAllProducts() throws RemoteException;
}


