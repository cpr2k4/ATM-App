package bank.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener{
    
    JLabel additionalDetails,name,fname,dob,gender,email,marital,address,city,state,pincode;
    JTextField pan,aadhar;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    //JDateChooser dateChooser;
    JComboBox religion,category,income,education,occupation;
    String formno;
    SignupTwo(String formno)
    {
        
        setLayout(null);
        
        setTitle("NEW APPLICATION FROM - PAGE 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,580);
        setLocation(200,10);
        getContentPane().setBackground(Color.WHITE);
        
        
        this.formno=formno;
        additionalDetails = new JLabel("PAGE 2: Addtional Details ");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,18));
        additionalDetails.setBounds(260,20,400,30);
        add(additionalDetails);
        
        name = new JLabel("Religion: ");
        name.setFont(new Font("Raleway",Font.BOLD,14));
        name.setBounds(100,100,200,30);
        add(name);
        
        String[] valReligion={"Hindu","Muslim","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,100,400,30);
        add(religion);
        
        fname = new JLabel("Category: ");
        fname.setFont(new Font("Raleway",Font.BOLD,14));
        fname.setBounds(100,140,200,30);
        add(fname);
        
        String[] valCategory={"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300,140,400,30);
        add(category);
        
        dob = new JLabel("Income: ");
        dob.setFont(new Font("Raleway",Font.BOLD,14));
        dob.setBounds(100,180,200,30);
        add(dob);
        
        String[] valIncome={"Null","sal<1,50,000","sal<2,50,000","sal<5,00,000","Upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300,180,400,30);
        add(income);
        
        gender = new JLabel("Educational: ");
        gender.setFont(new Font("Raleway",Font.BOLD,14));
        gender.setBounds(100,220,200,30);
        add(gender);
        
        email = new JLabel("Qualification: ");
        email.setFont(new Font("Raleway",Font.BOLD,14));
        email.setBounds(100,240,200,30);
        add(email);
        
        String educationValues[]= {"Non-Graduation","Graduate","Post-Graduation","Doctrate","Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300,230,400,30);
        add(education);
        
        marital = new JLabel("Ocupation: ");
        marital.setFont(new Font("Raleway",Font.BOLD,14));
        marital.setBounds(100,300,200,30);
        add(marital);
        
        String occupationValues[]= {"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300,300,400,30);
        add(occupation);
      
        
        address = new JLabel("PAN no: ");
        address.setFont(new Font("Raleway",Font.BOLD,14));
        address.setBounds(100,340,100,30);
        add(address);
       
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,13));
        pan.setBounds(300,340,400,30);
        add(pan);        
        
        city = new JLabel("Aadhar no: ");
        city.setFont(new Font("Raleway",Font.BOLD,14));
        city.setBounds(100,380,100,30);
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,13));
        aadhar.setBounds(300,380,400,30);
        add(aadhar);   
        
        state = new JLabel("Senior Citizen: ");
        state.setFont(new Font("Raleway",Font.BOLD,14));
        state.setBounds(100,420,200,30);
        add(state);
        
        syes= new JRadioButton("Yes");
        syes.setBounds(300,420,80,30);
        add(syes);
        
        sno= new JRadioButton("No");
        sno.setBounds(380,420,80,30);
        add(sno);
        
        ButtonGroup btn = new ButtonGroup();
        btn.add(syes);
        btn.add(sno);
        
        pincode = new JLabel("Existing Account: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,14));
        pincode.setBounds(100,460,200,30);
        add(pincode);
        
        eyes= new JRadioButton("Yes");
        eyes.setBounds(300,460,80,30);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(380,460,80,30);
        add(eno);
        
        ButtonGroup btn2= new ButtonGroup();
        btn2.add(eyes);
        btn2.add(eno);
        
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
        //String formno= ""+random; //random converted to string 
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        
        String seniorcitizen = null;
        if(syes.isSelected())
           seniorcitizen= "Yes";
        else
           seniorcitizen="No";
        
        String existingaccount= null;
        if(eyes.isSelected())
            existingaccount="Yes";
        else 
            existingaccount="No";
        
        String span= pan.getText();
        String saadhar = pan.getText();
       
        try{
            if(span.equals("")||saadhar.equals(""))
                JOptionPane.showMessageDialog(null, "All Fields are required!!!","Error!",JOptionPane.ERROR_MESSAGE);
            else {
                Connect c= new Connect();
                String q= "Insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(q);
                System.out.println("SignupTwo Updated....");   
                setVisible(false);
                new SignupThree(formno).setVisible(true);
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
        new SignupTwo("");
    }
            
}

