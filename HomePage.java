/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniproj;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.ABORT;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.util.*;
import java.io.*;
import static uniproj.Orders.numOfOrders;

public class HomePage extends JFrame implements ActionListener{

  final private JPanel contentPane;
        final private JButton startButton;

  
        
        public HomePage() {
          
           
  
            setBounds(600, 250, 590, 450);
            setTitle("Welcome to UNIBOOKS"); 
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setBackground(Color.WHITE);
            contentPane.setLayout(null);
            
            
            JLabel unibookTitle = new JLabel("WELCOME TO UNIBOOKS");
            unibookTitle.setForeground( new Color(34, 139, 34));
            unibookTitle.setFont(new Font("Monospaced", Font.BOLD, 40));
            unibookTitle.setBounds(45, 30, 750, 150);
            contentPane.add(unibookTitle);

            JLabel logoLabel = new JLabel("");
            //logoLabel.setVerticalAlignment(SwingConstants.TOP);
            ImageIcon i1  = new ImageIcon(getClass().getResource("unilogo3.png"));
            Image i2 = i1.getImage().getScaledInstance(120, 120,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
         
            logoLabel = new JLabel(i3);
            logoLabel.setBounds(235,160,100,100);
            contentPane.add(logoLabel);
           
            startButton = new JButton("Start Here");
            startButton.addActionListener(this);
            startButton.setFont(new Font("Tahoma", Font.BOLD, 11));
            startButton.setBackground(Color.BLACK);
            startButton.setForeground(Color.WHITE);
            startButton.setBounds(210, 300, 150, 30);
            contentPane.add(startButton);
            
            JPanel panel2 = new JPanel();
            panel2.setBackground(Color.WHITE);
            panel2.setBounds(35, 50, 476, 300);
            panel2.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Home Page",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
            contentPane.add(panel2);
        }
        
        @Override
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == startButton){
                setVisible(false);
                
   Login_User login= new Login_User();
    login.setVisible(true);
    login.setLocationRelativeTo(null);
            } 
    
    }
        public static void main(String[] args) {
            
      
            HomePage home = new HomePage();
            home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                home.setVisible(true);
                home.setLocationRelativeTo(null);
//                Orders ord = new Orders ();
//        ord.setNewOrder();
//            System.out.println(ord);
//        int id = ord.id; 
//            System.out.println(id);
//            System.out.println(ord.numOfOrders);
//        
  }
       
}

 class CreateTextFile{
            Formatter output;
            
            public void writeToFile(){
                List<String> data = new ArrayList<String>();
                try{
                output = new Formatter("customers.txt");
                Scanner input = new Scanner(System.in);
                conn con = new conn();
                String sql = "select * from customer";
                PreparedStatement st = con.c.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                
                while (rs.next()){
                    String cname = rs.getString("cust_name");
                    String cemail = rs.getString("cust_email");
                    String cpass = rs.getString("cust_pass");
                    String cpnum = rs.getString("custPhone");
                    data.add(cname + "," + cemail + "," + cpass + "," + cpnum);
                }
                
                for(String n : data){
                    output.format("%s%n", n);
                }
                 output.close();
                 rs.close();
                 st.close();
                }
                catch(SecurityException se){
                    System.err.println("Write permission denied.");
                    JOptionPane.showMessageDialog(null, "Cannot add/update file.");
                }
                catch(FileNotFoundException fnf){
                    System.err.println("Error opening file.");
                    JOptionPane.showMessageDialog(null, "Cannot open file.");
                }
                catch(SQLException se){
                    System.err.println("Error opening database.");
                    JOptionPane.showMessageDialog(null, "Cannot open file.");
                }
                 catch(IOException io){
                    System.err.println("Error opening file.");
                    JOptionPane.showMessageDialog(null, "Cannot open file.");
                }
            }
            
        }