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
 * @author Noufr
 */
public class AllBooks extends JFrame  implements ActionListener{
    
    Connection myConnection;
    Statement myStatement;
    ResultSet myResultSet; 
    private JTable booksTable = new JTable ();
    private JPanel contentPane = new JPanel();
    private JScrollPane myScrollPane = new JScrollPane(booksTable); 
    private JButton BackButton = new JButton();
    
    AllBooks (){
         setBounds(600, 250, 700, 606);
	setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed (WindowEvent event){
              closeDB();   
              System.exit(0);
            }
        });
        
                
        setTitle("All Books"); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);
       
        fillTable();
      
        myScrollPane.setBounds(40, 150, 606, 100);
	myScrollPane.setForeground(new Color(46, 139, 87));
	myScrollPane.setBackground(Color.lightGray);
        contentPane.add(myScrollPane);
        
                
        
        BackButton.setText("Back");
	BackButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        BackButton.addActionListener(this);
	BackButton.setBounds(40, 500, 100, 30);
	BackButton.setForeground(new Color(46, 139, 87));
	BackButton.setBackground(Color.lightGray);
      
        
        
    
        
        
        contentPane.add(BackButton);     
        
        
        
        JPanel panel = new JPanel();
	panel.setForeground(new Color(34, 139, 34));
	panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "All Books",
	TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	panel.setBounds(31, 130, 620, 175);
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
    
        this.setVisible(false);
        Admin myAdmin = new Admin (); 
        myAdmin.setVisible(true);
        myAdmin.setLocationRelativeTo(null);                        
      }
   
    
}
