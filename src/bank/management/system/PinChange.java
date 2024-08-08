package bank.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener
{
    JLabel text,pintext,repintext;
    JPasswordField pintextfield,repintextfield;
    JButton change,back,clear,show;
    String pinnumber;
    PinChange(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setBounds(100,0,900,580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons 2/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,580,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        text= new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        text.setBounds(260,165,400,20);
        image.add(text);
        
        pintext= new JLabel("New PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,12));
        pintext.setBounds(170,235,200,20);
        image.add(pintext);
        
        repintext= new JLabel("Re-enter new PIN:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,12));
        repintext.setBounds(170,265,200,20);
        image.add(repintext);
        
        pintextfield= new JPasswordField();
        pintextfield.setFont(new Font("System",Font.BOLD,12));
        pintextfield.setBounds(300,235,120,20);
        image.add(pintextfield);
        
        repintextfield= new JPasswordField();
        repintextfield.setFont(new Font("System",Font.BOLD,12));
        repintextfield.setBounds(300,265,120,20);
        image.add(repintextfield);
        
        change= new JButton("Change");
        change.setBounds(350,310,80,30);
      //change.setOpaque(true);
        change.setForeground(Color.BLUE);
        image.add(change);
        change.addActionListener(this);
        
        back= new JButton("BACK");
        back.setBounds(440,310,80,30);
        back.setForeground(Color.RED);
        image.add(back);
        back.addActionListener(this);
        
        clear = new JButton("Clear");
        clear.setBounds(260,310,80,30);
        clear.setForeground(Color.MAGENTA);
        image.add(clear);
        clear.addActionListener(this);
        
        show = new JButton("Show");
        show.setBounds(170,310,80,30);
        show.setForeground(Color.ORANGE);
        image.add(show);
        show.addActionListener(this);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Check c= new Check();
        try{
            if(ae.getSource()==clear)
            {
                pintextfield.setText("");
                repintextfield.setText("");
            }
            else if(ae.getSource()==change)
            {
                String pin= pintextfield.getText();
                String repin= repintextfield.getText();
                if(c.check(pin))
                {
                     JOptionPane.showMessageDialog(null, "Please enter 4 DIGITS only!!!","Error!",JOptionPane.ERROR_MESSAGE);
                }
                if(c.check(repin))
                {
                     JOptionPane.showMessageDialog(null, "Please enter 4 DIGITS only!!!","Error!",JOptionPane.ERROR_MESSAGE);
                }
                else if(!pin.equals(repin))
                    JOptionPane.showMessageDialog(null, "Entered PIN doesn't match!!!","Error!",JOptionPane.ERROR_MESSAGE);
                else if(pin.equals("") || repin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter all fields!!!","Error!",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    Connect con = new Connect();
                    String q1="Update bank set PIN ='"+repin+"' where PIN='"+pinnumber+"'";
                    String q2="Update login set PIN ='"+repin+"' where PIN='"+pinnumber+"'";
                    String q3="Update signupthree set PIN ='"+repin+"' where PIN='"+pinnumber+"'";
                    
                    con.s.executeUpdate(q1);
                    con.s.executeUpdate(q2);
                    con.s.executeUpdate(q3);
                    JOptionPane.showMessageDialog(null, "Pin changed successfully!","Success!",JOptionPane.PLAIN_MESSAGE);
                    
                    pintextfield.
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }
                
            }
            else if(ae.getSource()==show)
            {
                pintextfield.setEchoChar((char)0);
                repintextfield.setEchoChar((char)0);
            }
            else 
            {
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        new PinChange("").setVisible(true);
    }
}
