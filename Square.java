import javax.swing.*; // #includes JFrame

public class Square
{
    private JButton button;
    private GameObject holds;
    
    public Square(JButton button)
    {
        this.button = button;
    }
    
    public JButton getJButton()
    {
        return button;
    }
    
    public void updateButton()
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
}
