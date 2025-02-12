package store;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {

            // Look up the FrontController
            FrontController frontController = (FrontController) Naming.lookup("//in-csci-rrpc05.cs.iupui.edu/FrontController");

            // Create a scanner object to read user input
            Scanner scanner = new Scanner(System.in);

            // Prompt user to enter email and password
            System.out.println("Enter your email:");
            String email = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();

            // Example: Invoke login method for Administrator
            boolean adminLoginSuccess = frontController.handleRequest("AdministratorService", "login", email, password);
            if (adminLoginSuccess) {
                System.out.println("Administrator login successful");
                // Create a new customer
                Customer newCustomer = createCustomer(scanner);
                frontController.handleRequest("AdministratorService", "createUser", newCustomer);

                // Update user details
                newCustomer = updateCustomer(scanner, newCustomer);
                frontController.handleRequest("AdministratorService", "updateUser", newCustomer);

                // Remove user
                boolean remove = removeCustomerConfirmation(scanner, newCustomer.getName());
                if (remove) {
                    frontController.handleRequest("AdministratorService", "removeUser", newCustomer);
                    System.out.println("Customer removed successfully.");
                } else {
                    System.out.println("Customer removal cancelled.");
                }

                // Add a new product
                Product newProduct = createProduct(scanner);
                frontController.handleRequest("AdministratorService", "addProduct", newProduct);

                // Update product details
                newProduct = updateProduct(scanner, newProduct);
                frontController.handleRequest("AdministratorService", "updateProduct", newProduct);

                // Remove product
                boolean removeProduct = removeProductConfirmation(scanner, newProduct.getName());
                if (removeProduct) {
                    frontController.handleRequest("AdministratorService", "removeProduct", newProduct);
                    System.out.println("Product removed successfully.");
                } else {
                    System.out.println("Product removal cancelled.");
                }

                // Close scanner
                scanner.close();
            } else if (!adminLoginSuccess) {
                
            
            // Example: Invoke login method for Customer
    boolean customerLoginSuccess = frontController.handleRequest("CustomerService", "login", email, password);
if (customerLoginSuccess) {
    System.out.println("Customer login successful");
    // If successful, retrieve the list of products
    List<Product> availableProducts = frontController.getAllProducts();
    System.out.println("In store");
    // Show available products
    if (!availableProducts.isEmpty()) {
        System.out.println("Available Products:");
        for (Product product : availableProducts) {
            System.out.println(product.getId()+" - "+product.getName() + " - " + product.getDescription() + " - $" + product.getPrice());
        }
    } else {
        System.out.println("No products available.");
    }

    // Allow customer to add products to cart
    System.out.println("Enter product ID to add to cart (0 to finish):");
    int productId;
    while ((productId = Integer.parseInt(scanner.nextLine())) != 0) {
        // Find product by ID
        Product selectedProduct = null;
        for (Product product : availableProducts) {
            if (product.getId() == productId) {
                selectedProduct = product;
                break;
            }
        }
        if (selectedProduct != null) {
            System.out.println("Enter quantity:");
            int quantity = Integer.parseInt(scanner.nextLine());
            frontController.handleRequest("CustomerService", "addToCart", selectedProduct, quantity);
            System.out.println("Product added to cart.");
        } else {
            System.out.println("Invalid product ID.");
        }
    

    // Purchase
    ShoppingCart cart = new ShoppingCart();
    frontController.handleRequest("CustomerService", "purchase", cart);
    System.out.println("Order placed successfully! Thank you for shopping with us, " + "!");
    }

    
} else {
    System.out.println("Customer login failed");
}

            }
            else{
                System.out.println("Unauthorized access");
            }

            

            // Close scanner
            scanner.close();

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    // Method to create a new customer using user input
    private static Customer createCustomer(Scanner scanner) {
        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();
        System.out.println("Enter customer email:");
        String customerEmail = scanner.nextLine();
        System.out.println("Enter customer password:");
        String customerPassword = scanner.nextLine();
        System.out.println("Enter customer shipping address:");
        String shippingAddress = scanner.nextLine();
        return new Customer(1, customerName, customerEmail, customerPassword, shippingAddress);
    }

    // Method to update customer details using user input
    private static Customer updateCustomer(Scanner scanner, Customer customer) {
        System.out.println("Do you want to update customer details? (yes/no)");
        String updateChoice = scanner.nextLine().toLowerCase();
        if (updateChoice.equals("yes")) {
            System.out.println("Enter new customer name:");
            String newName = scanner.nextLine();
            System.out.println("Enter new customer email:");
            String newEmail = scanner.nextLine();
            System.out.println("Enter new customer shipping address:");
            String newShippingAddress = scanner.nextLine();
            customer.setName(newName);
            customer.setEmail(newEmail);
            customer.setShippingAddress(newShippingAddress);
        }
        return customer;
    }

    // Method to confirm customer removal
    private static boolean removeCustomerConfirmation(Scanner scanner, String customerName) {
        System.out.println("Do you want to remove customer " + customerName + "? (yes/no)");
        String removeChoice = scanner.nextLine().toLowerCase();
        return removeChoice.equals("yes");
    }

    // Method to create a new product using user input
    private static Product createProduct(Scanner scanner) {
        System.out.println("Enter product name:");
        String productName = scanner.nextLine();
        System.out.println("Enter product description:");
        String productDescription = scanner.nextLine();
        System.out.println("Enter product price:");
        double productPrice = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter product quantity in stock:");
        int productQuantity = Integer.parseInt(scanner.nextLine());
        return new Product(1, productName, productDescription, productPrice, productQuantity);
    }

    // Method to update product details using user input
    private static Product updateProduct(Scanner scanner, Product product) {
        System.out.println("Do you want to update product details? (yes/no)");
        String updateChoice = scanner.nextLine().toLowerCase();
        if (updateChoice.equals("yes")) {
            System.out.println("Enter new product name:");
            String newName = scanner.nextLine();
            System.out.println("Enter new product description:");
            String newDescription = scanner.nextLine();
            System.out.println("Enter new product price:");
            double newPrice = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter new product quantity in stock:");
            int newQuantity = Integer.parseInt(scanner.nextLine());
            product.setName(newName);
            product.setDescription(newDescription);
            product.setPrice(newPrice);
            product.setQuantityInStock(newQuantity);
        }
        return product;
    }

    // Method to confirm product removal
    private static boolean removeProductConfirmation(Scanner scanner, String productName) {
        System.out.println("Do you want to remove product " + productName + "? (yes/no)");
        String removeChoice = scanner.nextLine().toLowerCase();
        return removeChoice.equals("yes");
    }
}


