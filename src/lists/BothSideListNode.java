package lists;
import buildings.interfaces.Floor;
import buildings.office.OfficeFloor;

import java.io.Serializable;

public class BothSideListNode implements Serializable, Cloneable  {


     private Floor floor;
     private BothSideListNode next;
     private BothSideListNode prev;

     public BothSideListNode() {
         floor = new OfficeFloor(1);
         next = null;
         prev = null;
     }

     public BothSideListNode(Floor newFloor) {
         floor = newFloor;
         next = null;
         prev = null;
     }

     public BothSideListNode(Floor newFloor, BothSideListNode next, BothSideListNode prev){
         floor = newFloor;
         this.next = next;
         this.prev = prev;
     }

    public BothSideListNode(BothSideListNode node){
        floor = node.floor;
        this.next = node.next;
        this.prev = node.prev;
    }

    public Floor getFloor() {
         return floor;
     }

    public BothSideListNode getNextNode() {
        return next;
    }

    public BothSideListNode getPreviousNode() {
        return prev;
    }

    public void setNextNode(BothSideListNode next) {
        this.next = next;
    }

    public void setPreviousNode(BothSideListNode prev) {
        this.prev = prev;
    }

    public void setOfficeFloor(Floor floor) {
        this.floor = floor;
    }
}
