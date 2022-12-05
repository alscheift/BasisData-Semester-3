import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class App extends JPanel {
   // Name-constants to define the various dimensions
   public static final int WINDOW_WIDTH = 1280;
   public static final int WINDOW_HEIGHT = 720;
   // ......
 
   // Create the GUI and show it.
   // For thread safety, this method should be invoked from event-dispatching thread.
   private static void createAndShowGUI() {
      // Create and set up the application window
      JFrame frame = new JFrame("...Your Title...");
      frame.setContentPane(new App());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            // or frame.pack() to "pack" all the components in this frame
      frame.setVisible(true);  // show it
      
      JTextArea ta=new JTextArea(200,200);  
      JPanel p1=new JPanel();  
      p1.add(ta);  
      JPanel p2=new JPanel();  
      JPanel p3=new JPanel();  
      JTabbedPane tp=new JTabbedPane();  
      tp.setBounds(50,50,200,200);  
      tp.add("main",p1);  
      tp.add("visit",p2);  
      tp.add("help",p3);    
      frame.add(tp);  
      frame.setSize(400,400);  
      frame.setLayout(null);  
      frame.setVisible(true);  
      
   }
 


   public static void main(String[] args) {
      // Schedule a job for the event-dispatching thread to create and show this application's GUI.
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            createAndShowGUI();
         }
      });
      // ......
   }
}