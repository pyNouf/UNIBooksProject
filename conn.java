
package uniproj;

/**
 *
 * @author sebaa
 */

import java.sql.*;

public class conn {
    Connection c;
    Statement s;
    public conn(){
        try{
      Class.forName("com.mysql.cj.jdbc.Driver");
             System.out.println("proceed --1 ");
             c = DriverManager.getConnection("jdbc:mysql://localhost:3306/unibooks","root","Level6!@#");
             System.out.println("proceed --2 ");
             s = c.createStatement();
             System.out.println("proceed --3");
             
        }catch(Exception e){
            e.printStackTrace();
        }
       
        
    }
}//end of class
