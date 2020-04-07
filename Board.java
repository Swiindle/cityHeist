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
    
    private static int xDimension;                              // x dimension of the window
    private static int yDimension;                              // y dimension of the window
    private final static int xSquares = 8;
    private final static int ySquares = 8;
    private final static int totalSquares = xSquares * ySquares;
    
    //INSTIANTIATE
    
    private JFrame frame = new JFrame("Game");                  // frame
    private JPanel gamePanel = new JPanel();                    // panel 1
    private JPanel infoPanel = new JPanel();                    // panel 2
    private GameRules gr = new GameRules();
    private Dice dice = new Dice(gr);                           // dice
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
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < totalSquares ; i++)
        {
            JButton button = new JButton();
            button.addActionListener(this);
            Square s = new Square(i,x,y,button);
            squareList.add(s);
            gamePanel.add(button);
            
            //System.out.println("added square " + i + " with coordinates: " + x + " " + y);
            if(x == 7)
            {
                x = -1;
                y++;
            }
            x++;
        }
        
        this.readLevelLayout();
        this.configureAdjacentTiles();
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
    
    /**
     * TODO: EXIT WHEN LEVEL SELECT IS TOO LARGE
     */
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
    
    /**
     * Configures the adjacent tiles
     */
    private void configureAdjacentTiles()
    {
        for(Square s1 : squareList)
        {
            if(s1.getGameObject() instanceof Selectable || s1.getGameObject() instanceof MovetoAble)
            {
                for(Square s2 : squareList)
                {
                    boolean top = (s1.getYPos() == s2.getYPos() -1 && s1.getXPos() == s2.getXPos());
                    boolean left = (s1.getXPos() == s2.getXPos() -1 && s1.getYPos() == s2.getYPos());
                    boolean right = (s1.getXPos() == s2.getXPos() +1 && s1.getYPos() == s2.getYPos());
                    boolean bottom = (s1.getYPos() == s2.getYPos() +1 && s1.getXPos() == s2.getXPos());
                    boolean all = (top || left || right || bottom);
                    
                    if(s2.getGameObject() instanceof Selectable && all)
                    {
                        s1.addAdjacent(s2);
                    }
                    if(s2.getGameObject() instanceof Building && all)
                    {
                        Road r = (Road) s1.getGameObject();
                        r.setCoinMode();
                    }
                }
            }
        }
        for(Square s : squareList)
        {
            s.setGameObject(s.getGameObject());
        }
    }
    
    public void actionPerformed(ActionEvent action)
    {
        for(Square s : squareList)
        {
            if(gr.getCurrentTurn() == TurnMode.ROBBERTURN)
            {
                System.out.println(TurnMode.ROBBERTURN);
                if(gr.getSelectedSquare() == gr.nullSquare && s.getJButton() == action.getSource() && s.getGameObject() instanceof Selectable && s.getGameObject() instanceof Baddie)
                {
                    System.out.println("selected square " + s.getID());
                    gr.setSelectedSquare(s);
                    s.select();
                }
                else
                {
                    if(s == gr.getSelectedSquare() && s.getJButton() == action.getSource())
                    {
                        gr.setSelectedSquare(gr.nullSquare);
                        s.select();
                    }
                    else if(s != gr.getSelectedSquare() && gr.getSelectedSquare() != gr.nullSquare && s.getJButton() == action.getSource() && s.getGameObject() instanceof MovetoAble)
                    {
                        gr.nextTurn();
                        gr.getSelectedSquare().select(); // unselect the previous one
                        gr.setSelectedSquare(gr.nullSquare);
                        System.out.println("MOVE HERE " + s.getID());
                    }
                }
            }
            else if(gr.getCurrentTurn() == TurnMode.COPTURN)
            {
                System.out.println(TurnMode.COPTURN);
                if(gr.getSelectedSquare() == gr.nullSquare && s.getJButton() == action.getSource() && s.getGameObject() instanceof Selectable && s.getGameObject() instanceof Goodie)
                {
                    gr.setSelectedSquare(s);
                    s.select();
                }
                else
                {
                    if(s == gr.getSelectedSquare() && s.getJButton() == action.getSource())
                    {
                        gr.setSelectedSquare(gr.nullSquare);
                        s.select();
                    }
                    else if(s != gr.getSelectedSquare() && gr.getSelectedSquare() != gr.nullSquare && s.getJButton() == action.getSource() && s.getGameObject() instanceof MovetoAble)
                    {
                        gr.nextTurn();
                        gr.getSelectedSquare().select(); // unselect the previous one
                        gr.setSelectedSquare(gr.nullSquare);
                        System.out.println("MOVE HERE " + s.getID());
                    }
                }
            }
        }
        System.out.println("///");
    }
}
