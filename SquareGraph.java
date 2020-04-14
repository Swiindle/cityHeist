import java.util.*;

/**
 * Class that uses a list of Squares and their adjacent Squares to perform a Graph traversal.
 */
public class SquareGraph
{
    private ArrayList<Square> moveableList = new ArrayList<>();

    private void getNode(Square startNode, int i, ArrayList<Square> visitedList)
    {
        //System.out.println("Now at Square: " + startNode.getID() + " i: " + i);
        i--;
        visitedList.add(startNode);
        ArrayList<Square> localList = new ArrayList<>();
        localList.addAll(visitedList);
        ArrayList<Square> adjacentList = startNode.getAdjacentList();
        for(Square s : adjacentList)
        {
            //System.out.println("Square: " + startNode.getID() + " checking if we have been to Square: " + s.getID());
            if(i != 0 && !visitedList.contains(s))
            {
                //System.out.println("We have not. " + s.getID());
                getNode(s,i,localList);
            }
            else if(i == 0)
            {
                addMoveableList(startNode);
            }
            /* Debuggin purpouses
            if(s.getID() == 17)
            {
                System.out.println("Visited list--");
                for(Square s1 : visitedList)
                {
                    System.out.println("Square: " + s1.getID());
                }
            }*/
        }
    }
    
    /**
     * Traverses the graph to find a list squares that are "dice" places away from Square s.
     * @param start The square that the traversal will start from.
     * @param dice The integer value that comes from the dice roll.
     * @return A list of Squares that are "dice" places away from the start Square.
     */
    public ArrayList<Square> traverseGraph(Square start, int dice)
    {
        moveableList.clear();
        ArrayList<Square> visitedList = new ArrayList<>();
        getNode(start,dice+1,visitedList);
        return moveableList;
    }
    
    /**
     * Adds a Square to this list of Squares that have been traversed to.
     * @param s Square that has been traversed to.
     */
    public void addMoveableList(Square s)
    {
        if(!moveableList.contains(s))
        {
            //System.out.println("Adding [" + s.getID() + "]");
            moveableList.add(s);
        }
    }
}
