package bank.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener{
    int random;
    JLabel formno,personalDetails,name,fname,dob,gender,email,marital,address,city,state,pincode;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JRadioButton male,female,married,unmarried,other;
    JButton next;
    JDateChooser dateChooser;
    
    SignupOne()
    {
        setLayout(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,580);
        setLocation(200,10);
        getContentPane().setBackground(Color.WHITE);
        
        Random ran = new Random();
        random=Math.abs((ran.nextInt())/1000000);
        
        formno = new JLabel("APPLICATION FORM No. "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,28));
        formno.setBounds(220,5,600,40);
        add(formno);
        
        personalDetails = new JLabel("PAGE 1: Personal Details ");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,18));
        personalDetails.setBounds(260,60,400,30);
        add(personalDetails);
        
        name = new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,14));
        name.setBounds(100,100,200,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,13));
        nameTextField.setBounds(300,100,400,30);
        add(nameTextField);
        
        
        fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway",Font.BOLD,14));
        fname.setBounds(100,140,200,30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,13));
        fnameTextField.setBounds(300,140,400,30);
        add(fnameTextField);
        
        dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway",Font.BOLD,14));
        dob.setBounds(100,180,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,180,300,30);
        add(dateChooser);
        
        gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,14));
        gender.setBounds(100,220,200,30);
        add(gender);
        
        male= new JRadioButton("MALE");
        male.setBounds(300,220,100,30);
        add(male);
        
        female = new JRadioButton("FEMALE");
        female.setBounds(450,220,100,30);
        add(female);
        
        ButtonGroup grp = new ButtonGroup();
        grp.add(male);
        grp.add(female);
        
        email = new JLabel("Email: ");
        email.setFont(new Font("Raleway",Font.BOLD,14));
        email.setBounds(100,260,200,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,13));
        emailTextField.setBounds(300,260,400,30);
        add(emailTextField);
        
        marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway",Font.BOLD,14));
        marital.setBounds(100,300,200,30);
        add(marital);
        
        married= new JRadioButton("MARRIED");
        married.setBounds(300,300,100,30);
        add(married);
        
        unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBounds(450,300,120,30);
        add(unmarried);
        
        other = new JRadioButton("OTHER");
        other.setBounds(600,300,100 ,30);
        add(other);
        
        ButtonGroup grp2 = new ButtonGroup();
        grp2.add(married);
        grp2.add(unmarried);
        grp2.add(other);
        
        address = new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,14));
        address.setBounds(100,340,100,30);
        add(address);
       
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,13));
        addressTextField.setBounds(300,340,400,30);
        add(addressTextField);        
        
        city = new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,14));
        city.setBounds(100,380,100,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,13));
        cityTextField.setBounds(300,380,400,30);
        add(cityTextField);   
        
        state = new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,14));
        state.setBounds(100,420,100,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,13));
        stateTextField.setBounds(300,420,400,30);
        add(stateTextField); 
        
        pincode = new JLabel("Pincode: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,14));
        pincode.setBounds(100,460,100,30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,13));
        pincodeTextField.setBounds(300,460,400,30);
        add(pincodeTextField); 
        
        next= new JButton("NEXT");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setForeground(Color.BLUE);
        //next.setBackground(Color.black);
        next.setBounds(620,500,80,30);
        add(next);
        next.addActionListener(this);
        setVisible(true);
    }   
    public void actionPerformed(ActionEvent ae)
    {
        String formno= ""+random; //random converted to string 
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String email= emailTextField.getText();
        String address= addressTextField.getText();
        String city=cityTextField.getText();
        String state= stateTextField.getText();
        String pin= pincodeTextField.getText();
        
        String gender = null;
        if(male.isSelected())
           gender= "Male";
        else
           gender="Female";
        
        String marital= null;
        if(married.isSelected())
            marital="Married";
        else if(unmarried.isSelected())
            marital="Unmarried";
        else
            marital="Other";
        
        try{
            if(name.equals(""))
                JOptionPane.showMessageDialog(null, "Name is required!!!","Error!",JOptionPane.ERROR_MESSAGE);
            else {
                Connect c= new Connect();
                String q= "Insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(q);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
                System.out.println("SignupOne Updated....");      
            }
            //"String'"+variable+"'String"       
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        new SignupOne();
    }
            
}
