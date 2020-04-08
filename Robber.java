import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

enum RobberMode
{
    ROBBER, ROBBERSELECT;
}

public class Robber extends GameObject implements Selectable, Baddie
{
    public static final ImageIcon robber = new ImageIcon("art/robber.png");
    public static final ImageIcon robberSelect = new ImageIcon("art/robber-select.png");
    
    private boolean selected = false;
    private int id;
    private RobberMode mode;
    
    public Robber(int n)
    {
        super(robber);
        this.id = n;
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
    
    public void captured(GameRules gr)
    {
        gr.caught();
    }
    
    public void rob(GameRules gr)
    {
        gr.rob(1);
    }
}
