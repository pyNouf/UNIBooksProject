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
public class AddBook extends JFrame implements ActionListener {
    
    
     Connection myConnection;
     Statement myStatement;
     ResultSet myResultSet; 
     private JLabel lbID = new JLabel("Enter Book ID:");
     private JLabel lbTitle = new JLabel("Enter Book Title:");
     private JLabel lbAuthor = new JLabel("Enter Book Author:");
     private JLabel lbPublisher = new JLabel("Enter Book Publisher:");
     private JLabel lbPublish_year = new JLabel("Enter Publish year");
     private JLabel lbSatet = new JLabel("Enter Book State:");
     private JLabel lbPrice = new JLabel("Enter Book Price:");
//     private JLabel lbAdminEmail = new JLabel("Enter Admin Email:");
//     private JLabel imgBookSource = new JLabel ("Uploud Book Img"); 
     private JTextField bID = new JTextField();
     private JTextField bTitle = new JTextField();
     private JTextField bAuthor = new JTextField();
     private JTextField bPublisher = new JTextField();
     private JTextField bPublish_year = new JTextField();
     private JTextField bSatet = new JTextField();
     private JTextField bPrice = new JTextField();
//     private JTextField bAdminEmail = new JTextField();
     private JTable booksTable = new JTable ();
     private JPanel contentPane = new JPanel();
     private JScrollPane myScrollPane = new JScrollPane(booksTable); 
     private JButton AddButton = new JButton();
      private JButton BackButton = new JButton();
     
     
     AddBook (){
         
        setBounds(600, 250, 606, 606);
	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

         
        setTitle("Add Book"); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);
       

        
        lbID.setFont(new Font("Tahoma", Font.BOLD, 13));
	lbID.setBounds(80, 70, 200, 30);
	lbID.setForeground(new Color(46, 139, 87));
	lbID.setBackground(Color.lightGray);       
        contentPane.add(lbID);
        
        bID.setFont(new Font("Tahoma", Font.BOLD, 13));
	bID.setBounds(230, 70, 200, 30);
	bID.setForeground(new Color(46, 139, 87));
	bID.setBackground(Color.lightGray);
        contentPane.add(bID);
        
        
        lbTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
	lbTitle.setBounds(80, 110, 200, 30);
	lbTitle.setForeground(new Color(46, 139, 87));
	lbTitle.setBackground(Color.lightGray);       
        contentPane.add(lbTitle);
        
        bTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
	bTitle.setBounds(230, 110, 200, 30);
	bTitle.setForeground(new Color(46, 139, 87));
	bTitle.setBackground(Color.lightGray);
        contentPane.add(bTitle);
        
        lbAuthor.setFont(new Font("Tahoma", Font.BOLD, 13));
	lbAuthor.setBounds(80, 150, 200, 30);
	lbAuthor.setForeground(new Color(46, 139, 87));
	lbAuthor.setBackground(Color.lightGray);       
        contentPane.add(lbAuthor);
        
        bAuthor.setFont(new Font("Tahoma", Font.BOLD, 13));
	bAuthor.setBounds(230, 150, 200, 30);
	bAuthor.setForeground(new Color(46, 139, 87));
	bAuthor.setBackground(Color.lightGray);
        contentPane.add(bAuthor);
        
        
        lbPublisher.setFont(new Font("Tahoma", Font.BOLD, 13));
	lbPublisher.setBounds(80, 190, 200, 30);
	lbPublisher.setForeground(new Color(46, 139, 87));
	lbPublisher.setBackground(Color.lightGray);       
        contentPane.add(lbPublisher);
        
        bPublisher.setFont(new Font("Tahoma", Font.BOLD, 13));
	bPublisher.setBounds(230, 190, 200, 30);
	bPublisher.setForeground(new Color(46, 139, 87));
	bPublisher.setBackground(Color.lightGray);
        contentPane.add(bPublisher);
        
                
        lbPublish_year.setFont(new Font("Tahoma", Font.BOLD, 13));
	lbPublish_year.setBounds(80, 280, 200, 30);
	lbPublish_year.setForeground(new Color(46, 139, 87));
	lbPublish_year.setBackground(Color.lightGray);       
        contentPane.add(lbPublish_year);
        
        bPublish_year.setFont(new Font("Tahoma", Font.BOLD, 13));
	bPublish_year.setBounds(230, 280, 200, 30);
	bPublish_year.setForeground(new Color(46, 139, 87));
	bPublish_year.setBackground(Color.lightGray);
        contentPane.add(bPublish_year);
        
        
        lbSatet.setFont(new Font("Tahoma", Font.BOLD, 13));
	lbSatet.setBounds(80, 240, 200, 30);
	lbSatet.setForeground(new Color(46, 139, 87));
	lbSatet.setBackground(Color.lightGray);       
        contentPane.add(lbSatet);
        
        bSatet.setFont(new Font("Tahoma", Font.BOLD, 13));
	bSatet.setBounds(230, 240, 200, 30);
	bSatet.setForeground(new Color(46, 139, 87));
	bSatet.setBackground(Color.lightGray);
        contentPane.add(bSatet);
        
              
        lbPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
	lbPrice.setBounds(80, 320, 200, 30);
	lbPrice.setForeground(new Color(46, 139, 87));
	lbPrice.setBackground(Color.lightGray);       
        contentPane.add(lbPrice);
        
        bPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
	bPrice.setBounds(230, 320, 200, 30);
	bPrice.setForeground(new Color(46, 139, 87));
	bPrice.setBackground(Color.lightGray);
        contentPane.add(bPrice);
                
        
                
        AddButton.setText("Add Book");
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
	panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Add to cart",
	TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	panel.setBounds(31, 46, 476, 400);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
        
     }
     
     
     
     

        
        
           void closeDB (){
       
         try{
       
            myConnection.close();
            myStatement.close();
                       
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
                }    
       
   }
           
  
                @Override
              public void actionPerformed(ActionEvent ae) {
                  
                  

       if(ae.getSource() == AddButton){   
            
         
               String adminid = Login_User.userid;  
           try {
           myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/unibooks?zeroDateTimeBehavior=convertToNull","root","Level6!@#");
           myStatement = myConnection.createStatement();
           int answer=JOptionPane.showConfirmDialog (null, "Are you sure you want to add the book ?", "Add Record",JOptionPane.YES_NO_OPTION); 
           if (answer==JOptionPane. YES_OPTION)
      {   
      PreparedStatement insertSt=myConnection.prepareStatement("INSERT INTO BOOKS (Btitle, book_id, bauthor ,bpublisher, bpublish_year, bstate, bprice_SR ,admin_email ) VALUES (?,?,?,? , ?,?,?,?)"); 
      insertSt.setString(1,bTitle.getText());
      insertSt.setString(2,bID.getText());
      insertSt.setString(3,bAuthor.getText());
      insertSt.setString(4,bPublisher.getText());
      insertSt.setInt(5,Integer.parseInt(bPublish_year.getText ())); 
      insertSt.setString(6, bSatet.getText()); 
      insertSt.setDouble(7,Double.parseDouble(bPrice.getText())); 
      insertSt.setString(8,adminid);
      int rows=insertSt.executeUpdate();
      
      if (rows == 1) 
      JOptionPane.showMessageDialog (null, "Added.."); 
      
      bID.setText ("");
      bTitle.setText (""); 
      bAuthor.setText ("");
      bPublisher.setText ("");
      bPublish_year.setText ("");
      bSatet.setText ("");
      bPrice.setText ("");
     // bAdminEmail.setText ("");
      closeDB (); 
             
      }

                }

catch (SQLException ex){
             JOptionPane.showMessageDialog (null, ex.getMessage(),"Error",JOptionPane. ERROR_MESSAGE);}   
catch (Exception ex) {
               JOptionPane.showMessageDialog (null,"Exception: "+ex.getMessage (),"Ėrror",JOptionPane. ERROR_MESSAGE) ;}
           
       }
       
       
       else if(ae.getSource() == BackButton){   
            
           
            this.setVisible(false);
            Admin admin = new Admin(); 
            admin.setVisible(true);
           
         }
        }
     
}
