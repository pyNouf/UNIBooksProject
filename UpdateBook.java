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
public class UpdateBook extends JFrame   implements ActionListener {
     
    Connection myConnection;
    Statement myStatement;
    ResultSet myResultSet; 
    private String[] myArray ={"Book Title", "Book ID", "Book Author" ," Book Publisher", "Book Publish year" ,"Bookstate ", "Book Price", "Admin Email"};
    private JComboBox attribute = new JComboBox(myArray);
    private JTextField bookID = new JTextField();
    private JLabel lbID = new JLabel("Enter Book ID:");
    private JLabel label1 = new JLabel("Choose Attribute:");
    private JLabel label2 = new JLabel("Enter new Value:");
    private JTextField updatedItem = new JTextField (); 
    private JTable booksTable = new JTable ();
    private JPanel contentPane = new JPanel();
    private JScrollPane myScrollPane = new JScrollPane(booksTable); 
    private JButton UpdateButton = new JButton();
     private JButton BackButton = new JButton();
    
   UpdateBook (){
       
       
        setBounds(600, 250, 606, 606);
        setTitle("Update Book"); 
	setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed (WindowEvent event){
              closeDB();   
              System.exit(0);
            }
        });
        
        
        setTitle("Update Book"); 
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
	lbID.setBounds(40, 150, 200, 30);
	lbID.setForeground(new Color(46, 139, 87));
	lbID.setBackground(Color.lightGray);       
        contentPane.add(lbID);
        
        bookID.setFont(new Font("Tahoma", Font.BOLD, 13));
	bookID.setBounds(170, 150, 200, 30);
	bookID.setForeground(new Color(46, 139, 87));
	bookID.setBackground(Color.lightGray);
        contentPane.add(bookID);
        
        label1.setFont(new Font("Tahoma", Font.BOLD, 13));
	label1.setBounds(40, 190, 200, 30);
	label1.setForeground(new Color(46, 139, 87));
	label1.setBackground(Color.lightGray);       
        contentPane.add(label1);
        
         
        attribute.setFont(new Font("Tahoma", Font.BOLD, 13));
	attribute.setBounds(170, 190, 200, 30);
	attribute.setForeground(new Color(46, 139, 87));
	attribute.setBackground(Color.lightGray);
 	contentPane.add(attribute);
        
        
        label2.setFont(new Font("Tahoma", Font.BOLD, 13));
	label2.setBounds(40, 230, 200, 30);
	label2.setForeground(new Color(46, 139, 87));
	label2.setBackground(Color.lightGray);
        contentPane.add(label2);
        
        
        updatedItem.setFont(new Font("Tahoma", Font.BOLD, 13));
	updatedItem.setBounds(170, 230, 200, 30);
	updatedItem.setForeground(new Color(46, 139, 87));
	updatedItem.setBackground(Color.lightGray);
        contentPane.add(updatedItem);
        
        
        UpdateButton.setText("Update Book");
	UpdateButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        UpdateButton.addActionListener(this);
	UpdateButton.setBounds(199, 270, 150, 30);
	UpdateButton.setForeground(new Color(46, 139, 87));
	UpdateButton.setBackground(Color.lightGray);
        contentPane.add(UpdateButton);
        
        
                  
        BackButton.setText("Back");
	BackButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        BackButton.addActionListener(this);
	BackButton.setBounds(40, 500, 100, 30);
	BackButton.setForeground(new Color(46, 139, 87));
	BackButton.setBackground(Color.lightGray);
        contentPane.add(BackButton);
        
        
        JPanel panel = new JPanel();
	panel.setForeground(new Color(34, 139, 34));
	panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Update Book",
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
          
       if(ae.getSource() == UpdateButton){   
            
      try {
          
      int answer=JOptionPane.showConfirmDialog (null, "Are you sure you want to updated selected Column Value ?", "Update Column Value",JOptionPane.YES_NO_OPTION); 
      if (answer==JOptionPane.YES_OPTION)
      {    
          int rows=0;
           String sql; 
          if (attribute.getSelectedIndex()==0) {
             sql=" update books set Btitle= '"+ updatedItem.getText() +"' Where book_id=" + bookID.getText()  +";";
             rows=myStatement.executeUpdate(sql); }
          
          
          else if (attribute.getSelectedIndex()==1) {
             sql="update books set book_id= '"+updatedItem.getText() +"' Where book_id=" + bookID.getText()  +";";
             rows=myStatement.executeUpdate(sql); }
                    
          else  if (attribute.getSelectedIndex()==2) {
             sql="update books set bauthor= '"+updatedItem.getText() + "' Where book_id=" + bookID.getText()  +";";
             rows=myStatement.executeUpdate(sql); }
                              
                              
          else if (attribute.getSelectedIndex()==3) {
             sql="update books set bpublisher= '" + updatedItem.getText() +"' Where book_id=" + bookID.getText() +";" ;
             rows=myStatement.executeUpdate(sql); }
                                        
          else if (attribute.getSelectedIndex()==4) {
             sql="update books set bpublish_year="+Integer.parseInt(updatedItem.getText ()) + " Where book_id=" + bookID.getText()  +";";
             rows=myStatement.executeUpdate(sql) ; }
          
          else if (attribute.getSelectedIndex()==5) {
             sql="update books set bstate= '"+updatedItem.getText() +"' Where book_id=" + bookID.getText()  +";";
             rows=myStatement.executeUpdate(sql); }
          
          
          else if (attribute.getSelectedIndex()==6) {
             sql="update books set bprice_SR="+Double.parseDouble(updatedItem.getText()) + " Where book_id=" + bookID.getText()  +";";
             rows=myStatement.executeUpdate(sql); }
          
          else if (attribute.getSelectedIndex()==7) {
             sql="update books set admin_email= '"+updatedItem.getText() + "' Where book_id=" + bookID.getText() +";";
             rows=myStatement.executeUpdate(sql); }
          

                        
            if (rows == 1) 
            JOptionPane.showMessageDialog (null, "Updated.."); 

            else 
              JOptionPane.showMessageDialog (null," Can't Update selected Column Value!","Error",JOptionPane. ERROR_MESSAGE);}   
      
            updatedItem.setText ("");
            closeDB (); 
            fillTable(); }
      
         
    
         
      
      
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





