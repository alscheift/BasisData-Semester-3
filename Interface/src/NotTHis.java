import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;  
import java.lang.Object;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;


public class NotTHis {  
     /** 
     * Connect to a sample database 
     */  
    public static void connect() {  
        Connection conn = null;  
        try {  
            // db parameters  
            //jdbc:sqlserver:ASBJORNSEN//SQLEXPRESS;databaseName=smp;integratedSecurity=true
            String url = "jdbc:sqlserver://ASBJORNSEN\\SQLEXPRESS;databaseName=smp;integratedSecurity=true;encrypt=true;trustServerCertificate=true";  
            //String user = "Passis1234";
            //String passwd = "1234";
            // create a connection to the database  
            conn = DriverManager.getConnection(url);  
              
            System.out.println("Connection to SQLServer has been established."); 
            Statement stat = conn.createStatement();
            stat.executeQuery("SELECT * FROM MAPEL;");

            ResultSet rs = stat.getResultSet();
            while (rs.next()) {
                String KdMapel = rs.getString("IdMapel");
                String NamaMapel = rs.getString("NamaMapel");
                System.out.printf("%s %s\n",KdMapel,NamaMapel);

            }

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            try {  
                if (conn != null) {  
                    conn.close();  
                }  
            } catch (SQLException ex) {  
                System.out.println(ex.getMessage());  
            }  
        }  
    }  
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) {  
        //System.out.println("Working Directory = " + System.getProperty("user.dir"));
        connect();  
    }  
}  