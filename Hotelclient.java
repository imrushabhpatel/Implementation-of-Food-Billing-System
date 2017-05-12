
package hotelclient;

import hotelint.Hotelint;
import java.awt.event.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;


public class Hotelclient extends JFrame {
    JPanel mypanel;
    JButton b1,b2,b3;
    JComboBox cb;
    JTextField t1;
    Hotelint in;
    int c,p=0;
    JTextArea ta;
    static int total=0;
 List<String> st=new ArrayList<String>();
    public Hotelclient()throws Exception
    {
     Registry myreg=LocateRegistry.getRegistry("127.0.0.1",1099);
     in =(Hotelint) myreg.lookup("hotel");
     c=in.count();
     st=in.menu();
     cb=new JComboBox();
     ta = new JTextArea(5, 20);
     ta.setText("item\t\t\tQuantity\t\t\tPrice");
      ta.setEditable(false);
   
            for(int i=0;i<=c;i++)
            {
                cb.addItem(st.get(i));
            }
        
   
     
        mypanel=new JPanel();
        b1=new JButton("add");
        b2=new JButton("final");
        b3=new JButton("clear");
        t1=new JTextField(6);
        
        mypanel.add(cb);
        mypanel.add(t1);
        mypanel.add(b1);
        mypanel.add(b2);
        mypanel.add(b3);
        
        mypanel.add(ta);
        
        
        this.add(mypanel);
        
        b1.addActionListener(new ActionListener()
{
  
 
  public void actionPerformed(ActionEvent e)
  {
    String item;
      item = (String) cb.getSelectedItem();
      int q=Integer.parseInt(t1.getText());
      int p=0;
      try {
          p = in.get(item);
      } catch (Exception ex) {
          Logger.getLogger(Hotelclient.class.getName()).log(Level.SEVERE, null, ex);
      }
      p=p*q;
      total=total+p;
    
      ta.append("\n"+item+"\t\t\t"+q+"\t\t\t"+p);
    
  }
});
        
          b2.addActionListener(new ActionListener()
{
  
 
  public void actionPerformed(ActionEvent e)
  {
    
      ta.append("\n----------------------------------------------------------------------------------------------------------------------------------------------");
      ta.append("\nTOTAL:\t\t\t\t\t\t"+total);
    
  }
});
          
           b3.addActionListener(new ActionListener()
{
  
 
  public void actionPerformed(ActionEvent e)
  {
    
    total=0;
    ta.setText(null);  
    ta.setText("item\t\t\tQuantity\t\t\tPrice");
  }
});
        
        
    }

    public static void main(String[] args) throws Exception 
    {
     
    
      Hotelclient h=new Hotelclient();
      h.setTitle("HOTEL BILLING");
      h.setSize(300,300);
      h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      h.setVisible(true);
     
    }
    
    
    
}
