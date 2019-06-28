import javax.swing.*;
public class Dice
{
    private JFrame frame = new JFrame("Dice");                  // frame
    private JPanel panel = new JPanel();                        // panel
   // private BorderLayout layout = new BorderLayout(1,1);
    private JButton b = new JButton();
    public void open()
    {
        //FRAME
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // frame closes when close
        
        //PANEL
        frame.setContentPane(panel);                            // connects frame and panel
        //panel.setLayout(layout);                                // connects the panel and the layout
        
        frame.setVisible(true);                                 // makes frame visible
    }
    public int roll()
    {
        return (int)Math.random() * 6 + 1;
    }
}
