package bank.management.system;

import java.sql.*;
public class Connect 
{
    Connection c;
    Statement s;
    public Connect()
    {
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","Chinmay@25");
            s=c.createStatement();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
