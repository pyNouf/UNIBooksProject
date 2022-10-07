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
public class DeleteBook extends JFrame  implements ActionListener{
    
    
    
    Connection myConnection;
    Statement myStatement;
    ResultSet myResultSet; 
    private JLabel lbID = new JLabel("Enter Book ID:");
    private JTextField bookID = new JTextField();
    private JTable booksTable = new JTable ();
    private JPanel contentPane = new JPanel();
    private JScrollPane myScrollPane = new JScrollPane(booksTable); 
    private JButton DeleteButton = new JButton();
     private JButton BackButton = new JButton();
    
   DeleteBook (){
       
       
        setBounds(600, 250, 606, 606);
        setTitle("Delete Book"); 
	setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed (WindowEvent event){
              closeDB();   
              System.exit(0);
            }
        });
        
        
        setTitle("Delete Book"); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);
       
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
        
        DeleteButton.setText("Delete Book");
	DeleteButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        DeleteButton.addActionListener(this);
	DeleteButton.setBounds(199, 250, 150, 30);
	DeleteButton.setForeground(new Color(46, 139, 87));
	DeleteButton.setBackground(Color.lightGray);
        contentPane.add(DeleteButton);
        
        
        
                  
        BackButton.setText("Back");
	BackButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        BackButton.addActionListener(this);
	BackButton.setBounds(40, 500, 100, 30);
	BackButton.setForeground(new Color(46, 139, 87));
	BackButton.setBackground(Color.lightGray);
        contentPane.add(BackButton);
        
        JPanel panel = new JPanel();
	panel.setForeground(new Color(34, 139, 34));
	panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Delete Book",
	TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	panel.setBounds(31, 130, 476, 175);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
        
       
   } 
    
   
   void fillTable (){
       
         try{
       
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/unibooks?zeroDateTimeBehavior=convertToNull","root","Level6!@#");
            myStatement = myConnection.createStatement();
            myResultSet= myStatement.executeQuery("SELECT * FROM books");
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
          
          
          if(ae.getSource() == DeleteButton)
          
          {
      try {
      int answer=JOptionPane.showConfirmDialog (null, "Are you sure you want to delete the selected record ?", "Delete Record",JOptionPane.YES_NO_OPTION); 
      if (answer==JOptionPane. YES_OPTION)
      {    
            String sql="delete from books where book_id="+bookID.getText();
            int rows=myStatement.executeUpdate(sql); 
            if (rows == 1) 
            JOptionPane.showMessageDialog (null, "Deleted.."); 
            bookID.setText ("");
            closeDB (); 
            fillTable(); 
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
            admin.setLocationRelativeTo(null);
         }
     
    }
}
