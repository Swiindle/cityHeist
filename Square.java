import javax.swing.*; // #includes JFrame

public class Square
{
    private JButton button;
    private GameObject holds;
    
    public Square(JButton button)
    {
        this.button = button;
        button.setIcon(holds.getImageIcon());
    }
    
    public JButton getJButton()
    {
        return button;
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
