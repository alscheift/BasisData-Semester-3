import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class LoadData extends JFrame {

    private final DefaultTableModel tableModel = new DefaultTableModel();

    public LoadData(String querytoexec) throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        JTable table = new JTable(tableModel);
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

    public static void EXEC(String querytoexec) {
        EventQueue.invokeLater(() -> new LoadData(querytoexec));
    }

    private void SQLTable(String querytoexec) {

        Statement stmt;
        try {
            // App.conn = DriverManager.getConnection(App.dbUrl); // kalau ingin reconnect
            // setiap saat
            stmt = App.conn.createStatement();

            boolean isReturning = stmt.execute(querytoexec);
            ResultSet rs = stmt.getResultSet();
            System.out.println(querytoexec);
            ResultSetMetaData metaData = rs.getMetaData();
            if (!isReturning) {
                System.out.println("No data");
            } else {
                // Nama kolomnya

                setVisible(true);
                Vector<String> columnNames = new Vector<>();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    columnNames.add(metaData.getColumnName(i));
                }

                // Masukkan data
                Vector<Vector<Object>> data = new Vector<>();
                while (rs.next()) {
                    Vector<Object> vector = new Vector<>();
                    for (int i = 1; i <= columnCount; i++) {
                        vector.add(rs.getObject(i));
                    }
                    data.add(vector);
                }

                tableModel.setDataVector(data, columnNames);
            }
            // Menutup koneksi statement dan resultset, untuk connection jangan di close
            // kalau tidak reconnect setiap query.
            rs.close();
            stmt.close();
            // App.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}