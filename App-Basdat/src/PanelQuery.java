import java.awt.*;
import java.util.*;

import javax.swing.*;


public class PanelQuery extends JPanel{
    private JTextArea SingleQuery;
    private JTextArea MultiLineQuery;
    private JButton SingleExec;
    private JButton MultiLineExec;
    private JButton BackButton;

    public PanelQuery(){

        //component
        SingleQuery = new JTextArea("Single Line Query...");
        MultiLineQuery = new JTextArea("Multi Line...");

        SingleExec = new JButton("EXECUTE");
        MultiLineExec = new JButton("EXECUTE");
        BackButton = new JButton("BACK");

        //layout
        setPreferredSize (new Dimension (720, 480));
        setLayout (null);


        // add component
        add (SingleQuery);
        add (MultiLineQuery);
        add (SingleExec);
        add (MultiLineExec);
        add (BackButton);

        // set component bound 
        SingleQuery.setBounds (10, 10, 510, 85);
        MultiLineQuery.setBounds (10, 105, 510, 325);
        
        SingleExec.setBounds (530, 15, 100, 25);
        MultiLineExec.setBounds (530, 105, 100, 25);
        BackButton.setBounds (10, 440, 100, 25);
        
        // ButtonPress
        SingleExec.addActionListener(e -> executeSingleQuery());
        MultiLineExec.addActionListener(e -> executeMultiQuery());
        BackButton.addActionListener(e -> goBackMainPanel());
    }

    private Object executeMultiQuery() {
        String query = this.MultiLineQuery.getText();
        String[] querysplit = query.split(";");

        Vector<String> queryvec = new Vector<String>();
        queryvec.addAll(Arrays.asList(querysplit));
        for(String query_at_i :queryvec){
            LoadData.EXEC(query_at_i);
        }
        return null;
    }

    private Object executeSingleQuery() {
        String query = this.SingleQuery.getText();
        LoadData.EXEC(query);
        return null;
    }

    private Object goBackMainPanel() {
        App.mainframe.getContentPane().removeAll();
        App.mainframe.repaint();
        App.mainframe.add(App.mainPanel);
        App.mainframe.setVisible(true);
        
        return null;
    }


}
