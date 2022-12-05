import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class App  {
    public static JFrame mainframe;
    public static JPanel mainPanel;
    public static JLabel statusLabel;
    public static Connection conn;  
    public static String dbUrl = "jdbc:sqlserver://ASBJORNSEN\\SQLEXPRESS;databaseName=smp;integratedSecurity=true;encrypt=true;trustServerCertificate=true";   

    /**
     * @return
     */
    public static boolean connectDb(){
        conn = null;
        try {  
            conn = DriverManager.getConnection(dbUrl);  
            System.out.println("Connection to SQLServer has been established.");
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        if(conn==null) return false;
        return true;
    }

    
    public static void setStatus(String txt){
        statusLabel.setText("Status : "+txt);
    }

    public static void main(String[] args) throws Exception {
        mainframe = new JFrame("Kelompok 1 Basis Data");
        
        statusLabel = new JLabel();
        statusLabel.setBounds(0,0,720,25);

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(720,480));
        mainPanel.setLayout(null);

        mainPanel.add(statusLabel);


        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.add(mainPanel);;
        mainframe.pack();
        mainframe.setVisible(true);
       
        setStatus("Connecting to DB...");
        
        if(connectDb()){
            setStatus("SQL Server Connection Success...");
            LoadData.EXEC("select * from mapel;");
            LoadData.EXEC("select * from siswa;");
            LoadData.EXEC("select * from guru;");
            
        }else{
            setStatus("SQL Server Connection Failed...");
        }
        
    }
    
}

