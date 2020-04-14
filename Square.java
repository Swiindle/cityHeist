import javax.swing.*; // #includes JFrame
import java.util.*;

/**
 * This class represents a tile on the board within the game.
 */
public class Square
{
    private int id;
    private int xPos;
    private int yPos;
    private JButton button;
    private GameObject holds;
    private ArrayList<Square> adjacentList = new ArrayList<>();
    
    /**
     * Constructor.
     * @param id An integer value representing this Square's id value.
     * @param x An integer value representing this Square's x coordinate on the board.
     * @param y An integer value representing this Square's y coordinate on the board.
     * @param button The JButton that graphically represents this Square.
     */
    public Square(int id, int x, int y, JButton button)
    {
        this.id = id;
        this.xPos = x;
        this.yPos = y;
        this.button = button;
    }
    
    /**
     * A method that returns this Square's id.
     * @return This Square's id.
     */
    public int getID()
    {
        return id;
    }
    
    /**
     * A method that returns this Square's JButton.
     * @return This Square's JButton.
     */
    public JButton getJButton()
    {
        return button;
    }
    
    /**
     * This method toggles the selection / deselection of the GameObject that it is holding.
     */
    public void select()
    {
        if(holds instanceof MovetoAble)
        {
            holds.select();
            button.setIcon(holds.getImageIcon());
        }
        else if(holds instanceof Selectable)
        {
            holds.select();
            button.setIcon(holds.getImageIcon());
        }
    }
    
    /**
     * Sets the GameObject this Square is holding to the one in the parameter.
     * @param go The GameObject that this Square will now hold.
     */
    public void setGameObject(GameObject go)
    {
        holds = go;
        button.setIcon(go.getImageIcon());
    }
    
    /**
     * A method that returns the GameObject held by this Square.
     * @return The GameObject being held by this Square.
     */
    public GameObject getGameObject()
    {
        return holds;
    }
    
    /**
     * Adds a Square that is adjacent to this one to this Square's adjacent list.
     * @param s This Square's id.
     */
    public void addAdjacent(Square s)
    {
        adjacentList.add(s);
    }
    
    /**
     * A method that returns an ArrayList containing all adjacent Squares to this one.
     * This method is best used for Graph operations.
     * @return The list contains adjacent Squares.
     */
    public ArrayList<Square> getAdjacentList()
    {
        return adjacentList;
    }
    
    /**
     * This method checks whether the Square in the parameter is within the adjacentList of this Square,
     * returning true or false depending on the Square.
     * @param s The Square to be checked whether it is in the adjacentList.
     * @return Boolean true or false depending on whether the Square is in the adjacentList.
     */
    public boolean isAdjacentTo(Square s)
    {
        return adjacentList.contains(s);
    }
    
    /**
     * A method that returns this Square's x position within the Board.
     * @return This Square's x position.
     */
    public int getXPos()
    {
        return xPos;
    }
    
    /**
     * A method that returns this Square's y position within the Board.
     * @return This Square's y position.
     */
    public int getYPos()
    {
        return yPos;
    }
    
    /**
     * Moves the game object in this Square to another Square.
     * @param that The target Square which will now have this Square's game object.
     */
    public void moveGameObjectToSquare(Square that)
    {
        that.setGameObject(this.holds);
        this.setGameObject(new Road());
    }
}
