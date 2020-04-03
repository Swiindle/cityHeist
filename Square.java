import javax.swing.*; // #includes JFrame

public class Square
{
    private int id;
    private JButton button;
    private GameObject holds;
    
    public Square(int id, JButton button)
    {
        this.id = id;
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
            System.out.println("here");
            holds.select();
            button.setIcon(holds.getImageIcon());
        }
        else if(holds instanceof Cop)
        {
            System.out.println("here2");
            holds.select();
            button.setIcon(holds.getImageIcon());
        }
        else if(holds instanceof Robber)
        {
            System.out.println("here3");
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
}
