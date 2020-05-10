package com.cityheist;

import com.badlogic.gdx.graphics.Texture;

import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

enum RoadMode
{
    ROAD, ROADSELECT, COIN, COINSELECT;
}

/**
 * This class represents a Road within the game, which pieces can travel to.
 */
public class Road extends GameObject implements MovetoAble
{
    public static final Texture roadNormal = new Texture("art/road.png");
    public static final Texture roadSelect = new Texture("art/road-select.png");
    public static final Texture coin = new Texture("art/coin.png");
    public static final Texture coinSelect = new Texture("art/coin-select.png");
    
    private boolean selected = false;
    private RoadMode mode;
    
    /**
     * Constructor.
     */
    public Road()
    {
        super(roadNormal,'1');
        mode = RoadMode.ROAD;
    }
    
    /**
     * Sets the road to normal mode (coinless)
     */
    public void setNormalMode()
    {
        mode = RoadMode.ROAD;
    }
    
    /**
     * Gives this Road tile a coin - which informs players where they can land to rob buildings.
     */
    public void setCoinMode()
    {
        mode = RoadMode.COIN;
    }
    
    /**
     * This method can be used to return the Road's image, for game display purpouses.
     * It will return a different image depending on the Road's current state.
     * @return The ImageIcon that contains the graphic of the road.
     */
    @Override
    public Texture getImageIcon()
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
    
    /**
     * A method that returns this Road's current mode.
     * @return the Road mode.
     */
    public RoadMode getRoadMode()
    {
        return mode;
    }
    
    /**
     * This method toggles the selection / deselection of this Road. If this Road is selected, it will have
     * a red border around the square. If not, it won't.
     */
    public void select()
    {
        this.highlightMove();
    }
    
    /**
     * This method toggles the selection / deselection of this Road. If this Road is selected, it will have
     * a red border around the square. If not, it won't.
     */
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
}
