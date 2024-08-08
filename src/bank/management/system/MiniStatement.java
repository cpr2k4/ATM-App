package bank.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
public class MiniStatement extends JFrame {
    JLabel text,bank,card,mini,balance;
    
    MiniStatement(String pinnumber)
    {
        setLayout(null);
        setBounds(20,50,450,600);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Mini Statement");
        
        bank= new JLabel("State Bank Of India");
        bank.setBounds(110,20,200,20);
        bank.setFont(new Font("System",Font.BOLD,15));
        add(bank);
        
        
        card= new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        mini = new JLabel();
        mini.setBounds(20,100,400,200);
        add(mini);
        
        balance = new JLabel();
        balance.setBounds(20,500,400,20);
        add(balance);
        try{
            Connect con = new Connect();
            ResultSet rs=con.s.executeQuery("select * from login where PIN ='"+pinnumber+"'");
            while(rs.next())
            {
                card.setText("Card Number : "+ rs.getString("Card_Number").substring(0,4)+"XXXXXXXX"+rs.getString("Card_Number").substring(12));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try{
            Connect con = new Connect();
            int bal=0;
            ResultSet rs= con.s.executeQuery("Select * from bank where PIN='"+pinnumber+"'");
            while(rs.next())
            {
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("Deposit"))
                    {
                        bal+= Integer.parseInt(rs.getString("amount"));  
                    }
                else
                    {
                        bal-=Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("Your current account balance is Rs "+bal);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    public static void main(String args[])
    {
        new MiniStatement("");
    }
}
