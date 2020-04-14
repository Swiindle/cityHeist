import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

/**
 * The modes that an instance of a Cop can have.
 */
enum CopMode
{
    COP, COPSELECT;
}

/**
 * This class represents a Cop within the game, who can capture Bad guys.
 */
public class Cop extends GameObject implements Selectable, Goodie
{
    private static final ImageIcon cop = new ImageIcon("art/cop.png");
    private static final ImageIcon copSelect = new ImageIcon("art/cop-selected.png");
    
    private boolean selected = false;
    private CopMode mode;
    
    /**
     * Constructor.
     */
    public Cop()
    {
        super(cop,'C');
        mode = CopMode.COP;
    }
    
    /**
     * This method can be used to return the Cop's image, for game display purpouses.
     * It will return a different image depending on the Cop's current state.
     * @return The ImageIcon that contains the graphic of the Cop.
     */
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
    
    /**
     * This method toggles the selection / deselection of this Cop. If this Cop is selected, it will have
     * a red border around the square. If not, it won't.
     */
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
    
    /**
     * This method allows the cop to capture any instance of a Baddie class, which will then update
     * the game rules to reflec that change.
     * @param b The baddie that the Cop has captured.
     * @param gr The Game Rule class representing the game logic.
     */
    public void capture(Baddie b, GameRules gr)
    {
        b.captured(gr);
    }
}
