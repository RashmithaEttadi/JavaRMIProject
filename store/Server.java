package store;
import java.rmi.Naming;

public class Server {
    public static void main(String[] args) {
        try {
           
            FrontController frontController = new FrontControllerImpl();
            Naming.rebind("//in-csci-rrpc05.cs.iupui.edu/FrontController", frontController);

            System.out.println("FrontController server started.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
