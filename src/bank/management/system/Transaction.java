
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener{
 
    JButton deposit,exit,ministatement,cashwithdrawl,balanceenquiry,fastcash,pinchange;
    String pinnumber;
    
    Transaction(String pinnumber)
    {
        
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
        
        deposit = new JButton("Deposit");
        deposit.setBounds(160,270,150,15);
        image.add(deposit);
        deposit.addActionListener(this);
       
        exit= new JButton("EXIT");
        exit.setBounds(360,335,150,15);
        exit.setForeground(Color.RED);
        image.add(exit);
        exit.addActionListener(this);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(360,313,150,15);
        image.add(balanceenquiry);
        balanceenquiry.addActionListener(this);
       
        fastcash= new JButton("Fast Cash");
        fastcash.setBounds(160,293,150,15);
        image.add(fastcash);
        fastcash.addActionListener(this);
        
        pinchange= new JButton("Pin Change");
        pinchange.setBounds(160,317,150,15);
        image.add(pinchange);
        pinchange.addActionListener(this);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(360,292,150,15);
        image.add(ministatement);
        ministatement.addActionListener(this);
        
        cashwithdrawl= new JButton("Cash Withdrawl");
        cashwithdrawl.setBounds(360,270,150,15);
        image.add(cashwithdrawl);
        cashwithdrawl.addActionListener(this);
        
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }        
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource() ==cashwithdrawl)
        {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()== fastcash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()== pinchange)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceenquiry)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else
        {
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new Transaction("");
    }
}
