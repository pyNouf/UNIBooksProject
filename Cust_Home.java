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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author sebaa
 */


public class Cust_Home extends JFrame implements ActionListener{

    final private JPanel contentPane;
   final private JButton shopButton, cartButton , ordersButton;

  
        public Cust_Home() {
  
            setBounds(600, 250, 590, 450);
            setTitle("Customer Home"); 
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);
            contentPane.setBackground(Color.WHITE);

            
            JMenuBar menuBar = new JMenuBar();
            menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.WHITE));
            menuBar.setBackground(new  Color(34, 139, 34));
            menuBar.setBounds(0, 10, 1000, 35);
            contentPane.add(menuBar);

            JMenu ExitMenu = new JMenu("Exit");
            ExitMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
            ExitMenu.setForeground(Color.WHITE);
            
            JMenuItem logoutItem = new JMenuItem("Logout");
            logoutItem.setBackground(new Color(211, 211, 211));
            logoutItem.setForeground(new Color(105, 105, 105));
            logoutItem.addActionListener(this);
            ExitMenu.add(logoutItem);
            
            JMenuItem exitItem = new JMenuItem("Exit");
            exitItem.setForeground(new Color(105, 105, 105));
            exitItem.setBackground(new Color(211, 211, 211));
            exitItem.addActionListener(this);
            ExitMenu.add(exitItem);
                
            

            JMenu aboutUsMenu = new JMenu("About Us");
            aboutUsMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
            aboutUsMenu.setForeground(Color.WHITE);

            JMenuItem mntmAboutUs = new JMenuItem("Read Me");
            mntmAboutUs.setForeground(new Color(105, 105, 105));
            mntmAboutUs.setBackground(new Color(211, 211, 211));
            mntmAboutUs.addActionListener(this);
            aboutUsMenu.add(mntmAboutUs);
            
            menuBar.add(aboutUsMenu);
            menuBar.add(ExitMenu);
            
            
            JLabel unibookTitle = new JLabel("UNIBOOKS");
            unibookTitle.setForeground(new Color(34, 139, 34));
            unibookTitle.setFont(new Font("Monospaced", Font.BOLD, 30));
            unibookTitle.setBounds(200, 30, 701, 80);
            contentPane.add(unibookTitle);

            JLabel bookIconLabel = new JLabel("");
            bookIconLabel.setVerticalAlignment(SwingConstants.TOP);
            ImageIcon i1  = new ImageIcon(getClass().getResource("bookIcon.png"));
            Image i2 = i1.getImage().getScaledInstance(120, 120,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            bookIconLabel = new JLabel(i3);
            bookIconLabel.setBounds(75, 140, 159, 152);
            contentPane.add(bookIconLabel);
            
            
            JLabel cartIconLabel = new JLabel("");
            ImageIcon i4  = new ImageIcon(getClass().getResource("shoppingcart.png"));
            Image i5 = i4.getImage().getScaledInstance(120, 120,Image.SCALE_DEFAULT);
            ImageIcon i6 = new ImageIcon(i5);
            cartIconLabel = new JLabel(i6);
            cartIconLabel.setBounds(300, 160, 250, 128);
            contentPane.add(cartIconLabel);
            
             JLabel orderstIconLabel = new JLabel("");
            ImageIcon i7  = new ImageIcon(getClass().getResource("shoppingcart.png"));
            Image i8 = i7.getImage().getScaledInstance(120, 120,Image.SCALE_DEFAULT);
            ImageIcon i9 = new ImageIcon(i8);
            cartIconLabel = new JLabel(i9);
            cartIconLabel.setBounds(130, 160, 250, 128);
            contentPane.add(orderstIconLabel);
            
            shopButton = new JButton("Shop Books");
            shopButton.addActionListener(this);
            shopButton.setBackground(Color.BLACK);
            shopButton.setForeground(Color.WHITE);
            shopButton.setBounds(80, 320, 100, 44);
            contentPane.add(shopButton);

            cartButton = new JButton("My Cart");
            cartButton.addActionListener(this);
            cartButton.setBackground(Color.BLACK);
            cartButton.setForeground(Color.WHITE);
            cartButton.setBounds(360, 320, 100, 44);
            contentPane.add(cartButton);
            
            
            
            ordersButton = new JButton("My Orders");
            ordersButton.addActionListener(this);
            ordersButton.setBackground(Color.BLACK);
            ordersButton.setForeground(Color.WHITE);
            ordersButton.setBounds(230, 320, 100, 44);
            contentPane.add(ordersButton);
        }
        
        
        @Override
        public void actionPerformed(ActionEvent ae){
            String msg = ae.getActionCommand();
            if(msg.equals("Logout")){
                setVisible(false);
                new Login_User().setVisible(true);
            } else if(msg.equals("Exit")){
                System.exit(ABORT);
            
            }else if(msg.equals("Read Me")){
                 setVisible(false);
                new aboutUs().setVisible(true);
            }
            if(ae.getSource() == shopButton){
                this.setVisible(false);
                BookShop books = new BookShop();
                books.setVisible(true); //books interface
                books.setLocationRelativeTo(null);
            }
            if(ae.getSource() == cartButton){
                this.setVisible(false);
                Cart cart = new Cart();
                cart.setVisible(true);    //my cart
                cart.setLocationRelativeTo(null);
            }
            
                 if(ae.getSource() == ordersButton){
                this.setVisible(false);
          MyOrder myMyOrder= new MyOrder();
           myMyOrder.setVisible(true);   //my cart
                myMyOrder.setLocationRelativeTo(null);
            }
    
    }
        public static void main(String[] args) {
            Cust_Home custhome = new Cust_Home();
            custhome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                custhome.setVisible(true);
                custhome.setLocationRelativeTo(null);
  }
}