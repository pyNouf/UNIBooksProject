
package uniproj;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Guest1
 */
public class Cart extends JFrame{

    Connection connect;
    Statement statement;
    ResultSet resultset;
    private JPanel contentPane = new JPanel();
    private JButton BackButton = new JButton();
    private JButton PayButton = new JButton();
    private JButton ClearButton = new JButton();
    private JLabel Total;
    private JTable carttbl=new JTable();
    private JScrollPane scroll=new JScrollPane(carttbl);
    int cartid = Orders.id;
   
    Cart() {
        setBounds(600, 250, 700, 606);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed (WindowEvent event){
              closeDB();  
              System.exit(0);
            }
        });


        setTitle("My Cart");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
       
        fillTable();
        scroll.setBounds(40, 150, 606, 100);
        scroll.setForeground(new Color(46, 139, 87));
        scroll.setBackground(Color.lightGray);
        contentPane.add(scroll);
       
        JPanel panel = new JPanel();
panel.setForeground(new Color(34, 139, 34));
panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "My Cart",
TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
panel.setBounds(31, 130, 620, 175);
        panel.setBackground(Color.WHITE);
contentPane.add(panel);
       
        BackButton.setText("Back");
BackButton.setFont(new Font("Tahoma", Font.BOLD, 13));
BackButton.setBounds(80, 400, 100, 30);
BackButton.setForeground(new Color(46, 139, 87));
BackButton.setBackground(Color.lightGray);
        contentPane.add(BackButton);
       
       
        PayButton.setText("Payment");
PayButton.setFont(new Font("Tahoma", Font.BOLD, 13));
PayButton.setBounds(320, 400, 100, 30);
PayButton.setForeground(new Color(46, 139, 87));
PayButton.setBackground(Color.lightGray);
        contentPane.add(PayButton);
       
       
        PayButton.addActionListener(new ButtonHandler());
        BackButton.addActionListener(new ButtonHandler());

       
    }
   
    private class ButtonHandler implements ActionListener
{
        @Override
        public void actionPerformed(ActionEvent e) {
        if(e.getSource()==BackButton){
            setVisible(false);
            Cust_Home co=new Cust_Home();
            co.setVisible(true);
            co.setLocationRelativeTo(null);
        }  
           
                     
        if(e.getSource() == PayButton){  
            setVisible(false);
            Payment product = new Payment();
            product.setVisible(true);
            product.setLocationRelativeTo(null);
           
        }
   
}      
}
    private void fillTable() {
       
        try{
            connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/unibooks?zeroDateTimeBehavior=convertToNull", "root", "Level6!@#");
            statement=connect.createStatement();
            resultset=statement.executeQuery("SELECT ord.orderID, b.Btitle, b.bprice_SR "
                    + "FROM book_order AS ord JOIN BOOKS AS b "
                    + "where b.book_id=ord.bookID AND ord.orderID = '"+cartid+"'");
            carttbl.setModel(DbUtils.resultSetToTableModel(resultset));
           

        }
       
        catch(SQLException e){
            JOptionPane.showMessageDialog (null, e.getMessage(),"Error",JOptionPane. ERROR_MESSAGE);}  
       
       
    }
   
    void closeDB (){
       
         try{
       
            connect.close();
            statement.close();
            resultset.close();
                       
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
                }    
       
   }
   
   
}