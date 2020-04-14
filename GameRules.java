import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

enum TurnMode
{
    ROBBERTURN,COPTURN;
}

/**
 * This class contains all the necessary variables and methods that the game may need to have.
 */
public class GameRules
{
    // Counts //
    
    public static int grassCount = 0;
    public static int roadCount = 0;
    public static int robberCount = 0;
    public static int copCount = 0;
    public static int buildingCount = 0;
    
    // Constants //
    public final static Square nullSquare = new Square(-1, -1, -1, new JButton()); // this square is used as a placeholder when there are no squares selected.
    private Square currentSelectedSquare = nullSquare; // the current square, which is the nullsquare by default.
    private final static int maxMoney = 10;
    private final static int maxCaught = 4;
    
    // Game Rule Variables //
    private boolean robberWin = false;
    private boolean copWin = false;
    private int numberCaught = 0;
    private int robberMoney = 0;
    private TurnMode turn = TurnMode.ROBBERTURN;
    
    // Label Control //
    
    JLabel turnTrackerLabel;
    JLabel copObjectiveLabel;
    JLabel robberObjectiveLabel;
    
    public void setLabels(JLabel turnLabel, JLabel copLabel, JLabel robberLabel)
    {
        this.turnTrackerLabel = turnLabel;
        this.copObjectiveLabel = copLabel;
        this.robberObjectiveLabel = robberLabel;
        
        turnTrackerLabel.setText("Current turn: ROBBERS");
        copObjectiveLabel.setText("Robbers Caught: 0 / " + robberCount);
        robberObjectiveLabel.setText("Buildings Robbed: 0 / " + buildingCount);
    }
    
    /*public void reset()
    {
        robberTurn = true;
        numberCaught = 0;
        robberMoney = 0;
    }*/
    
    public void setSelectedSquare(Square s)
    {
        currentSelectedSquare = s;
    }
    
    public Square getSelectedSquare()
    {
        return currentSelectedSquare;
    }
    
    public TurnMode getCurrentTurn()
    {
        return turn;
    }
    
    public void nextTurn()
    {
        if(turn == TurnMode.COPTURN)
        {
            turn = TurnMode.ROBBERTURN;
            turnTrackerLabel.setText("Current turn: ROBBERS");
        }
        else
        {
            turn = TurnMode.COPTURN;
            turnTrackerLabel.setText("Current turn: COPS");
        }
    }

    public boolean copWin()
    {
        if(numberCaught >= robberCount)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean robberWin()
    {
        if(robberMoney >= buildingCount)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void caught()
    {
        numberCaught++;
        copObjectiveLabel.setText("Robbers Caught: " + numberCaught +  " / " + robberCount);
    }
    
    public void rob(int n)
    {
        robberMoney+=n;
        robberObjectiveLabel.setText("Buildings Robbed: " + robberMoney + " / " + buildingCount);
    }
}
