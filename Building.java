import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

public class Building extends GameObject
{
    private boolean robbed = false;
    private int id;
    
    public Building(int n)
    {
        super(new ImageIcon("art/building.png"));
        this.id = n;
    }
}
