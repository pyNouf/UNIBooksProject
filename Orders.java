package uniproj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Noufr
 */
public class Orders {
    
    
    
    Connection myConnection;
    Statement myStatement;
    ResultSet myResultSet; 
    String cust_email , order_date , order_quantity, order_total_price , OrderID;
    static int numOfOrders;     
    static int  id = 1+numOfOrders;
    String userId = Login_User.userid;  
    
    ArrayList<Orders> orderlist = new ArrayList<>();
    
    public String getCust_email() {
        return cust_email;
    }

    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(String order_quantity) {
        this.order_quantity = order_quantity;
    }

    public String getOrder_total_price() {
        return order_total_price;
    }

    public void setOrder_total_price(String order_total_price) {
        this.order_total_price = order_total_price;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    
    public ArrayList<Orders> getOrders() {
   
    String query = "SELECT * FROM Orders";
    
    Orders order;
    try {
        
         myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/unibooks?zeroDateTimeBehavior=convertToNull","root","Level6!@#");
         myStatement = myConnection.createStatement();
        String sql = "select * from orders";
        PreparedStatement st = myConnection.prepareStatement(sql);
        myResultSet = myStatement.executeQuery(query);
        while (myResultSet.next()) {
            order = new Orders();
          
            order.setCust_email(myResultSet.getString("Cust_email"));
            order.setOrder_quantity(myResultSet.getString("Order_quantity"));
            order.setOrder_date(myResultSet.getString("Order_date"));
            order.setOrder_total_price(myResultSet.getString("Order_total_price"));
            order.setOrder_date(myResultSet.getString("order_id"));
            //add each book to the list
      
        orderlist.add(order);
        }   myResultSet.close();
            myStatement.close();
            myConnection.close();
            
//            numOfOrders = orderlist.size();
            
    }catch(SQLException sqlEX){
        sqlEX.printStackTrace();
    } 
    
    return orderlist;
}
 void setNewOrder (){
        try {
           myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/unibooks?zeroDateTimeBehavior=convertToNull","root","Level6!@#");
           myStatement = myConnection.createStatement();
           
      PreparedStatement insertSt=myConnection.prepareStatement("INSERT INTO ORDERS (cust_email ) values(? )"); 
      //insertSt.setString(1,String.valueOf(id));
      insertSt.setString(1,userId);
     
     
      insertSt.executeUpdate();
      getOrders() ;
      numOfOrders = orderlist.size();
           }
  catch (SQLException ex){
             JOptionPane.showMessageDialog (null, ex.getMessage(),"Error",JOptionPane. ERROR_MESSAGE);}   
catch (Exception ex) {
               JOptionPane.showMessageDialog (null,"Exception: "+ex.getMessage (),"Ėrror",JOptionPane. ERROR_MESSAGE) ;}
 }
 
}