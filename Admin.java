	//  .addActionListener(handler);
        //	.addEventListener(handler);

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
/**
 *
 * @author Noufr
 */
public class Admin extends JFrame  implements ActionListener {

    private JPanel contentPane = new JPanel();
    private JButton BooksButton = new JButton();
    private JButton AddButton= new JButton();
    private JButton DeleteButton = new JButton();
    private JButton UpdateButton = new JButton();
    private JButton SignoutlButton = new JButton();
    private JButton viewmembers = new JButton();  
    
   
    Admin (){
        setBounds(600, 250, 606, 606);
	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin"); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);
        
   
        
        BooksButton.setText("All Books");
       	BooksButton.addActionListener(this);
	BooksButton.setFont(new Font("Tahoma", Font.BOLD, 13));
	BooksButton.setBounds(175, 80, 200, 30);
	BooksButton.setForeground(new Color(46, 139, 87));
	BooksButton.setBackground(Color.lightGray);
        contentPane.add(BooksButton);
        
        
        AddButton.setText("Add Book");
       	AddButton.addActionListener(this);
	AddButton.setFont(new Font("Tahoma", Font.BOLD, 13));
	AddButton.setBounds(175, 130, 200, 30);
	AddButton.setForeground(new Color(46, 139, 87));
	AddButton.setBackground(Color.lightGray);
        contentPane.add(AddButton);
        
	UpdateButton.setText("Update Book");
        UpdateButton.addActionListener(this);
       	UpdateButton.setFont(new Font("Tahoma", Font.BOLD, 13));
	UpdateButton.setBounds(175, 180, 200, 30);
	UpdateButton.setForeground(new Color(46, 139, 87));
	UpdateButton.setBackground(Color.lightGray);
        contentPane.add(UpdateButton);
        
        DeleteButton.setText("Delete Book");
        DeleteButton.addActionListener(this);
	DeleteButton.setFont(new Font("Tahoma", Font.BOLD, 13));
	DeleteButton.setBounds(175, 230, 200, 30);
	DeleteButton.setForeground(new Color(46, 139, 87));
	DeleteButton.setBackground(Color.lightGray);
        contentPane.add(DeleteButton);

        viewmembers.setText("Save members to files");
        viewmembers.addActionListener(this);
	viewmembers.setFont(new Font("Tahoma", Font.BOLD, 13));
	viewmembers.setBounds(175, 280, 200, 30);
	viewmembers.setForeground(new Color(46, 139, 87));
	viewmembers.setBackground(Color.lightGray);
        contentPane.add(viewmembers);
        
        SignoutlButton.setText("Sign Out");
        SignoutlButton.addActionListener(this);
	SignoutlButton.setFont(new Font("Tahoma", Font.BOLD, 13));
	SignoutlButton.setBounds(175, 330, 200, 30);
	SignoutlButton.setForeground(new Color(46, 139, 87));
	SignoutlButton.setBackground(Color.lightGray);      
        contentPane.add(SignoutlButton);
        
        JPanel panel = new JPanel();
	panel.setForeground(new Color(34, 139, 34));
	panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Admin Home",
	TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	panel.setBounds(35, 60, 455, 330);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
    }
         
         @Override
        public void actionPerformed(ActionEvent ae) {
           
            
                     
        if(ae.getSource() == BooksButton){   
            
           
            this.setVisible(false);
            AllBooks product = new AllBooks(); 
            product.setVisible(true);
           
         }
            else if(ae.getSource() == AddButton){   
              this.setVisible(false);
            AddBook product = new AddBook(); 
            product.setVisible(true);
        }
        
         else if (ae.getSource() == UpdateButton) {
             
           this.setVisible(false);
              UpdateBook product = new UpdateBook(); 
            product.setVisible(true);
         }           
         
         else if (ae.getSource() == DeleteButton) { 
              this.setVisible(false); 
            DeleteBook myDeleteBook = new DeleteBook ();
            myDeleteBook.setVisible(true);
          
         }

         else if (ae.getSource() == viewmembers) { 
            //this.setVisible(false); 
            CreateTextFile f = new CreateTextFile();
            f.writeToFile();
            JOptionPane.showMessageDialog (null, "Added succesfully."); 
         }
        
         else if  (ae.getSource() == SignoutlButton)
            {
              this.setVisible(false);
               HomePage home = new HomePage();
                home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                home.setVisible(true);
                home.setLocationRelativeTo(null);
            }
             
        }
    
}