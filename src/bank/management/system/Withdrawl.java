package bank.management.system;
//Om Namah Shivay
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;
public class Withdrawl extends JFrame implements ActionListener{
    JLabel text;
    JButton withdraw,back;
    JTextField amount;
    String pinnumber;
    
    Withdrawl(String pinnumber)
    {
        setUndecorated(true);
        this.pinnumber=pinnumber;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons 2/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,580,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        add(image);
        
        text = new JLabel("Enter the amount you want to withdraw:");
        text.setFont(new Font("System",Font.BOLD,12));
        text.setBounds(210,190,400,20);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amount= new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(180,215,300,20);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(360,295,150,15);
        image.add(withdraw);
        withdraw.addActionListener(this);
        
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
        else if(ae.getSource()==withdraw)
        {
            String number=amount.getText();
            java.util.Date date = new java.util.Date();
            if(number.equals(""))
                JOptionPane.showMessageDialog(null,"Please Enter the amount you want to withdraw!","Error!",JOptionPane.ERROR_MESSAGE);
            else 
            {
                try{
                Connect con= new Connect();
                ResultSet rs= con.s.executeQuery("Select * from bank where pin='"+pinnumber+"'");
                int balance=0;
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
                if(ae.getSource()!=back && balance<Integer.parseInt(number))
                {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!","Error!",JOptionPane.ERROR_MESSAGE);      
                    return;
                }
                String q="Insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+number+"')";
               
                con.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Rs "+number+" Withdraw Successfully");
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
        new Withdrawl("");
    }
}
