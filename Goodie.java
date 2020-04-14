/**
 * An interface that all "Good guy" classes should extend. This interface was written for classes extending GameObject in mind.
 */
public interface Goodie
{
    /**
     * This method should be called when a Goodie captures a Baddie.
     * @param b The Baddie which has been captured by this Goodie.
     * @param gr The Game Rule class representing the game logic.
     */
    public void capture(Baddie b, GameRules gr);
}
