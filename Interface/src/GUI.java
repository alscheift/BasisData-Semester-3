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

public class GUI extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new GUI().setVisible(true));
    }

    private final JButton button;
    private final DefaultTableModel tableModel = new DefaultTableModel();

    public GUI() throws HeadlessException {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTable table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        button = new JButton("Load Data");
        button.addActionListener(e -> new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                loadData();
                return null;
            }
        }.execute());
        add(button, BorderLayout.PAGE_START);

        setSize(640, 480);
    }

    private void loadData() {
        //LOG.info("START loadData method");

        button.setEnabled(false);
        String url = "jdbc:sqlserver://ASBJORNSEN\\SQLEXPRESS;databaseName=smp;integratedSecurity=true;encrypt=true;trustServerCertificate=true";  
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM SISWA;");
            ResultSetMetaData metaData = rs.getMetaData();

            // Names of columns
            Vector<String> columnNames = new Vector<>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // Data of the table
            Vector<Vector<Object>> data = new Vector<>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(i));
                }
                data.add(vector);
            }

            tableModel.setDataVector(data, columnNames);
        } catch (Exception e) {
            //LOG.log(Level.SEVERE, "Exception in Load Data", e);
        }
        button.setEnabled(true);

        //LOG.info("END loadData method");
    }

}