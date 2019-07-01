public class Square
{
    private int number;
    private String holds = "empty";
    private boolean selected = false;
    
    public Square(int n)
    {
        number = n;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public void setSquare(String s)
    {
        if(s.equals("empty") == true)
        {
            holds = "empty";
        }
        else if(s.equals("cop") == true)
        {
            holds = "cop";
        }
        else if(s.equals("robber") == true)
        {
            holds = "robber";
        }
        else if(s.equals("building") == true)
        {
            holds = "building";
        }
        else if(s.equals("path") == true)
        {
            holds = "path";
        }
        else
        {
            System.out.println("set Square not avalible");
        }
    }
}
