

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

// import java.lang.System.Logger.*;
// import java.util.logging.Logger;
// import java.util.logging.Formatter;
// import java.util.logging.Handler;
// import java.util.logging.Level;
// import java.util.logging.LogRecord;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.HeadlessException;
import java.awt.BorderLayout;
import java.awt.EventQueue;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Vector;

public class JPanel2_Exec extends JFrame {

    public static void EXEC(String querytoexec){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JPanel2_Exec(querytoexec).setVisible(true);
            }
        });
    }

    private final JTable table;
    private final DefaultTableModel tableModel = new DefaultTableModel();

    public JPanel2_Exec(String querytoexec) throws HeadlessException {

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                loadData(querytoexec);
                return null;
            }
        }.execute();

        setSize(640, 480);
    }

    private void loadData(String querytoexec) {
        //LOG.info("START loadData method");

       // button.setEnabled(false);
        String url = "jdbc:sqlserver://ASBJORNSEN\\SQLEXPRESS;databaseName=smp;integratedSecurity=true;encrypt=true;trustServerCertificate=true";  
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(querytoexec);
            ResultSetMetaData metaData = rs.getMetaData();

            // Names of columns
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // Data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(i));
                }
                data.add(vector);
            }

            tableModel.setDataVector(data, columnNames);
        } catch (Exception e) {
        }
    }

}