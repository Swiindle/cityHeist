public class Robber
{
    private int id;
    private int currentSquare;
    private boolean inJail = false;
    public Robber(int n)
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
    
    public boolean getInJail()
    {
        return inJail;
    }
    
    public void switchInJail()
    {
        if(inJail == false)
        {
            inJail = true;
        }
        else
        {
            inJail = false;
        }
    }
}
