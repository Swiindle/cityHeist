import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

enum RobberMode
{
    ROBBER, ROBBERSELECT;
}

public class Robber extends GameObject implements Selectable
{
    public static final ImageIcon robber = new ImageIcon("art/robber.png");
    public static final ImageIcon robberSelect = new ImageIcon("art/robber-select.png");
    
    private boolean selected = false;
    private RobberMode mode;
    
    public Robber(int n)
    {
        super(n, new ImageIcon("art/robber.png"));
        mode = RobberMode.ROBBER;
    }
    
    @Override
    public ImageIcon getImageIcon()
    {
        switch(mode)
        {
            default:
                return robber;
            case ROBBER:
                return robber;
            case ROBBERSELECT:
                return robberSelect;
        }
    }
    
    public void select()
    {
        if(!selected)
        {
            mode = RobberMode.ROBBERSELECT;
            selected = true;
        }
        else
        {
            mode = RobberMode.ROBBER;
            selected = false;
        }
    }
}
