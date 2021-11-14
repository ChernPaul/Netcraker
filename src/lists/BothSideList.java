package lists;
import buildings.interfaces.Floor;
import buildings.office.OfficeFloor;
import java.io.Serializable;

public class BothSideList implements Serializable, Cloneable {


    private BothSideListNode head;
    private BothSideListNode tail;
    private int size;

    public BothSideList(){
        head = null;
        tail = null;
        size = 0;
    }

    public BothSideList(int num){
        for(int i = 0; i < num; i++){
            pushBack(new OfficeFloor(1));
        }
    }

    public BothSideListNode getHead(){
        return head;
    }


    public void pushBack(Floor floor){
        size++;
        if (head == null){
            head = new BothSideListNode(floor);
            head.setNextNode(head);
            head.setPreviousNode(head);
            tail = head;
        }
        else {
            if (size == 1){
                BothSideListNode tmp = new BothSideListNode(floor, head, head);
                tail = tmp;
                tail.setNextNode(head);
                tail.setPreviousNode(head);
                head.setNextNode(tail);
                head.setPreviousNode(tail);
            }
            else {
                BothSideListNode newBothSideListNode = new BothSideListNode(floor, head, tail);
                tail.setNextNode(newBothSideListNode);
                head.setPreviousNode(newBothSideListNode);
                tail = newBothSideListNode;
            }
        }
    }

    public void pushFront(Floor floor){
        size++;
        BothSideListNode tmp = new BothSideListNode(floor);
        tail.setNextNode(tmp);
        head.setPreviousNode(tmp);
        head = tmp;
    }

    public void popFront(){
        head = head.getNextNode();
        tail.setNextNode(head);
        head.setPreviousNode(tail);
        size--;
    }

    public void insert(Floor newFloor, int num){
        if (num == 0){
            pushFront(newFloor);
        }
        else {
            if (num == size){
                pushBack(newFloor);
            }
            else {
                BothSideListNode curBothSideListNode = head;
                for (int i = 0; i < (num-1); i++){
                    curBothSideListNode = curBothSideListNode.getNextNode();
                }
                BothSideListNode insertedBothSideList = new BothSideListNode(newFloor,curBothSideListNode.getNextNode(),curBothSideListNode);
                curBothSideListNode.setNextNode(insertedBothSideList);
                curBothSideListNode.getNextNode().setPreviousNode(curBothSideListNode);

                ++size;
            }
        }
    }

    public void remove(int num){
        if (num == 0){
            popFront();
        }
        else {
            BothSideListNode curBothSideListNode = head;
            for (int i = 0; i < num; i++){
                curBothSideListNode = curBothSideListNode.getNextNode();
            }
            if (num == size - 1){
                BothSideListNode deletedNode = curBothSideListNode.getNextNode();
                curBothSideListNode.setNextNode(deletedNode.getNextNode());
                head.setPreviousNode(curBothSideListNode);
                tail = curBothSideListNode;
            }
            else {
                BothSideListNode deletedNode = curBothSideListNode.getNextNode();
                curBothSideListNode.getNextNode().setPreviousNode(curBothSideListNode);
                curBothSideListNode.setNextNode(deletedNode.getNextNode());
            }
            --size;
        }
    }

    public BothSideListNode getNode(int num){
        int count = 0;
        BothSideListNode curBothSideListNode = head;
        if(num == size - 1){
            return tail;
        }
        while (curBothSideListNode != tail){
            if (count == num) {
                break;
            }
            curBothSideListNode = curBothSideListNode.getNextNode();
            ++count;
        }
        return curBothSideListNode;
    }


    @Override
    public String toString() {

        BothSideListNode tmp = head.getNextNode();
        StringBuilder result = new StringBuilder("");
        result.append(head.getFloor());
        result.append("; \n ");



        while(tmp!= head){
           // floor0; floor1; floor2;
            result.append(tmp.getFloor());
            result.append("; \n");

            tmp = tmp.getNextNode();

        }

        return result.toString();
    }


    public int length() {
        return size;
    }

}
