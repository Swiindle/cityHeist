/**
 * This is the Board class. This class is in charge of implementing all types of java swing. And representing a real life checkers board.
 */
import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels
import java.awt.event.*; // #includes action listener
import java.util.*;

public class Board implements ActionListener
{
    /* INSTANCE VARIABLES ARE LISTED BELOW */
    
    private int xDimension;                              // x dimension of the window
    private int yDimension;                              // y dimension of the window
    
    //INSTIANTIATE
    
    private JFrame frame = new JFrame("Game");                  // frame
    private JPanel gamePanel = new JPanel();                    // panel 1
    private JPanel infoPanel = new JPanel();                    // panel 2
    private Dice dice = new Dice();                             // dice
    private GameRules gr = new GameRules();
    private ArrayList<Square> squareList = new ArrayList<>();
    //private HashMap<Square,int[]>  squareCoordinates = new HashMap<>();
    
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
     * This method initializes: JFrame, JPanel, JButtons and Action Listener.
     * method.
     */
    private void open()
    {
        //FRAME
        frame.setSize(xDimension,yDimension);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // frame closes when close
        frame.setResizable(false);

        // GAME PANEL
        gamePanel.setLayout(new GridLayout(8,8));
        for(int i = 0 ; i < 64 ; i++)
        {
            JButton button = new JButton();
            button.addActionListener(this);
            Square s = new Square(i,button);
            squareList.add(s);
            gamePanel.add(button);
        }
        this.readLevelLayout();
        frame.add(gamePanel, BorderLayout.CENTER);
        
        // INFO PANEL
        infoPanel.setLayout(new GridLayout(0,3));
        infoPanel.setBackground(Color.YELLOW);
        JLabel label1 = new JLabel("TEST1");
        infoPanel.add(label1);
        JLabel label2 = new JLabel("TEST2");
        infoPanel.add(label2);
        JLabel label3 = new JLabel("TEST3");
        infoPanel.add(label3);
        frame.add(infoPanel, BorderLayout.NORTH);
        
        frame.setVisible(true);//making the frame visible
    }
    
    private void readLevelLayout()
    {
        for(int i = 0 ; i < LevelLayout.level.length() ; i++)
        {
            Square s = squareList.get(i);
            if(LevelLayout.level.charAt(i) == "0".charAt(0))
            {
                s.setGameObject(new Grass(gr.grassCount));
                gr.grassCount++;
            }
            else if(LevelLayout.level.charAt(i) == "1".charAt(0))
            {
                s.setGameObject(new Road(gr.roadCount));
                gr.roadCount++;
            }
            else if(LevelLayout.level.charAt(i) == "C".charAt(0))
            {
                s.setGameObject(new Cop(gr.copCount));
                gr.copCount++;
            }
            else if(LevelLayout.level.charAt(i) == "R".charAt(0))
            {
                s.setGameObject(new Robber(gr.robberCount));
                gr.robberCount++;
            }
            else if(LevelLayout.level.charAt(i) == "B".charAt(0))
            {
                s.setGameObject(new Building(gr.buildingCount));
                gr.buildingCount++;
            }
        }
    }
    
    public void actionPerformed(ActionEvent action)
    {
        for(Square s : squareList)
        {
            if(gr.getSelectedSquare() == gr.nullSquare && s.getJButton() == action.getSource())
            {
                gr.setSelectedSquare(s);
                s.select();
                System.out.println("Square " + s.getID() + " has been selected");
                System.out.println("Gamerules " + gr.getSelectedSquare().getID());
            }
            else
            {
                if(s == gr.getSelectedSquare() && s.getJButton() == action.getSource())
                {
                    gr.setSelectedSquare(gr.nullSquare);
                    s.select();
                    
                    System.out.println("Square " + s.getID() + " has been unselected");
                    System.out.println("Gamerules " + gr.getSelectedSquare().getID());
                }
            }
        }
    }
}
