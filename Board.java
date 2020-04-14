import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels
import java.awt.event.*; // #includes action listener
import java.util.*;
import java.io.*;

/**
 * This class represents the game Board, which holds the rules for the game and all of its pieces.
 */
public class Board implements ActionListener
{
    /* INSTANCE VARIABLES ARE LISTED BELOW */
    
    private static int xDimension;                              // x dimension of the window
    private static int yDimension;                              // y dimension of the window
    private final static int xSquares = 8;
    private final static int ySquares = 8;
    private final static int totalSquares = xSquares * ySquares;
    
    //INSTIANTIATE
    
    private CardLayout gameLayout = new CardLayout();
    
    private JPanel mainGame = new JPanel();
    private JPanel copWinScreen = new JPanel();
    private JPanel robberWinScreen = new JPanel();
    
    private JFrame frame = new JFrame("CityHeist");                  // frame
    private JPanel gamePanel = new JPanel();                    // panel 1
    private JPanel infoPanel = new JPanel();                    // panel 2
    private GameRules gr = new GameRules();
    private Dice dice = new Dice(this,gr);                           // dice
    private ArrayList<Square> squareList = new ArrayList<>();
    private SquareGraph graph = new SquareGraph();
    
    /* METHODS ARE LISTED BELOW: */
    
    /**
     * Constructor. Opens the game when this class is instantiated.
     *
     * @param the X dimension of the game window
     * @param the Y dimension of the game window
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
        frame.setLayout(gameLayout);
        
        // GAME PANEL
        gamePanel.setLayout(new GridLayout(this.xSquares,this.ySquares));
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
        
        // INFO PANEL
        infoPanel.setLayout(new GridLayout(0,3));
        infoPanel.setBackground(Color.YELLOW);
        
        //JLabel turnTrackerIcon;
        
        JLabel turnTrackerLabel = new JLabel("TEST1");
        infoPanel.add(turnTrackerLabel);
        
        //JLabel turnTrackerIcon;
    
        JLabel copObjectiveLabel = new JLabel("TEST2");
        infoPanel.add(copObjectiveLabel);
        
        //JLabel turnTrackerIcon;
        
        JLabel robberObjectiveLabel = new JLabel("TEST3");
        infoPanel.add(robberObjectiveLabel);
        
        gr.setLabels(turnTrackerLabel,copObjectiveLabel,robberObjectiveLabel);
        
        // THE REST //
        
        mainGame.setLayout(new BorderLayout());
        mainGame.add(gamePanel, BorderLayout.CENTER);
        mainGame.add(infoPanel, BorderLayout.NORTH);
        
        JLabel robberWinText = new JLabel(new ImageIcon("art/robberWinImage.png"));
        robberWinScreen.add(robberWinText,BorderLayout.CENTER);
        
        JLabel copWinText = new JLabel(new ImageIcon("art/copWinImage.png"));
        copWinScreen.add(copWinText,BorderLayout.CENTER);

        
        frame.setContentPane(mainGame);
        frame.setVisible(true);//making the frame visible
    }
    
    /**
     * TODO: EXIT WHEN LEVEL SELECT IS TOO LARGE
     */
    private void readLevelLayout()
    {
        ArrayList<Character> gameObjectlevelCodes = new ArrayList<>();
        Hashtable<Character,String> gameObjectHashMap = new Hashtable<>();
        
        try
        {
            File f = new File("data/GameObjectClasses.txt");
            Scanner fileReader = new Scanner(f);
            while(fileReader.hasNextLine())
            {
                String className = fileReader.nextLine();
                GameObject go = (GameObject) Class.forName(className).newInstance();
                char code = go.getLevelCreatorCode();
                String gameObjectName = Class.forName(className).getSimpleName();
                gameObjectlevelCodes.add(code);
                gameObjectHashMap.put(code,gameObjectName);
            }
            
            for(int i = 0 ; i < LevelLayout.level.length() ; i++)
            {
                Square s = squareList.get(i);
                char levelCode = LevelLayout.level.charAt(i);
                
                String gameObjectName = gameObjectHashMap.get(levelCode);
                GameObject go = (GameObject) Class.forName(gameObjectName).newInstance();
                if(go instanceof Baddie)
                {
                    gr.robberCount++;
                }
                if(go instanceof Goodie)
                {
                    gr.copCount++;
                }
                if(go instanceof Building)
                {
                    gr.buildingCount++;
                }
                s.setGameObject(go);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        /**
        for(int i = 0 ; i < LevelLayout.level.length() ; i++)
        {
            Square s = squareList.get(i);
            if(LevelLayout.level.charAt(i) == "0".charAt(0))
            {
                s.setGameObject(new Grass());
            }
            else if(LevelLayout.level.charAt(i) == "1".charAt(0))
            {
                s.setGameObject(new Road());
            }
            else if(LevelLayout.level.charAt(i) == "C".charAt(0))
            {
                s.setGameObject(new Cop());
                gr.copCount++;
            }
            else if(LevelLayout.level.charAt(i) == "R".charAt(0))
            {
                s.setGameObject(new Robber());
                gr.robberCount++;
            }
            else if(LevelLayout.level.charAt(i) == "B".charAt(0))
            {
                s.setGameObject(new Building());
                gr.buildingCount++;
            }
        }*/
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
                    if((s2.getGameObject() instanceof MovetoAble || s2.getGameObject() instanceof Selectable) && this.squareAdjacentTo(s1,s2))
                    {
                        s1.addAdjacent(s2);
                    }
                    if(s2.getGameObject() instanceof Building && this.squareAdjacentTo(s1,s2))
                    {
                        Building building = (Building) s2.getGameObject();
                        if(!building.getRobbed())
                        {
                            Road r = (Road) s1.getGameObject();
                            r.setCoinMode();
                        }
                        else
                        {
                            Road r = (Road) s1.getGameObject();
                            r.setNormalMode();
                        }
                    }
                }
            }
        }
        for(Square s : squareList)
        {
            s.setGameObject(s.getGameObject());
        }
    }
    
    /**
     * This method is called whenever a JButton on the Board is pressed.
     * @param action The action that called this method.
     */
    public void actionPerformed(ActionEvent action)
    {
        int diceValue = dice.getRollValue();
        if(!dice.getDiceMode())
        {
            for(Square s : squareList)
            {
                if(gr.getCurrentTurn() == TurnMode.ROBBERTURN)
                {
                    if(gr.getSelectedSquare() == gr.nullSquare && s.getJButton() == action.getSource() && s.getGameObject() instanceof Selectable && s.getGameObject() instanceof Baddie)
                    {
                        gr.setSelectedSquare(s);
                        this.highlightMoves(traverseGraph(s,diceValue),s);
                    }
                    else
                    {
                        // the player clicks on the selected square again = go back to normal state
                        if(s == gr.getSelectedSquare() && s.getJButton() == action.getSource())
                        {
                            gr.setSelectedSquare(gr.nullSquare);
                            this.highlightMoves(traverseGraph(s,diceValue),s);
                        }
                        // player clicks on a square that is movable to = move to that square
                        else if(s != gr.getSelectedSquare() && gr.getSelectedSquare() != gr.nullSquare && s.getJButton() == action.getSource() && traverseGraph(gr.getSelectedSquare(),diceValue).contains(s) && (s.getGameObject() instanceof MovetoAble || s.getGameObject() instanceof Selectable))
                        {
                            gr.nextTurn();
                            this.highlightMoves(traverseGraph(gr.getSelectedSquare(),diceValue),s); // unselect the previous one
                            this.moveTiles(gr.getSelectedSquare(),s);
                            gr.setSelectedSquare(gr.nullSquare);
                        }
                    }
                }
                else if(gr.getCurrentTurn() == TurnMode.COPTURN)
                {
                    if(gr.getSelectedSquare() == gr.nullSquare && s.getJButton() == action.getSource() && s.getGameObject() instanceof Selectable && s.getGameObject() instanceof Goodie)
                    {
                        gr.setSelectedSquare(s);
                        this.highlightMoves(traverseGraph(s,diceValue),s);
                    }
                    else
                    {
                        if(s == gr.getSelectedSquare() && s.getJButton() == action.getSource())
                        {
                            gr.setSelectedSquare(gr.nullSquare);
                            this.highlightMoves(traverseGraph(s,diceValue),s);
                        }
                        else if(s != gr.getSelectedSquare() && gr.getSelectedSquare() != gr.nullSquare && s.getJButton() == action.getSource() && traverseGraph(gr.getSelectedSquare(),diceValue).contains(s) && (s.getGameObject() instanceof MovetoAble || s.getGameObject() instanceof Selectable))
                        {
                            gr.nextTurn();
                            this.highlightMoves(traverseGraph(gr.getSelectedSquare(),diceValue),s); // unselect the previous one
                            this.moveTiles(gr.getSelectedSquare(),s);
                            gr.setSelectedSquare(gr.nullSquare);
                        }
                    }
                }
            }
        }
        
        this.checkWin();
    }
    
    /**
    * Assuming that Square s is an instanceof Selectable and s1 is an instance of moveto
    */
    private void highlightMoves(ArrayList<Square> moveList, Square s)
    {
        for(Square s1: moveList)
        {
            s1.select();
        }
        s.select();
    }
    
    /**
     *
     * @param s
     * @param dice
     */
    private ArrayList<Square> traverseGraph(Square s, int dice)
    {
        ArrayList<Square> movetoAbleList = graph.traverseGraph(s,dice);
        return movetoAbleList;
    }
    
    private void moveTiles(Square a, Square b)
    {
        //System.out.println("Moving " + a.getID() + " to " + b.getID());
        
        if(a.getGameObject() instanceof Baddie && b.getGameObject() instanceof Goodie)
        {
            //b.getGameObject().capture(b.getGameObject(),gr);
            Cop cop = (Cop) b.getGameObject();
            cop.capture( (Robber) a.getGameObject(),gr);
        }
        else if(b.getGameObject() instanceof Baddie && a.getGameObject() instanceof Goodie)
        {
            //a.getGameObject().capture(b.getGameObject(),gr);
            Cop cop = (Cop) a.getGameObject();
            cop.capture( (Robber) b.getGameObject(),gr);
        }
        
        if(a.getGameObject() instanceof Baddie && b.getGameObject() instanceof Road)
        {
            Road r = (Road) b.getGameObject();
            if(r.getRoadMode() == RoadMode.COIN || r.getRoadMode() == RoadMode.COINSELECT)
            {
                //a.getGameObject().rob(gr);
                Robber rob = (Robber) a.getGameObject();
                rob.rob(gr);
                for(Square s : squareList)
                {
                    if(s.getGameObject() instanceof Building && this.squareAdjacentTo(s,b))
                    {
                        Building building = (Building) s.getGameObject();
                        building.robBuilding();
                    }
                }
            }
        }
        
        a.moveGameObjectToSquare(b);
        b.select();
        
        for(Square s1 : squareList)
        {
            if(s1.getGameObject() instanceof MovetoAble)
            {
                for(Square s2 : squareList)
                {
                    if(s2.getGameObject() instanceof Building && this.squareAdjacentTo(s1,s2))
                    {
                        Building building = (Building) s2.getGameObject();
                        if(!building.getRobbed())
                        {
                            Road r = (Road) s1.getGameObject();
                            r.setCoinMode();
                        }
                        else
                        {
                            Road r = (Road) s1.getGameObject();
                            r.setNormalMode();
                        }
                    }
                }
            }
        }
        for(Square s : squareList)
        {
            s.setGameObject(s.getGameObject());
        }
        
        dice.roll();
        dice.setDiceModeTrue();
    }
    
    private boolean squareAdjacentTo(Square a, Square b)
    {
        boolean top = (a.getYPos() == b.getYPos() -1 && a.getXPos() == b.getXPos());
        boolean left = (a.getXPos() == b.getXPos() -1 && a.getYPos() == b.getYPos());
        boolean right = (a.getXPos() == b.getXPos() +1 && a.getYPos() == b.getYPos());
        boolean bottom = (a.getYPos() == b.getYPos() +1 && a.getXPos() == b.getXPos());
        boolean all = (top || left || right || bottom);
        return all;
    }
    
    private void checkWin()
    {
        if(gr.copWin())
        {
            frame.setContentPane(copWinScreen);
        }
        else if(gr.robberWin())
        {
            frame.setContentPane(robberWinScreen);
        }
    }
}
