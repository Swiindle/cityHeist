import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

enum RoadMode
{
    ROAD, ROADSELECT, COIN, COINSELECT;
}

public class Road extends GameObject implements MovetoAble
{
    public static final ImageIcon roadNormal = new ImageIcon("art/road.png");
    public static final ImageIcon roadSelect = new ImageIcon("art/road-select.png");
    public static final ImageIcon coin = new ImageIcon("art/coin.png");
    public static final ImageIcon coinSelect = new ImageIcon("art/coin-select.png");
    
    private boolean selected = false;
    private RoadMode mode;
    
    public Road()
    {
        super(roadNormal);
        mode = RoadMode.ROAD;
    }
    
    public void setCoinMode()
    {
        mode = RoadMode.COIN;
    }
    
    @Override
    public ImageIcon getImageIcon()
    {
        switch(mode)
        {
            default:
                return roadNormal;
            case ROAD:
                return roadNormal;
            case ROADSELECT:
                return roadSelect;
            case COIN:
                return coin;
            case COINSELECT:
                return coinSelect;
        }
    }
    
    public void select()
    {
        this.highlightMove();
    }
    
    public void highlightMove()
    {
        if(!selected)
        {
            if(mode == RoadMode.COIN)
            {
                mode = RoadMode.COINSELECT;
            }
            else if(mode == RoadMode.ROAD)
            {
                mode = RoadMode.ROADSELECT;
            }
            selected = true;
        }
        else
        {
            if(mode == RoadMode.COINSELECT)
            {
                mode = RoadMode.COIN;
            }
            else if(mode == RoadMode.ROADSELECT)
            {
                mode = RoadMode.ROAD;
            }
            selected = false;
        }
    }
    
    public void moveTo(MovetoAble moa)
    {
        
    }
}
