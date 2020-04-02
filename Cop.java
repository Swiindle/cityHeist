import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

public class Cop extends GameObject
{
    public Cop(int n, Square s)
    {
        super(n, s, new ImageIcon("art/cop.png"));
    }
}
