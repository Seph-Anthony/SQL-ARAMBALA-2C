
package sqlarambala2c;

import java.util.*;
import java.sql.*;




public class Main {
    public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:test.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        
        
        System.out.println("Enter Student ID: ");
        int s_id = in.nextInt();
      
        System.out.println("Enter First Name: ");
        String f_name = in.next();
        System.out.println("Enter Last Name: ");
        String l_name =in.next();
        System.out.println("Enter Email: ");
        String e_m = in.next();
        System.out.println("Enter Status");
        String s_ts = in.next();
        
        String sql = "Insert Into Student (s_id, s_fname, s_lname, s_email, s_status) VALUES (?, ?, ?, ?, ?)";
        
        try {
            
                Connection con = connectDB();
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, s_id);
                pst.setString (2, f_name);
                pst.setString (3, l_name);
                pst.setString (4, e_m);
                pst.setString (5, s_ts);
                pst.executeUpdate();
                
                System.out.println("Insert Successfully");
                
        }catch (SQLException ex){
                        System.out.println("Connection Error: "+ex.getMessage());
                        
                        }
            
        }
        }
        
    
    

