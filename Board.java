/**
 * This is the Board class. This class is in charge of implementing all types of java swing. And representing a real life checkers board.
 */

import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels
import java.awt.event.*; // #includes action listener

public class Board
{
    /* INSTANCE VARIABLES ARE LISTED BELOW */
    
    private int xDimension;                                         // x dimension of the window
    private int yDimension;                                         // y dimension of the window
    
    //INSTIANTIATE
    
    private JFrame frame = new JFrame("Checkers");                  // frame
    private JPanel panel = new JPanel();                            // panel
    private GridLayout layout = new GridLayout(8,8);                // gridlayout, 8x8
    private JButton[] b = new JButton[64];                          // 64 buttons
    //private Square[] s = new Square[64];                            // 64 Squares
    
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
    }
    
    /*
    /**
     * This method opens and initializes all applicable java swing tools.
     *
     * This method initializes: JFrame, JPanel, JButtons and Action Listener. For clarity, this method continues in the 'makeSquaresAndButtons'
     * method.
     */
    public void open()
    {
        //FRAME
        frame.setSize(xDimension,yDimension);                   // sets the dimensions of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // frame closes when close
        
        //PANEL
        frame.setContentPane(panel);                            // connects frame and panel
        panel.setLayout(layout);                                // connects the panel and the layout
        //BUTTON & Square
        
        //ACTION LISTENER
        /*for(int i = 0 ; i < 64 ; i++)
        {
            b[i].addActionListener(this);
        }*/
        //GO
        frame.setVisible(true);                                 // makes frame visible
    }
}
