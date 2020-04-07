import javax.swing.*;
import java.awt.*;
import java.awt.event.*; // #includes action listener


public class Dice implements ActionListener
{
    private JFrame frame = new JFrame("Dice");                  // frame
    private JPanel panel = new JPanel();                        // panel
    private GridLayout layout = new GridLayout(1,0);
    private JButton b = new JButton(new ImageIcon("art/dice.png"));
    private ImageIcon copTurn = new ImageIcon("art/cop.png");
    private ImageIcon robberTurn = new ImageIcon("art/robber.png");
    
    private GameRules gr;
    private boolean diceMode = false;

    
    public Dice(GameRules gr)
    {
        this.gr = gr;
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
        if(diceMode)
        {
            int x = (int)(Math.random() * 6 + 1);
            b.setIcon(new ImageIcon("art/" + x + "-dice.png"));
            diceMode = false;
            return x;
        }
        else
        {
            if(gr.getCurrentTurn() == TurnMode.ROBBERTURN)
            {
                b.setIcon(robberTurn);
            }
            else
            {
                b.setIcon(copTurn);
            }
            diceMode = true;
            return -1;
        }
    }
    
    public void actionPerformed(ActionEvent action)
    {
        roll();
    }
}
