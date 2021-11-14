package lists;

import buildings.interfaces.Space;
import java.io.Serializable;

public class ListNode implements Serializable, Cloneable  {
    private Space office;
    private ListNode nextNode;

    public ListNode(ListNode data) {
        office = data.getSpace();
        nextNode = data.getNextNode();
    }

    public ListNode(Space office) {
        this.office = office;
        nextNode = null;
    }

    public ListNode(Space office, ListNode next) {
        this.office = office;
        nextNode = next;
    }

    public void setNextNode(ListNode next) {
        nextNode = next;
    }
    public void setSpace(Space office) {
        this.office = office;
    }
    public ListNode getNextNode() {
        return nextNode;
    }

    public Space getSpace() {
        return office;
    }

/*
    @Override
    public Object clone() {
        Object result = null;

        try {
            result = super.clone();
            ((ListNode) result).setOffice(((Office) ((Office) this.getOffice()).clone()));
            ((ListNode) result).setNextNode( new ListNode(this.getNextNode()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


        return result;
    }
*/
}
