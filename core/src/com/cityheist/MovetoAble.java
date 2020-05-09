package com.cityheist;

/**
 * This interface is meant for classes which pieces can be moved to. E.g a Road. It was written for classes extending GameObject in mind.
 */
public interface MovetoAble
{
    /**
     * Call this method to highlight to player which GameObjects they can move to.
     */
    public void highlightMove();
}
