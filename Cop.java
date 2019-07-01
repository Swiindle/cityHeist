public class Cop
{
    private int id;
    private int currentSquare;
    
    public Cop(int n)
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
}
