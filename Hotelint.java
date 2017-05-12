
package hotelint;

import java.rmi.Remote;
import java.sql.SQLException;
import java.util.*;

public interface Hotelint extends Remote {
    
    public int count()throws Exception; 
    public List<String> menu()throws Exception;
    public int get(String s)throws Exception,SQLException;

}
