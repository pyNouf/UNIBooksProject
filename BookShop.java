/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniproj;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils; 
/**
 *
 * @author Noufr
 */
public class BookShop extends JFrame   implements ActionListener {
    
    
    
    Connection myConnection;
    Statement myStatement;
    ResultSet myResultSet; 
    private JLabel lbID = new JLabel("Enter Book ID:");
    private JTextField bookID = new JTextField();
    private JTable booksTable = new JTable ();
    private JPanel contentPane = new JPanel();
    private JScrollPane myScrollPane = new JScrollPane(booksTable); 
    private JButton AddButton = new JButton();
    private JButton BackButton = new JButton();
    int  id;
    
    
    
   BookShop (){
       
       Orders ord = new Orders ();
        ord.setNewOrder();
        id = ord.id; 
        
        
        setBounds(600, 250, 606, 606);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed (WindowEvent event){
              closeDB();   
              System.exit(0);
            }
        });
        
        
        setTitle("BookShop"); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);;
       
        fillTable();
        
        myScrollPane.setBounds(0, 0, 606, 100);
        myScrollPane.setForeground(new Color(46, 139, 87));
        myScrollPane.setBackground(Color.lightGray);
        contentPane.add(myScrollPane);
          
        lbID.setFont(new Font("Tahoma", Font.BOLD, 13));
        lbID.setBounds(80, 200, 200, 30);
        lbID.setForeground(new Color(46, 139, 87));
        lbID.setBackground(Color.lightGray);       
        contentPane.add(lbID);
        
        bookID.setFont(new Font("Tahoma", Font.BOLD, 13));
        bookID.setBounds(200, 200, 200, 30);
        bookID.setForeground(new Color(46, 139, 87));
        bookID.setBackground(Color.lightGray);
        contentPane.add(bookID);
        
        AddButton.setText("Add to cart");
        AddButton.addActionListener(this);
        AddButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        AddButton.setBounds(230, 410, 200, 30);
        AddButton.setForeground(new Color(46, 139, 87));
        AddButton.setBackground(Color.lightGray);
        contentPane.add(AddButton);
        
        
              
        BackButton.setText("Back");
        BackButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        BackButton.addActionListener(this);
        BackButton.setBounds(40, 500, 100, 30);
        BackButton.setForeground(new Color(46, 139, 87));
        BackButton.setBackground(Color.lightGray);
        contentPane.add(BackButton);
        
        
        
      
        
        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "BookShop",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(31, 130, 476, 175);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
        
       
   } 
    
   
   void fillTable (){
       
         try{
       
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/unibooks?zeroDateTimeBehavior=convertToNull","root","Level6!@#");
            myStatement = myConnection.createStatement();
            myResultSet= myStatement.executeQuery("SELECT Btitle,book_id ,bstate ,bprice_SR FROM books");
            booksTable.setModel(DbUtils.resultSetToTableModel(myResultSet));
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
                }    
       
   }
   
   
      void closeDB (){
       
         try{
       
            myConnection.close();
            myStatement.close();
            myResultSet.close();
                       
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
                }    
       
   }
      

        @Override
        public void actionPerformed(ActionEvent ae) {
          
          
       if(ae.getSource() == AddButton){   
            
                Connection myConnection;
                Statement myStatement;
                ResultSet myResultSet; 
                PreparedStatement insertSt=null;
                
    try {
        
        
        myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/unibooks?zeroDateTimeBehavior=convertToNull","root","Level6!@#");
        myStatement = myConnection.createStatement();        
        insertSt=myConnection.prepareStatement("INSERT INTO book_order (orderid , bookid) VALUES (?,?)"); 
      
        insertSt.setString(1,String.valueOf(id));
        insertSt.setString(2,(bookID.getText()));
     
         int rows=insertSt.executeUpdate();
            if (rows == 1) 
                JOptionPane.showMessageDialog (null, "Added to cart"); 
            
            else 
                JOptionPane.showMessageDialog (null, " Can't Added to cart "); 
            
            
          myStatement.close();
          myConnection.close();
           }  
    
        catch (SQLException ex){
             JOptionPane.showMessageDialog (null, ex.getMessage(),"Error",JOptionPane. ERROR_MESSAGE);}   
        catch (Exception ex) {
               JOptionPane.showMessageDialog (null,"Exception: "+ ex.getMessage(),"Ėrror",JOptionPane. ERROR_MESSAGE) ;}
            }
       
       
           else if(ae.getSource() == BackButton){   
           this.setVisible(false);
           Cust_Home Customer = new Cust_Home(); 
           Customer.setVisible(true);
           Customer.setLocationRelativeTo(null);
           
         }
            }
        
      
               
  




}