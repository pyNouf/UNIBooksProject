/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniproj;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Guest1
 */
public class Payment extends JFrame implements ActionListener{
    private String cvv;
    private String card_name;
    private String card_num;

   
    private JLabel methodlbl;
    private JLabel namelbl;
    private JLabel numlbl;
    private JLabel cvvlbl;
   
    private String[] myArray ={"Credit Card", "Visa", "Cash" }; 
     private JComboBox paymentType = new JComboBox(myArray);
    private JTextField nametxt;
    private JTextField numtxt=null;
    private JTextField cvvtxt;
   
    private JButton backbtn=new JButton();
    private JButton paybtn=new JButton();
   
    private JPanel contentPane = new JPanel();
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private double total_price;
    String totalp;
    int cartid= Orders.id;
    public String payment="cash";
   
    Payment(){
        setBounds(600, 250, 700, 606);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Payment");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        
        JLabel methodlbl=new JLabel("Payment Method:");
        methodlbl.setFont(new Font("Tahoma", Font.BOLD, 13));
        methodlbl.setBounds(80, 100, 200, 30);
        methodlbl.setForeground(new Color(46, 139, 87));
        methodlbl.setBackground(Color.lightGray);      
        contentPane.add(methodlbl);
               



        paymentType.setFont(new Font("Tahoma", Font.BOLD, 13));
	paymentType.setBounds(250, 100, 200, 30);
	paymentType.setForeground(new Color(46, 139, 87));
	paymentType.setBackground(Color.lightGray);
 	contentPane.add(paymentType);
        paymentType.setSelectedIndex(-1);
        
        JLabel namelbl=new JLabel("Card Holder Name:");
        namelbl.setFont(new Font("Tahoma", Font.BOLD, 13));
        namelbl.setBounds(80, 140, 200, 30);
        namelbl.setForeground(new Color(46, 139, 87));
        namelbl.setBackground(Color.lightGray);      
        contentPane.add(namelbl);
       
        JTextField nametxt=new JTextField();
        nametxt.setEnabled(true);
        nametxt.setFont(new Font("Tahoma", Font.BOLD, 13));
        nametxt.setBounds(250, 140, 200, 30);
        nametxt.setForeground(new Color(46, 139, 87));
        nametxt.setBackground(Color.lightGray);      
        contentPane.add(nametxt);
       
        JLabel numlbl=new JLabel("Card Number:");
        numlbl.setFont(new Font("Tahoma", Font.BOLD, 13));
        numlbl.setBounds(80, 180, 200, 30);
        numlbl.setForeground(new Color(46, 139, 87));
        numlbl.setBackground(Color.lightGray);      
        contentPane.add(numlbl);
       
        JTextField numtxt=new JTextField();
        numtxt.setEnabled(true);
        numtxt.setFont(new Font("Tahoma", Font.BOLD, 13));
        numtxt.setBounds(250, 180, 200, 30);
        numtxt.setForeground(new Color(46, 139, 87));
        numtxt.setBackground(Color.lightGray);      
        contentPane.add(numtxt);
       
       
        JLabel cvvlbl=new JLabel("CVV:");
        cvvlbl.setFont(new Font("Tahoma", Font.BOLD, 13));
        cvvlbl.setBounds(80, 220, 200, 30);
        cvvlbl.setForeground(new Color(46, 139, 87));
        cvvlbl.setBackground(Color.lightGray);      
        contentPane.add(cvvlbl);
      
       
        JTextField cvvtxt=new JTextField();
        cvvtxt.setEnabled(true);
        cvvtxt.setFont(new Font("Tahoma", Font.BOLD, 13));
        cvvtxt.setBounds(250, 220, 200, 30);
        cvvtxt.setForeground(new Color(46, 139, 87));
        cvvtxt.setBackground(Color.lightGray);      
        contentPane.add(cvvtxt);
       
       
        backbtn.setText("Back");
        backbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
        backbtn.setBounds(80, 320, 150, 30);
        backbtn.setForeground(new Color(46, 139, 87));
        backbtn.setBackground(Color.lightGray);
        contentPane.add(backbtn);
        backbtn.addActionListener(this);
       
       
        paybtn.setText("Check Out");
        paybtn.setFont(new Font("Tahoma", Font.BOLD, 13));
        paybtn.setBounds(300, 320, 150, 30);
        paybtn.setForeground(new Color(46, 139, 87));
        paybtn.setBackground(Color.lightGray);
        contentPane.add(paybtn);
        paybtn.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Payment",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(31,46, 476, 400);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
       

    //saraaa@mail.com
       try {
                      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/unibooks?zeroDateTimeBehavior=convertToNull","root","Level6!@#");
                    st=con.createStatement();
                    rs=st.executeQuery("SELECT sum(bprice_SR)as total from books , book_order where bookID=book_id And orderID="+cartid);
                    rs.next();
                    String sum = rs.getString(1);
                    total_price= Double.parseDouble(sum);
       }
        catch (SQLException ex) {
                        JOptionPane.showMessageDialog (null, ex.getMessage(),"Error",JOptionPane. ERROR_MESSAGE);
                }
              
        catch (Exception ex) {
               JOptionPane.showMessageDialog (null,"Exception: "+ex.getMessage (),"Ėrror",JOptionPane. ERROR_MESSAGE) ;}
       
       
    }
   
     
         @Override
        public void actionPerformed(ActionEvent e){
           
            
           
            if(e.getSource()==backbtn){
                setVisible(false);
                Cust_Home co=new Cust_Home();
                co.setVisible(true);
                co.setLocationRelativeTo(null);
            }

            if(e.getSource()==paybtn){
               
             if(paymentType.getSelectedIndex()==0){
                    payment="Credit Card";
                }
                else if(paymentType.getSelectedIndex()==1){
                    payment= "Visa";
                }
                else if(paymentType.getSelectedIndex()==2){
                    payment="Cash";
                }
                else {
                    JOptionPane.showMessageDialog (null,"You have to choose a payment method","Error",JOptionPane. ERROR_MESSAGE);
                                 
                    return;              
                }  
            int answer=JOptionPane.showConfirmDialog(null, String.format("your total is: %s S.R., do you want to continue?", total_price),"Check Out",JOptionPane.YES_NO_OPTION);//total from database??
           
            if(answer==JOptionPane. YES_OPTION){
               
                try {
                    
                    
         
                    st=con.createStatement();
                    PreparedStatement in=con.prepareStatement("INSERT INTO PAYMENT (payment_type, payment_amount_SR,o_id) VALUES (?,?,?)");
                     
                    in.setString(1, payment);
                    in.setString(2, String.valueOf(total_price));
                    in.setString(3,String.valueOf(cartid));
                    int rows=in.executeUpdate();
                   
                   
                    if (rows == 1)
                         JOptionPane.showMessageDialog (null, "Your purchase is complete!","Purchase Complete",JOptionPane.OK_OPTION);
                   
                    nametxt.setText("");
                    numtxt.setText("");
                    cvvtxt.setText("");
                    closeDB();
                   
                   
                } catch (SQLException ex) {
                        JOptionPane.showMessageDialog (null, ex.getMessage(),"Error",JOptionPane. ERROR_MESSAGE);
                }
                catch (Exception ex) {
               JOptionPane.showMessageDialog (null,"Exception: "+ex.getMessage (),"Ėrror",JOptionPane. ERROR_MESSAGE) ;}
               
                             
            }
            else
                JOptionPane.showMessageDialog (null, "purchase incomplete","purchase incomplete",JOptionPane.OK_OPTION);
           
            }
        }

   
       
       
           void closeDB (){
       
         try{
       
            con.close();
            st.close();
                       
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
                }    
       
   }

}
