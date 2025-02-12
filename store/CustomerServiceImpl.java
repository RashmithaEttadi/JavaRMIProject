
package store;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService {

    private List<Product> cart;
    private List<Order> orders;

    protected CustomerServiceImpl() throws RemoteException {
        super();
        cart = new ArrayList<>();
        orders = new ArrayList<>();    }

    @Override
    public boolean login(String email, String password) throws RemoteException {
        String customerEmail = "customer@example.com";
        String customerPassword = "customer123";
        return email.equals(customerEmail) && password.equals(customerPassword);
    }

    @Override
    public void addToCart(Product product, Integer quantity) throws RemoteException {
        for (int i = 0; i < quantity; i++) {
            cart.add(product);
        }
    }

    @Override
    public void removeFromCart(Product product) throws RemoteException {
        cart.remove(product);
    }

    @Override
    public Order purchase(ShoppingCart cart) throws RemoteException {
        Order order = new Order(cart); 
        order.setId(1);
        order.setOrderDate(new Date());
        order.setStatus(OrderStatus.PLACED);
    
        for (Product product : cart.getItems()) {
            product.addOrder(order);
        }
    
        return order;
    }
    
}

