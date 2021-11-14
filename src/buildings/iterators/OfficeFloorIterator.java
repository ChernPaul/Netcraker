package buildings.iterators;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import buildings.office.OfficeFloor;
import lists.ListNode;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class OfficeFloorIterator implements Iterator<Space> {



    private ListNode currentNode = null;
    private ListNode head = null;


    public OfficeFloorIterator(Floor floor) {
        head = ((OfficeFloor)floor).getSpacesList().getHead();
        currentNode = new ListNode((Space)null);
        currentNode.setNextNode(head);

    }
    public boolean hasNext(){
        if((currentNode.getNextNode() == head) && (currentNode.getSpace() != null))
            return false;
        return true;
    }
    public Space next() throws NoSuchElementException {
        if (!this.hasNext())
            throw new NoSuchElementException("No more spaces at this floor");

        currentNode = currentNode.getNextNode();
        Space result = currentNode.getSpace();

        return result;
    }

}
