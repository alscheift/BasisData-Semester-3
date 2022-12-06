import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class App  {
    public static JFrame mainframe;
    public static JPanel mainPanel;
    public static JPanel QueryPanel;
    public static JLabel statusLabel;
    public static JButton btnQueryPanel;
    public static JLabel masukkanQueryLabel;
    public static ViewComboBox viewComboBox;
    public static LihatRaporSiswa procedureRaporsiswa;
    public static AnggotaKelompok Kelompok1;

    public static Connection conn;  
    public static String dbUrl = "jdbc:sqlserver://ASBJORNSEN\\SQLEXPRESS;databaseName=smp;integratedSecurity=true;encrypt=true;trustServerCertificate=true";   

    public static boolean connectDb(){
        conn = null;
        try {  
            conn = DriverManager.getConnection(dbUrl);  
            System.out.println("Connection to SQLServer has been established.");
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        return conn != null;
    }

    
    public static void setStatus(String txt){
        statusLabel.setText("Status : "+txt);
    }

    public static void main(String[] args) throws Exception {
        mainframe = new JFrame("Kelompok 1 Basis Data");
        QueryPanel = new PanelQuery();

        btnQueryPanel = new JButton("Query");
        btnQueryPanel.setBounds(300,70,200,80);
        btnQueryPanel.addActionListener(e-> gotoQueryPanel());

        masukkanQueryLabel = new JLabel("Masukkan Query(SELECT, INSERT, UPDATE ... DLL)");
        masukkanQueryLabel.setBounds(300,50,400,25);
        

        statusLabel = new JLabel();
        statusLabel.setBounds(0,0,720,25);

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(720,480));
        mainPanel.setLayout(null);
    

        mainPanel.add(statusLabel);
        mainPanel.add(masukkanQueryLabel);
        mainPanel.add(btnQueryPanel);
        mainPanel.add(masukkanQueryLabel);

        viewComboBox = new ViewComboBox(mainPanel);
        procedureRaporsiswa = new LihatRaporSiswa(mainPanel);
        Kelompok1 = new AnggotaKelompok(mainPanel);

        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.add(mainPanel);
        mainframe.pack();
        mainframe.setVisible(true);
       
        setStatus("Connecting to DB...");
        
        if(connectDb()){
            setStatus("SQL Server Connection Success...");

            
        }else{
            setStatus("SQL Server Connection Failed...");
        }
        
    }


    private static void gotoQueryPanel() {
        mainframe.getContentPane().removeAll();
        App.mainframe.repaint();
        mainframe.add(QueryPanel);
        mainframe.pack();
        mainframe.setVisible(true);
    }
    
}

        