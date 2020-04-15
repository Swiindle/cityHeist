import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

/**
 * This class represents a Building within the game, which can be robbed.
 */
public class Building extends GameObject
{
    private boolean robbed = false;
    
    /**
     * Constructor.
     */
    public Building()
    {
        super(new ImageIcon("art/building-" + "1" + ".png"),'B');
    }
    
    /**
     * Sets the boolean variable "robbed" to be true. The variable is robbed by default.
     */
    public void robBuilding()
    {
        robbed = true;
    }
    
    /**
     * Returns the robbed variable boolean.
     * @return True or false depending on whether the building has been robbed.
     */
    public boolean getRobbed()
    {
        return robbed;
    }
}
