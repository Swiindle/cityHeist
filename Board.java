/**
 * This is the Board class. This class is in charge of implementing all types of java swing. And representing a real life checkers board.
 */

import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels
import java.awt.event.*; // #includes action listener
import java.util.*;

public class Board
{
    /* INSTANCE VARIABLES ARE LISTED BELOW */
    
    private int xDimension;                              // x dimension of the window
    private int yDimension;                              // y dimension of the window
    
    //INSTIANTIATE
    
    private JFrame frame = new JFrame("Game");                  // frame
    private JPanel panel = new JPanel();                        // panel
    private Dice dice = new Dice();                             // dice
    private GameRules gr = new GameRules();
    private ArrayList<Square> squareList = new ArrayList<>();
    
    /* METHODS ARE LISTED BELOW: */
    
    /**
     * Constructor.
     *
     * @param the X dimension of the window
     * @param the Y dimension of the window
     */
    Board(int x , int y)
    {
        xDimension = x;
        yDimension = y;
        this.open();
    }
    
    /*
    /**
     * This method opens and initializes all applicable java swing tools.
     *
     * This method initializes: JFrame, JPanel, JButtons and Action Listener. For clarity, this method continues in the 'makeSquaresAndButtons'
     * method.
     */
    private void open()
    {
        //FRAME
        frame.setSize(xDimension,yDimension);                   // sets the dimensions of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // frame closes when close
        
        //PANEL
        frame.setContentPane(panel);                            // connects frame and panel
        panel.setLayout(new GridLayout(8,8));
        
        for(int i = 0 ; i < 64 ; i++)
        {
            JButton button = new JButton();
            Square s = new Square(button);
            squareList.add(s);
            panel.add(button);
        }
        
        frame.setVisible(true);//making the frame visible
    }
}