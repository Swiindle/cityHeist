import javax.swing.*; // #includes JFrame
import java.util.*;

public class Square
{
    private int id;
    private int xPos;
    private int yPos;
    private JButton button;
    private GameObject holds;
    private ArrayList<Square> adjacentList = new ArrayList<>();
    
    public Square(int id, int x, int y, JButton button)
    {
        this.id = id;
        this.xPos = x;
        this.yPos = y;
        this.button = button;
    }
    
    public int getID()
    {
        return id;
    }
    
    public JButton getJButton()
    {
        return button;
    }
    
    public void select()
    {
        if(holds instanceof Road)
        {
            holds.select();
            button.setIcon(holds.getImageIcon());
        }
        else if(holds instanceof Cop)
        {
            holds.select();
            button.setIcon(holds.getImageIcon());
        }
        else if(holds instanceof Robber)
        {
            holds.select();
            button.setIcon(holds.getImageIcon());
        }
    }
    
    public void setGameObject(GameObject go)
    {
        holds = go;
        button.setIcon(go.getImageIcon());
    }
    
    public GameObject getGameObject()
    {
        return holds;
    }
    
    public void addAdjacent(Square s)
    {
        adjacentList.add(s);
    }
    
    public ArrayList<Square> getAdjacentList()
    {
        return adjacentList;
    }
    
    public int getXPos()
    {
        return xPos;
    }
    
    public int getYPos()
    {
        return yPos;
    }
}
