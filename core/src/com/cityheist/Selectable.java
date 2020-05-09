package com.cityheist;

/**
 * This interface is meant for classes which represents a game piece. E.g a Cop. It was written for classes extending GameObject in mind.
 */
public interface Selectable
{
    /**
     * This method should be called when the player intends to select a piece.
     */
    public void select();
}
