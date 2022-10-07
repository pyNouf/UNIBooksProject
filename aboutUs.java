package uniproj;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.*;
import java.sql.*;

public class aboutUs extends JFrame implements ActionListener{
  
  
    /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
    final private JPanel panel;
    final private JButton homeButton,exitButton;
    
  public aboutUs(){
     panel = new JPanel();

          setBounds(600, 250, 600, 500);
          setTitle("About Us"); 
          panel.setBorder(new EmptyBorder(5, 5, 5, 5));
          setContentPane(panel);
          panel.setBackground(Color.WHITE);
          panel.setLayout(null);
       
          
          JLabel unibookTitle = new JLabel("UNIBOOKS Library");
            unibookTitle.setForeground( new Color(34, 139, 34));
            unibookTitle.setFont(new Font("Monospaced", Font.BOLD, 40));
            unibookTitle.setBounds(110, 0, 650, 100);
            panel.add(unibookTitle);
            
            
            homeButton = new JButton("Back to home page");
            homeButton.addActionListener(this);
            homeButton.setFont(new Font("Tahoma", Font.BOLD, 13));
            homeButton.setBounds(340, 340, 171, 29);//200, 340
            homeButton.setBackground(Color.BLACK);
            homeButton.setForeground(Color.WHITE);
            panel.add(homeButton);
  
            
            exitButton = new JButton("Exit");
            exitButton.addActionListener(this);
            exitButton.setFont(new Font("Tahoma", Font.BOLD, 13));
            exitButton.setBounds(380, 390, 101, 29);//400, 170, 171, 29
            exitButton.setBackground(Color.BLACK);
            exitButton.setForeground(Color.WHITE);
            panel.add(exitButton);
  
            
            JLabel contactUs = new JLabel("contact us: ");
            contactUs.setForeground( new Color(34, 139, 34));
            contactUs.setFont(new Font("Monospaced", Font.BOLD, 22));
            contactUs.setBounds(40, 8, 250, 200);
            panel.add(contactUs);
            
            JLabel email = new JLabel("Email : unibooks@mail.org"
                );
            email.setFont(new Font("Monospaced",Font.PLAIN, 14));
            email.setBounds(45, 58, 300, 150);
            panel.add(email);
            
            JLabel Phone = new JLabel("Phone # : 903333444423");
            Phone.setFont(new Font("Monospaced",Font.PLAIN, 14));
            Phone.setBounds(45, 72, 300, 150);
            panel.add(Phone);

            JLabel website = new JLabel("website : unibooks.html");
            website.setFont(new Font("Monospaced",Font.PLAIN, 14));
            website.setBounds(45, 86, 300, 150);
            panel.add(website);

            
            JLabel aboutUs = new JLabel("About us: ");
            aboutUs.setForeground( new Color(34, 139, 34));
            aboutUs.setFont(new Font("Monospaced", Font.BOLD, 22));
            aboutUs.setBounds(40, 100, 250, 200);
            panel.add(aboutUs);
            

             String strig="UNIBOOKS Library is a project which aims"
                + "\nin developing a computrized system to maintain"
                + "\nall the daily works of a library. "
                + "\nThe website helps both students and library manager to keep"
                + "\na constant track of all the books availabile in library."
                + "\nIt allows both the admin and the student to search"
                + "\nfor the desired book.";
            JTextArea l2 = new  JTextArea(strig);
            l2.setBounds(45, 220, 400, 300);
            l2.setFont(new Font("Monospaced",Font.PLAIN, 11));
            l2.setEditable(false);
            panel.add(l2);
            
          
            
       
  }
   
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
           if(ae.getSource() == homeButton){
                 dispose();
                
                HomePage home = new HomePage();
                 home.setVisible(true);
                 home.setLocationRelativeTo(null);

                }
           if(ae.getSource()==exitButton) {
                 System.exit(ABORT);
           }
           
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    
    public static void main(String[] args) {
        aboutUs about = new aboutUs();
        about.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        about.setVisible(true);
        about.setLocationRelativeTo(null);
}

}
            
