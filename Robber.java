import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

public class Robber extends GameObject
{
    public Robber(int n, Square s)
    {
        super(n, s, new ImageIcon("art/robber.png"));
    }
}
