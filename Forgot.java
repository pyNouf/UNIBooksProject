
package uniproj;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;

public class Forgot extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField emailtxt,passwordtxt;
    private JButton retrieveButton,backButton;

    public static void main(String[] args) {
  Forgot forgot =new Forgot();
  forgot.setVisible(true);
  forgot.setLocationRelativeTo(null);
    }

            public Forgot() {

                setBounds(500, 200, 650, 500);
                setTitle("Forgot Password"); 
                contentPane = new JPanel();
                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                setContentPane(contentPane);
                contentPane.setBackground(Color.WHITE);
                contentPane.setLayout(null);

            JLabel lblemail = new JLabel("Enter your Email: ");// email
            lblemail.setFont(new Font("Tahoma", Font.BOLD, 13));
            lblemail.setBounds(109, 83, 150, 29);
            contentPane.add(lblemail);

            JLabel lblpassword = new JLabel("Your Password is: ");
            lblpassword.setFont(new Font("Tahoma", Font.BOLD, 13));
            lblpassword.setBounds(109, 122, 150, 21);
            contentPane.add(lblpassword);

            emailtxt = new JTextField(); //email field
            emailtxt.setFont(new Font("Tahoma", Font.BOLD, 13));
            emailtxt.setForeground(new Color(205, 92, 92));
            emailtxt.setColumns(10);
            emailtxt.setBounds(277, 88, 139, 20);
            contentPane.add(emailtxt);

            passwordtxt = new JTextField();
            passwordtxt.setEditable(false);
            passwordtxt.setFont(new Font("Tahoma", Font.BOLD, 13));
            passwordtxt.setForeground(new Color(50, 205, 50));
            passwordtxt.setColumns(10);
            passwordtxt.setBounds(277, 123, 139, 20);
            contentPane.add(passwordtxt);


            retrieveButton = new JButton("Retrieve");
            retrieveButton.addActionListener(this);
            retrieveButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            retrieveButton.setBounds(428, 83, 100, 29);
            retrieveButton.setBackground(Color.BLACK);
                  retrieveButton.setForeground(Color.WHITE);
            contentPane.add(retrieveButton);

            backButton = new JButton("Back");
            backButton.addActionListener(this);
            backButton.setFont(new Font("Tahoma", Font.BOLD, 13));
            backButton.setBounds(350, 170, 101, 29);
                  backButton.setBackground(Color.BLACK);
                  backButton.setForeground(Color.WHITE);
            contentPane.add(backButton);
            
            JPanel panel = new JPanel();
            panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Reset Password",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
            panel.setBounds(47, 45, 508, 281);
            panel.setBackground(Color.WHITE);
            contentPane.add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource() == backButton){
                dispose();
              Login_User login =  new Login_User();
                login.setVisible(true);
                login.setLocationRelativeTo(null);
               }
            
            boolean found = false;
            conn con = new conn();
            if(ae.getSource() == retrieveButton){
                //search in customer
                String sql = "select * from customer where cust_email=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                
                //search in admin
                String sqlAdmin = "select * from admins where admin_email=?";
                PreparedStatement stAdmin = con.c.prepareStatement(sqlAdmin);

                st.setString(1, emailtxt.getText());
                stAdmin.setString(1, emailtxt.getText());
                System.out.println("found set string");
                
                ResultSet rs = st.executeQuery();
                ResultSet rsAdmin = stAdmin.executeQuery();
                System.out.println("found result set");

while (rs.next()) {
                System.out.println("found at cust");
                      passwordtxt.setText(rs.getString("cust_pass"));
                        found = true;
                }
            if(!found){
                while (rsAdmin.next()) {
                System.out.println("found at admin");
                      passwordtxt.setText(rsAdmin.getString("admin_pass"));
                      found = true;
                }
            }else if(found==false)
                    JOptionPane.showMessageDialog(null, "Invalid email...!.");
             
             
            
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}