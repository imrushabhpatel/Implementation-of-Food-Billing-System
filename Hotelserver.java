
package hotelserver;

import hotelimp.hotelimp;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JFrame;


public class Hotelserver {


    public static void main(String[] args) {
      try {
          Registry reg=LocateRegistry.createRegistry(1099);
        hotelimp im= new hotelimp();
      reg.rebind("hotel", im);
      System.out.println("Server Started: ");
      
      
    }
    catch(Exception e) 
    {
      System.out.println("Exception: " + e);
    }
    }
}
