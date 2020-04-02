import javax.swing.*;
import java.awt.*;
import java.awt.event.*; // #includes action listener


public class Dice implements ActionListener
{
    private JFrame frame = new JFrame("Dice");                  // frame
    private JPanel panel = new JPanel();                        // panel
    private GridLayout layout = new GridLayout(1,0);
    private JButton b = new JButton(new ImageIcon("art/dice.png"));

    
    public Dice()
    {
        this.open();
    }
    
    public void open()
    {
        //FRAME
        frame.setSize(100,125);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // frame closes when close
        
        //PANEL
        frame.setContentPane(panel);                            // connects frame and panel
        panel.setLayout(layout);                                // connects the panel and the layout
        panel.add(b);
        b.addActionListener(this);
        frame.setVisible(true);                                 // makes frame visible
    }
    public int roll()
    {
        int x = (int)(Math.random() * 6 + 1);
        b.setIcon(new ImageIcon("art/" + x + "-dice.png"));
        return x;
    }
    
    public void actionPerformed(ActionEvent action)
    {
        roll();
    }
}
