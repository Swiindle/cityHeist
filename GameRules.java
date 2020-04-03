import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels


public class GameRules
{
    // Counts
    
    public static int grassCount = 0;
    public static int roadCount = 0;
    public static int robberCount = 0;
    public static int copCount = 0;
    public static int buildingCount = 0;
    
    public final static Square nullSquare = new Square(-1, new JButton());
    private Square currentSelectedSquare = nullSquare;

    private boolean robberTurn = true;
    //private boolean robberWin = false;
    //private boolean copWin = false;
    private int numberCaught = 0;
    private int robberMoney = 0;
    private final static int maxMoney = 10;
    private final static int maxCaught = 4;
    
    public void reset()
    {
        robberTurn = true;
        numberCaught = 0;
        robberMoney = 0;
    }
    
    public void setSelectedSquare(Square s)
    {
        currentSelectedSquare = s;
    }
    
    public boolean getRobberTurn()
    {
        return robberTurn;
    }
    
    public Square getSelectedSquare()
    {
        return currentSelectedSquare;
    }
    
    /**
    public void switchTurn()
    {
        if(robberTurn == true)
        {
            robberTurn = false;
        }
        else
        {
            robberTurn = true;
        }
    }
    
    public boolean copWin()
    {
        if(numberCaught == maxCaught)
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
        if(robberMoney > maxMoney)
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
    }
    
    public void rob(int n)
    {
        robberMoney+=n;
    }*/
}
