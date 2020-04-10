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
    private Board board;
    private boolean diceMode = true;
    private int rollValue;

    
    public Dice(Board board,GameRules gr)
    {
        this.board = board;
        this.gr = gr;
        this.rollValue = 0;
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
    
    public void roll()
    {
        if(diceMode)
        {
            rollValue = (int)(Math.random() * 6 + 1);
            b.setIcon(new ImageIcon("art/" + rollValue + "-dice.png"));
            diceMode = false;
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
        }
    }
    
    public void setDiceModeTrue()
    {
        diceMode = true;
    }
    
    public boolean getDiceMode()
    {
        return diceMode;
    }
    
    public int getRollValue()
    {
        return rollValue;
    }
    
    public void actionPerformed(ActionEvent action)
    {
        roll();
    }
}
