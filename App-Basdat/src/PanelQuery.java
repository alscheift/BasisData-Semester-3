import java.awt.*;
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
        
    }

    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new PanelQuery());
        frame.pack();
        frame.setVisible (true);
    }
}
