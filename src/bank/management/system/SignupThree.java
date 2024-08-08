package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class SignupThree extends JFrame implements ActionListener{
    JLabel l1,type,card,number,pin,pnumber,carddetail,pindetail,services;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton cancel,submit;
    String formno;
    SignupThree(String formno)
    {
        
        setLayout(null);
        setTitle("Third Page:");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200,10,800,580);
        getContentPane().setBackground(Color.WHITE);
     
        this.formno=formno;
        l1= new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,10,400,40);
        add(l1);
        
        type = new JLabel("Account Type :");
        type.setFont(new Font("Railway",Font.BOLD,18));
        type.setBounds(100,70,200,30);
        add(type);
        
        r1= new JRadioButton("Saving Account");
        r1.setBounds(100,100,200,20);
        add(r1);
        
        r2= new JRadioButton("Fixed deposit Account");
        r2.setBounds(300,100,200,20);
        add(r2);
        
        r3= new JRadioButton("Current Account");
        r3.setBounds(100,130,200,20);
        add(r3);
        
        r4= new JRadioButton("Recurring Deposit Account");
        r4.setBounds(300,130,220,20);
        add(r4);
        
        ButtonGroup btn = new ButtonGroup();
        btn.add(r1);
        btn.add(r2);
        btn.add(r3);
        btn.add(r4);
        
        card= new JLabel("Card Number :");
        card.setFont(new Font("Raleway",Font.BOLD,16));
        card.setBounds(100,170,200,30);
        add(card);
        
        number= new JLabel("XXXX-XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,16));
        number.setBounds(300,170,300,30);
        add(number);
        
        carddetail= new JLabel("(Your 16 Digits Card Number)");
        carddetail.setFont(new Font("Raleway",Font.BOLD,11));
        carddetail.setBounds(100,190,300,30);
        add(carddetail);
        
        pin= new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,16));
        pin.setBounds(100,240,200,30);
        add(pin);
        
        pnumber= new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,16));
        pnumber.setBounds(300,240,300,30);
        add(pnumber);
        
        pindetail= new JLabel("(Your 4 Digit PIN Number)");
        pindetail.setFont(new Font("Raleway",Font.BOLD,11));
        pindetail.setBounds(100,260,200,30);
        add(pindetail);
        
        services= new JLabel("Services required:");
        services.setFont(new Font("Raleway",Font.BOLD,16));
        services.setBounds(100,310,200,30);
        add(services);
        
        c1= new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,340,200,20);
        add(c1);
        
        c2= new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setBounds(300,340,200,20);
        add(c2);
        
        c3= new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setBounds(500,340,200,20);
        add(c3);
        
        c4= new JCheckBox("Email/SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setBounds(100,370,200,20);
        add(c4);
        
        c5= new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setBounds(300,370,200,20);
        add(c5);
        
        c6= new JCheckBox("E Statement");
        c6.setBackground(Color.WHITE);
        c6.setBounds(500,370,200,20);
        add(c6);
        
        c7= new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setBounds(100,440,600,20);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,18));
        submit.setBounds(250,480,100,40);
        submit.setForeground(Color.BLUE);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway",Font.BOLD,18));
        cancel.setBounds(380,480,100,40);
        cancel.setForeground(Color.RED);
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String accountType=null;
            if(r1.isSelected())
                accountType="Saving Account";
            else if(r2.isSelected())
                accountType="Fixed Deposit Account";
            else if(r3.isSelected())
                accountType="Current Account";
            else
                accountType="Reccuring Deposit Account";
            
            Random ran = new Random();
            String cardnumber= "" + Math.abs((ran.nextLong()%90000000L) + 5040936000000000L);
            String pinnumber= "" + Math.abs((ran.nextLong()%9000L)+1000L);
            String facility="";
            if(c1.isSelected())
                facility=facility + " ATM card";
            else if(c2.isSelected())
                facility=facility + " Internet Banking";
            else if(c3.isSelected())
                facility= facility+" Mobile Banking";
            else if(c4.isSelected())
                facility= facility+" Email/SMS alerts";
            else if(c5.isSelected())
                facility= facility+ " Check Book";
            else
                facility =facility+ " E Statement";
            
            try{
                if(accountType.equals(""))
                    JOptionPane.showMessageDialog(null,"Account Type Required!!!","Error!",JOptionPane.ERROR);
                else
                {
                    Connect con= new Connect();
                    String q1="Insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String q2="Insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    con.s.executeUpdate(q1);
                    con.s.executeUpdate(q2);
                    
                    JOptionPane.showMessageDialog(null,"Card Number : "+cardnumber+"\nPIN : "+pinnumber);
                    System.out.println("SignupThree Updated...");
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
              
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
       
        }
        else 
        {
            setVisible(false);
            new Login().setVisible(true);
        }
             
    }
    
    public static void main(String args[])
    {
        new SignupThree("");
    }
}
