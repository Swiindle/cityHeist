import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

public abstract class GameObject
{
    private ImageIcon icon;
    private static char levelCreatorCode;
    
    public GameObject(ImageIcon icon, char levelCreatorCode)
    {
        this.icon = icon;
        this.levelCreatorCode = levelCreatorCode;
    }
    
    public ImageIcon getImageIcon()
    {
        return icon;
    }
    
    public char getLevelCreatorCode()
    {
        return levelCreatorCode;
    }
    
    public void select()
    {
        
    }
}
