package com.cityheist;

import com.badlogic.gdx.graphics.Texture;
import javax.swing.*; // #includes JFrame

/**
 * Abstract class representing any noun within the game. E.g A Cop would be considered a GameObject.
 */
public abstract class GameObject
{
    private Texture texture;
    private static char levelCreatorCode;
    
    /**
     * Constructor.
     * @param texture The Image that this GameObject should have at default.
     * @param levelCreatorCode A charecter that represents this GameObject, will be used when drawing the level.
     */
    public GameObject(Texture texture, char levelCreatorCode)
    {
        this.texture = texture;
        this.levelCreatorCode = levelCreatorCode;
    }
    
    /**
     * Returns this GameObject's image.
     * @return The GameObject's imageIcon.
     */
    public Texture getImageIcon()
    {
        return texture;
    }
    
    /**
     * Returns this GameObject's levelCreatorCode.
     * @return charecter representing this GameObject within the level loader.
     */
    public char getLevelCreatorCode()
    {
        return levelCreatorCode;
    }
    
    /**
     * Doesn't do anything when called.
     */
    public void select()
    {
        
    }
}
