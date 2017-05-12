
package hotelimp;
import hotelint.*;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.*;


public class hotelimp extends UnicastRemoteObject implements Hotelint 
{
Connection c;
Statement s;
ResultSet r;
ResultSetMetaData rsmd;
int p;
List<String> st = new ArrayList<String>();


 int columns,j=0;

    public hotelimp()throws Exception{
    
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    c= DriverManager.getConnection("jdbc:odbc:hotel");
    s=c.createStatement();
    r=s.executeQuery("select name from hotel");
    rsmd = r.getMetaData();
    columns = rsmd.getColumnCount();
    
     while(r.next())
        {
            for(int i=1;i<=columns;i++)
            {
            
            st.add(r.getString(i));
         
            }
        }
    }

    public int count() throws Exception 
    {
       
        
     
        return columns;
        
            
    }

 
    public List<String> menu() throws Exception 
    {
        
         return st;
      
    }
    
    
    public int get(String str)throws SQLException,Exception
    {
        r=s.executeQuery("select price from hotel where name LIKE '"+str+"'");
       rsmd = r.getMetaData();
        columns = rsmd.getColumnCount();
      
       System.out.println(columns);
       while(r.next())
        {
            for(int i=1;i<=columns;i++)
            {
            
            p=Integer.parseInt(r.getString(i));
           
       
            }
        }
       return p;
        
    }
   
    
   
}
