/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniproj;

/**
 *
 * @author sebaa
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.*;
import java.sql.*;

public class Login_User extends JFrame implements ActionListener{

    

  final private JPanel panel;
  final private JTextField emailtxt;
  final private JPasswordField passwordField;
  final private JButton loginButton,signupButton,forgotButton;
    public static String userid;

  public Login_User() {
           
       panel = new JPanel();

        setBounds(600, 250, 590, 406);
        setTitle("Login"); 
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
     
    

  JLabel email = new JLabel("Email : ");
  email.setBounds(124, 89, 95, 24);
  panel.add(email);

  JLabel password = new JLabel("Password : ");
  password.setBounds(124, 124, 95, 24);
  panel.add(password);

  emailtxt = new JTextField();
  emailtxt.setBounds(210, 93, 157, 20);
  panel.add(emailtxt);
  
  passwordField = new JPasswordField();
  passwordField.setBounds(210, 128, 157, 20);
  panel.add(passwordField);

  JLabel l3 = new JLabel("");
  l3.setBounds(377, 79, 46, 34);
  panel.add(l3);

  JLabel l4 = new JLabel("");
  l4.setBounds(377, 124, 46, 34);
  panel.add(l3);

  loginButton = new JButton("Login");
  loginButton.addActionListener(this);
  loginButton.setFont(new Font("Tahoma", Font.BOLD, 13));
  loginButton.setBounds(160, 200, 100, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);

  panel.add(loginButton);
    
        signupButton = new JButton("SignUp");
  signupButton.addActionListener(this);
  signupButton.setFont(new Font("Tahoma", Font.BOLD, 13));
  signupButton.setBounds(300, 200, 100, 30);
  signupButton.setBackground(Color.BLACK);
     signupButton.setForeground(Color.WHITE);
  panel.add(signupButton);

  forgotButton = new JButton("Forgot Password");
  forgotButton.addActionListener(this);
  forgotButton.setFont(new Font("Tahoma", Font.BOLD, 11));
  forgotButton.setBackground(Color.BLACK);
    forgotButton.setForeground(Color.WHITE);
  forgotButton.setBounds(210, 250, 150, 30);
  panel.add(forgotButton);

  JLabel l5 = new JLabel("Trouble in Login?");
  l5.setFont(new Font("Tahoma", Font.PLAIN, 14));
  l5.setForeground(new Color(255, 0, 0));
  l5.setBounds(75, 255, 130, 20);
  panel.add(l5);

    JPanel panel2 = new JPanel();
    panel2.setBackground(Color.WHITE);
    panel2.setBounds(31, 46, 476, 296);
    panel2.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Login",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
    panel.add(panel2);
  }
        
        
  @Override
  public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == loginButton){
                Boolean status = false;
    try {
                    conn con = new conn();
                    String sql = "select * from customer where cust_email=? and cust_pass=?";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    String sqlAdmin = "select * from admins where admin_email=? and admin_pass=?";
                    PreparedStatement stAdmin = con.c.prepareStatement(sqlAdmin);

                    st.setString(1, emailtxt.getText());
                    st.setString(2, passwordField.getText());
                    
                    
                    stAdmin.setString(1, emailtxt.getText());
                    stAdmin.setString(2, passwordField.getText());
                    
                    ResultSet rs = st.executeQuery();
                    ResultSet rsAdmin = stAdmin.executeQuery();
                    if (rs.next()) {
                        this.setVisible(false);
                        userid = emailtxt.getText();
                        new Cust_Home().setVisible(true);    //cust homepage
                        
                    }
                    else if (rsAdmin.next()) {
                        this.setVisible(false);
                        userid = emailtxt.getText();
                        new Admin().setVisible(true);    //admin homepage
                    }else
                    JOptionPane.showMessageDialog(null, "Invalid Login...!\n Wrong email/password.");
                      
    } catch (Exception e2) {
                    e2.printStackTrace();
    }
            }
            if(ae.getSource() == signupButton){
                setVisible(false);
    Signup su = new Signup();
    su.setVisible(true);
    su.setLocationRelativeTo(null);
            }   
            if(ae.getSource() == forgotButton){
                setVisible(false);
    
              Forgot forgot =  new Forgot();
    forgot.setVisible(true);
    forgot.setLocationRelativeTo(null);
            }
        }
        
    public static void main(String[] args) {
                Login_User lu = new Login_User();
                lu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                lu.setVisible(true);
                lu.setLocationRelativeTo(null);
  }

}