public class Building
{
    private int currentSquare;
    private int id;
    private boolean robbed = false;
    
    public Building(int n)
    {
        id = n;
    }
    
    public int getid()
    {
        return id;
    }
    
    public int getSquare()
    {
        return currentSquare;
    }
    
    public void changeSquare(int n)
    {
        currentSquare = n;
    }
    
    public boolean getRobbed()
    {
        return robbed;
    }
    
    public void switchRobbed()
    {
        if(robbed == false)
        {
            robbed = true;
        }
        else
        {
            robbed = false;
        }
    }
}
