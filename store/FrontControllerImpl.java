package store;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class FrontControllerImpl extends UnicastRemoteObject implements FrontController {
    private Map<String, Object> services;

    protected FrontControllerImpl() throws RemoteException {
        super();
        services = new HashMap<>();
        // Initialize services
        services.put("AdministratorService", new AdministratorServiceImpl());
        services.put("CustomerService", new CustomerServiceImpl());
        services.put("ProductService", new ProductServiceImpl());
    }
@Override
public boolean handleRequest(String serviceName, String methodName, Object... args) throws RemoteException {
    Object service = services.get(serviceName);
    if (service != null) {
        try {
            if (methodName.equals("login")) {
                return (boolean) service.getClass().getMethod(methodName, String.class, String.class).invoke(service, args);
            } else {
                Method method;
                if (args.length == 0) {
                    method = service.getClass().getMethod(methodName);
                    method.invoke(service);
                } else {
                    Class<?>[] parameterTypes = new Class[args.length];
                    for (int i = 0; i < args.length; i++) {
                        parameterTypes[i] = args[i].getClass();
                    }
                    method = service.getClass().getMethod(methodName, parameterTypes);
                    method.invoke(service, args);
                }
                return true;
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
            // Error handling request
            throw new RemoteException("Error handling request", e);
        }
    } else {
        // Service not found
        throw new RemoteException("Service not found: " + serviceName);
    }
}

    @Override
    public List<Product> getAllProducts() throws RemoteException {
        ProductService productService = (ProductService) services.get("ProductService");
        return productService.getAllProducts();
    }
}
