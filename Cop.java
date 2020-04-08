import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

enum CopMode
{
    COP, COPSELECT;
}

public class Cop extends GameObject implements Selectable, Goodie
{
    public static final ImageIcon cop = new ImageIcon("art/cop.png");
    public static final ImageIcon copSelect = new ImageIcon("art/cop-selected.png");
    
    private boolean selected = false;
    private CopMode mode;
    
    public Cop()
    {
        super(cop,'C');
        mode = CopMode.COP;
    }
    
    @Override
    public ImageIcon getImageIcon()
    {
        switch(mode)
        {
            default:
                return cop;
            case COP:
                return cop;
            case COPSELECT:
                return copSelect;
        }
    }
    
    public void select()
    {
        if(!selected)
        {
            mode = CopMode.COPSELECT;
            selected = true;
        }
        else
        {
            mode = CopMode.COP;
            selected = false;
        }
    }
    
    public void capture(Baddie b, GameRules gr)
    {
        b.captured(gr);
    }
}
