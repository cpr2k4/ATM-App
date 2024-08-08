package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.awt.event.*;
public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,0,900,580);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons 2/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 580, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        add(image);
        
        back = new JButton("BACK");
        back.setFont(new Font("System",Font.BOLD,13));
        back.setForeground(Color.RED);
        back.setBounds(420,310,100,25);
        image.add(back);
        back.addActionListener(this);
        
        int balance=0;
        try{
            Connect con = new Connect();
                ResultSet rs= con.s.executeQuery("Select * from bank where pin='"+pinnumber+"'");
                
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance+= Integer.parseInt(rs.getString("amount"));  
                    }
                    else
                    {
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel text= new JLabel("Your Current Account balance is Rs "+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(160,200,400,30);
        image.add(text);
        setVisible(true); 
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    public static void main(String args[])
    {
        new BalanceEnquiry("");
    }
}
