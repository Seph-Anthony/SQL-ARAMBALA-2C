
package sqlarambala2c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite: test2.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.println("Enter Student ID: ");
        int id = in.nextInt();
        in.nextLine();
        System.out.println("Enter First Name: ");
        String fname = in.nextLine();
        System.out.println("Enter Last Name: ");
        String lname =in.nextLine();
        System.out.println("Enter Email: ");
        String em = in.next();
        System.out.println("Enter Status");
        String sts = in.next();
        
        String sql = "Insert Into Studentsss (id, fname, lname, email, status) VALUES (?, ?, ?, ?, ?)";
        
        try {
            
                Connection con = connectDB();
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, id);
                pst.setString (2, fname);
                pst.setString (3, lname);
                pst.setString (4, em);
                pst.setString (5, sts);
                pst.executeUpdate();
                
                System.out.println("Insert Successfully");
                
        }catch (SQLException ex){
                        System.out.println("Connection Error: "+ex.getMessage());
                        
                        }
            
        }
        }
        
    
    

