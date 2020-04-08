import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

public class Building extends GameObject
{
    private boolean robbed = false;
    
    public Building()
    {
        super(new ImageIcon("art/building.png"),'B');
    }
}
