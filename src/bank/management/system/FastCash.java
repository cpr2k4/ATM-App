
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
 
    JButton deposit,back,ministatement,cashwithdrawl,balanceenquiry,fastcash,pinchange;
    String pinnumber;
    JLabel text;
    JTextField amount;
    FastCash(String pinnumber)
    {
        setUndecorated(true);
        this.pinnumber=pinnumber;
        setLayout(null);
        setBounds(100,0,900,580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons 2/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,580,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,580);
        add(image);
        
        text = new JLabel("Enter the amount you want to withdraw:");
        text.setFont(new Font("System",Font.BOLD,12));
        text.setBounds(210,190,400,20);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(160,270,150,15);
        image.add(deposit);
        deposit.addActionListener(this);
       
        back= new JButton("Back");
        back.setBounds(360,335,150,15);
        back.setForeground(Color.RED);
        image.add(back);
        back.addActionListener(this);
        
        balanceenquiry = new JButton("Rs 500");
        balanceenquiry.setBounds(360,313,150,15);
        image.add(balanceenquiry);
        balanceenquiry.addActionListener(this);
       
        fastcash= new JButton("Rs 2000");
        fastcash.setBounds(160,293,150,15);
        image.add(fastcash);
        fastcash.addActionListener(this);
        
        pinchange= new JButton("Rs 5000");
        pinchange.setBounds(160,317,150,15);
        image.add(pinchange);
        pinchange.addActionListener(this);
        
        ministatement = new JButton("Rs 1000");
        ministatement.setBounds(360,292,150,15);
        image.add(ministatement);
        ministatement.addActionListener(this);
        
        cashwithdrawl= new JButton("Rs 10000");
        cashwithdrawl.setBounds(360,270,150,15);
        image.add(cashwithdrawl);
        cashwithdrawl.addActionListener(this);
        
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }        
        else
        {
            String amount= ((JButton)ae.getSource()).getText().substring(3);
            try{
                Connect con = new Connect();
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
                if(ae.getSource()!=back && balance<Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!","Error!",JOptionPane.ERROR_MESSAGE);      
                    return;
                }
                
                Date date = new Date();
                String query ="Insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+ amount +" debited successfully");
                
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
            
    }
    public static void main(String args[])
    {
        new FastCash("");
    }
}
