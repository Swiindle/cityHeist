import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

public class Grass extends GameObject
{
    public Grass(int n)
    {
        super(n, new ImageIcon("art/grass.png"));
    }
}