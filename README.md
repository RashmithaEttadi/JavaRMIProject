JavaRMI Application
This Java Remote Method Invocation (Java RMI) application demonstrates a
simple e-commerce system with functionalities for administrators,
customers, and products. It allows administrators to manage users and
products, customers to interact with their shopping carts, and products to
be managed within the system.
Files:
Administrator.java: Defines the Administrator class representing an
administrator with attributes and methods for managing users and products.
AdministratorService.java: Defines the AdministratorService interface for
remote methods related to administrator functionalities.
AdministratorServiceImpl.java: Implements the AdministratorService
interface, providing the server-side logic for administrator
functionalities.
Client.java: Contains the main method for client-side interaction,
demonstrating the usage of services provided by the server.
Customer.java: Represents a customer with attributes and methods for
managing their account and interactions with products.
CustomerService.java: Defines the CustomerService interface for remote
methods related to customer functionalities.
CustomerServiceImpl.java: Implements the CustomerService interface,
providing the server-side logic for customer functionalities.
Order.java: Defines the Order class representing an order placed by a
customer, with associated products and status.
Product.java: Represents a product with attributes and methods for
management and association with orders.
ProductService.java: Defines the ProductService interface for remote
methods related to product functionalities.
ProductServiceImpl.java: Implements the ProductService interface,
providing the server-side logic for product functionalities.
Server.java: Contains the main method to start the server and bind
services to the registry.
ShoppingCart.java: Represents a shopping cart for a customer, allowing
them to add, remove, and checkout products.
