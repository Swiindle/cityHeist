import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

/**
 * Abstract class representing any noun within the game. E.g A Cop would be considered a GameObject.
 */
public abstract class GameObject
{
    private ImageIcon icon;
    private static char levelCreatorCode;
    
    /**
     * Constructor.
     * @param icon The Image that this GameObject should have at default.
     * @param levelCreatorCode A charecter that represents this GameObject, will be used when drawing the level.
     */
    public GameObject(ImageIcon icon, char levelCreatorCode)
    {
        this.icon = icon;
        this.levelCreatorCode = levelCreatorCode;
    }
    
    /**
     * Returns this GameObject's image.
     * @return The GameObject's imageIcon.
     */
    public ImageIcon getImageIcon()
    {
        return icon;
    }
    
    /**
     * Returns this GameObject's levelCreatorCode.
     * @return charecter representing this GameObject within the level loader.
     */
    public char getLevelCreatorCode()
    {
        return levelCreatorCode;
    }
    
    /**
     * Doesn't do anything when called.
     */
    public void select()
    {
        
    }
}
