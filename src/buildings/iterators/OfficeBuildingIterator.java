package buildings.iterators;
import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.office.OfficeBuilding;

import lists.BothSideListNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OfficeBuildingIterator implements Iterator<Floor> {



    private BothSideListNode currentNode = null;
    private BothSideListNode head = null;


    public OfficeBuildingIterator(Building building) {
        head = ((OfficeBuilding)building).getOfficeFloorsList().getHead();
        currentNode = new BothSideListNode((Floor) null);
        currentNode.setNextNode(head);

    }
    public boolean hasNext(){
        if((currentNode.getNextNode() == head) && (currentNode.getFloor() != null))
            return false;
        return true;
    }
    public Floor next() throws NoSuchElementException {
        if (!this.hasNext())
            throw new NoSuchElementException("No more spaces at this floor");

        currentNode = currentNode.getNextNode();
        Floor result = currentNode.getFloor();

        return result;
    }

}
