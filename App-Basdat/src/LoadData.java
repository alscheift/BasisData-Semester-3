import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class LoadData extends JFrame {

    private final JTable table;
    private final DefaultTableModel tableModel = new DefaultTableModel();

    public static void EXEC(String querytoexec) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoadData(querytoexec).setVisible(true);
            }
        });
    }

    public LoadData(String querytoexec) throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {

                SQLTable(querytoexec);
                return null;
            }
        }.execute();

        setSize(640, 480);
    }

    private void SQLTable(String querytoexec) {

        Statement stmt;
        try {
            // App.conn = DriverManager.getConnection(App.dbUrl); // kalau ingin reconnect
            // setiap saat
            stmt = App.conn.createStatement();

            ResultSet rs = stmt.executeQuery(querytoexec);
            System.out.println(querytoexec);
            ResultSetMetaData metaData = rs.getMetaData();
            
            // Nama kolomnya
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // Masukkan data
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(i));
                }
                data.add(vector);
            }

            tableModel.setDataVector(data, columnNames); 

            // Menutup koneksi statement dan resultset, untuk connection jangan di close kalau tidak reconnect setiap query.
            rs.close();
            stmt.close();
            //App.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}