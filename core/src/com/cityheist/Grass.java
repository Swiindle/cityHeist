package com.cityheist;

import com.badlogic.gdx.graphics.Texture;

import javax.swing.*; // #includes JFrame
import java.awt.*; // #includes Java Panels

/**
 * This class represents a grass tile. Which has no other purpouse than to fill in the blank spaces.
 */
public class Grass extends GameObject
{
    /**
     * Constructor.
     */
    public Grass()
    {
        super(new Texture("art/grass.png"),'0');
    }
}
