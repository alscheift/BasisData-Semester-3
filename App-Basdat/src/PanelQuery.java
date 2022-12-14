import java.awt.*;
import java.util.*;
import javax.swing.*;

public class PanelQuery extends JPanel{
    private final JTextArea SingleQuery;
    private final JTextArea MultiQuery;
    
    public PanelQuery(){

        //component
        SingleQuery = new JTextArea("Mengeksekusi hanya 1 query saja.");
        MultiQuery = new JTextArea("Mengeksekusi Query lebih dari 1. ");

        JButton singleQueryExec = new JButton("EXECUTE");
        JButton multiQueryExec = new JButton("EXECUTE");
        JButton backButton = new JButton("BACK");
        JButton showAllTable = new JButton("ALL TABLE NAME");

        backButton.setBackground(Color.GRAY);
        backButton.setForeground(Color.WHITE);
        singleQueryExec.setBackground(Color.GRAY);
        singleQueryExec.setForeground(Color.WHITE);
        multiQueryExec.setBackground(Color.GRAY);
        multiQueryExec.setForeground(Color.WHITE);
        showAllTable.setBackground(Color.GRAY);
        showAllTable.setForeground(Color.WHITE);

        //layout
        setPreferredSize (new Dimension (720, 480));
        setLayout (null);


        // add component
        add (SingleQuery);
        add (MultiQuery);
        add (singleQueryExec);
        add (multiQueryExec);
        add (backButton);
        add (showAllTable);

        // set component bound 
        SingleQuery.setBounds (10, 10, 510, 85);
        MultiQuery.setBounds (10, 105, 510, 325);
        
        singleQueryExec.setBounds (530, 15, 100, 25);
        multiQueryExec.setBounds (530, 105, 100, 25);
        backButton.setBounds (10, 440, 100, 25);
        showAllTable.setBounds(530, 440, 180, 25);
        
        
        // ButtonPress
        singleQueryExec.addActionListener(e -> executeSingleQuery());
        multiQueryExec.addActionListener(e -> executeMultiQuery());
        backButton.addActionListener(e -> goBackMainPanel());
        showAllTable.addActionListener(e->executeViewTableName());
    }

    private Object executeViewTableName() {
        LoadData.EXEC("SELECT Name FROM SYSOBJECTS WHERE xtype = 'U'");
        return null;
    }

    private void executeMultiQuery() {
        String query = this.MultiQuery.getText();
        String[] querysplit = query.split(";");

        Vector<String> queryvec = new Vector<>(Arrays.asList(querysplit));
        for(String query_at_i :queryvec){
            LoadData.EXEC(query_at_i);
        }
    }

    private void executeSingleQuery() {
        String query = this.SingleQuery.getText();
        LoadData.EXEC(query);
    }

    private void goBackMainPanel() {
        App.mainframe.getContentPane().removeAll();
        App.mainframe.repaint();
        App.mainframe.add(App.mainPanel);
        App.mainframe.setVisible(true);

    }


}
