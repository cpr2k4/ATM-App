package bank.management.system;
//Om Namah Shivay
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener{
    JLabel text;
    JButton deposit,back;
    JTextField amount;
    String pinnumber;
    
    Deposit(String pinnumber)
    {
        setUndecorated(true);
        this.pinnumber=pinnumber;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons 2/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,580,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        add(image);
        
        text = new JLabel("Enter the amount you want to deposit:");
        text.setFont(new Font("System",Font.BOLD,12));
        text.setBounds(210,190,400,20);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amount= new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(180,215,300,20);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(360,295,150,15);
        image.add(deposit);
        deposit.addActionListener(this);
        
        back= new JButton("Back");
        back.setBounds(360,315,150,15);
        back.setForeground(Color.RED);
        image.add(back);
        back.addActionListener(this);
        
        setBounds(100,0,900,580);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
           setVisible(false);
           new Transaction(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==deposit)
        {
            String number=amount.getText();
            java.util.Date date = new java.util.Date();
            if(number.equals(""))
                JOptionPane.showMessageDialog(null,"Please Enter the amount you want to deposit!","Error!",JOptionPane.ERROR_MESSAGE);
            else 
            {
                Connect con= new Connect();
                String q="Insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                try{
                con.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                
            }
        }
    }
    public static void main(String args[])
    {
        new Deposit("");
    }
}
