import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

public abstract class GameObject
{
    private ImageIcon icon;
    private int id;
    private Square currentSquare;
    
    public GameObject(int id, Square currentSquare, ImageIcon icon)
    {
        this.id = id;
        this.currentSquare = currentSquare;
        this.icon = icon;
    }
    
    public int getId()
    {
        return id;
    }
    
    public ImageIcon getImageIcon()
    {
        return icon;
    }
}
