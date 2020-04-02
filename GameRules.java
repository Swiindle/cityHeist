public class GameRules
{
    private boolean robberTurn = true;
    //private boolean robberWin = false;
    //private boolean copWin = false;
    private int numberCaught = 0;
    private int robberMoney = 0;
    private int maxMoney = 10;
    private int maxCaught = 4;
    
    public void reset()
    {
        robberTurn = true;
        numberCaught = 0;
        robberMoney = 0;
    }
    
    public boolean getRobberTurn()
    {
        return robberTurn;
    }
    
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
    }
}
