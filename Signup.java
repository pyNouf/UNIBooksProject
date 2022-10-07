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
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField_name;
    private JTextField textField_email;
    private JPasswordField textField_pass;
    private JTextField textField_phone;
    private JButton b1, b2;
//    public static String userid;

    public static void main(String[] args) {
        Signup signup = new Signup();
        signup.setVisible(true);
        signup.setLocationRelativeTo(null);
    }

    public Signup() {
        setBounds(600, 250, 606, 406);
        setTitle("Sign Up"); 
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
           
        JLabel lblName = new JLabel("Name :");
        lblName.setForeground(Color.DARK_GRAY);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(99, 86, 92, 26);
        contentPane.add(lblName);
        
        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setForeground(Color.DARK_GRAY);
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEmail.setBounds(99, 123, 92, 26);
        contentPane.add(lblEmail);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(Color.DARK_GRAY);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(99, 160, 92, 26);
        contentPane.add(lblPassword);
        
        JLabel lblPhone = new JLabel("Phone # :");
        lblPhone.setForeground(Color.DARK_GRAY);
        lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPhone.setBounds(99, 196, 92, 26);
        contentPane.add(lblPhone);

        textField_name = new JTextField();   //name
        textField_name.setBounds(265, 91, 148, 20);
        contentPane.add(textField_name);
        textField_name.setColumns(10);

        textField_email = new JTextField();
        textField_email.setColumns(10);
        textField_email.setBounds(265, 128, 148, 20);
        contentPane.add(textField_email);

        textField_pass = new JPasswordField();
        textField_pass.setColumns(10);
        textField_pass.setBounds(265, 165, 148, 20);
        contentPane.add(textField_pass);

        textField_phone = new JTextField();
        textField_phone.setColumns(10);
        textField_phone.setBounds(265, 202, 148, 20);
        contentPane.add(textField_phone);

        b1 = new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 13));
        b1.setBounds(140, 289, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 13));
        b2.setBounds(300, 289, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(31, 46, 476, 296);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            
            if(ae.getSource() == b1){
            String sql = "insert into customer(cust_name, cust_email, cust_pass, custPhone) values( ?, ?, ?, ?)";
            PreparedStatement st = con.c.prepareStatement(sql);

            st.setString(1, textField_name.getText());
            st.setString(2, textField_email.getText());
            st.setString(3, textField_pass.getText());
            st.setString(4, textField_phone.getText());

            int i = st.executeUpdate();
            if (i > 0){
                    JOptionPane.showMessageDialog(null, "successfully Created");  
//                    userid = textField_email.getText();
                    this.setVisible(false);
                    new Login_User().setVisible(true);
                }
            textField_name.setText("");
            textField_email.setText("");
            textField_pass.setText("");
            textField_phone.setText("");
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                Login_User lu = new Login_User();
                lu.setVisible(true);
                lu.setLocationRelativeTo(null);
      
            }
        }catch(SQLException e){
                    e.printStackTrace(); 
                    JOptionPane.showMessageDialog(null, "EMAIL ALREADY EXISTS", "ERROR", JOptionPane.ERROR_MESSAGE);
                    this.setVisible(false);
                    new Login_User().setVisible(true);
        }
        catch(Exception e){
                    e.printStackTrace();
        }
    }
}