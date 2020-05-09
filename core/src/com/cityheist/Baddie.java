package com.cityheist;

/**
 * An interface that all "Bad guy" classes should extend. This interface was written for classes extending GameObject in mind.
 */
public interface Baddie
{
    /**
     * This method should be called when the the Baddie has been captured.
     * @param gr The Game Rule class representing the game logic.
     */
    public void captured(GameRules gr);
    
    /**
     * This method should be called when the the Baddie has robbed.
     * @param gr The Game Rule class representing the game logic.
     */
    public void rob(GameRules gr);
}
