import java.util.*;
public class SquareGraph
{
    private ArrayList<Square> moveableList = new ArrayList<>();

    /**
     * Traverses the graph to find the squares that are "i" places away from Square s
     */
    public void getNode(Square startNode, int i, ArrayList<Square> visitedList)
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
    
    public ArrayList<Square> traverseGraph(Square start, int dice)
    {
        moveableList.clear();
        ArrayList<Square> visitedList = new ArrayList<>();
        getNode(start,dice+1,visitedList);
        return moveableList;
    }
    
    public void addMoveableList(Square s)
    {
        if(!moveableList.contains(s))
        {
            //System.out.println("Adding [" + s.getID() + "]");
            moveableList.add(s);
        }
    }
}
