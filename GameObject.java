import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

public abstract class GameObject
{
    private ImageIcon icon;
    
    public GameObject(ImageIcon icon)
    {
        this.icon = icon;
    }
    
    public ImageIcon getImageIcon()
    {
        return icon;
    }
    
    public void select()
    {
        
    }
}
