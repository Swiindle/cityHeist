import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

enum RobberMode
{
    ROBBER, ROBBERSELECT;
}

/**
 * This class represents a Robber within the game, which can rob Buildings and be captured by Cops.
 */
public class Robber extends GameObject implements Selectable, Baddie
{
    public static final ImageIcon robber = new ImageIcon("art/robber.png");
    public static final ImageIcon robberSelect = new ImageIcon("art/robber-select.png");
    
    private boolean selected = false;
    private int id;
    private RobberMode mode;
    
    /**
     * Constructor.
     */
    public Robber()
    {
        super(robber,'R');
        mode = RobberMode.ROBBER;
    }
    
    /**
     * This method can be used to return the Cop's image, for game display purpouses.
     * It will return a different image depending on the Cop's current state.
     * @return The ImageIcon that contains the graphic of the cop's state
     */
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
    
    /**
     * This method toggles the selection / deselection of this Cop. If this Cop is selected, it will have
     * a red border around the square. If not, it won't.
     */
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
    
    /**
     * Call this method when the Robber is captured by a Goodie.
     * @param gr The Game Rule class representing the game logic.
     */
    public void captured(GameRules gr)
    {
        gr.caught();
    }
    
    /**
     * Call this method when the Robber can rob a Building.
     * @param gr The Game Rule class representing the game logic.
     */
    public void rob(GameRules gr)
    {
        gr.rob(1);
    }
}
