package lists;

import buildings.office.Office;
import buildings.interfaces.Space;

import java.io.Serializable;

public class SingleSideList implements Serializable, Cloneable {

    private ListNode head;
    private ListNode tail;
    private int size;

    public SingleSideList() {
        head = null;
        tail = null;
        size = 0;
    }

    public SingleSideList(int num){
        for(int i = 0; i < num; i++){
            pushBack(new Office());
        }
    }


    public int lenght() {
        return size;
    }

    public boolean isListEmpty() {
        return (size == 0);
    }

    public void pushBack(Space office) {
        size++;
        if (head == null){
            head = new ListNode(office);
            tail = head;
            head.setNextNode(head);
        }
        else {

            if (size == 1){
                ListNode tmp = new ListNode(office, head);
                tail = tmp;
                head.setNextNode(tmp);
            }
            else {
                ListNode newNode = new ListNode(office, head);
                tail.setNextNode(newNode);
                tail = newNode;

                }
            }

    }

    public void pushFront(Space office) {

        size++;

        if (head == null){
            head = new ListNode(office, null);
            head.setNextNode(head);
            tail = head;
        }
        else {
            if (size == 1){
                ListNode newNode = new ListNode(office, tail);
                head = newNode;
                tail.setNextNode(newNode);
            }
            else {
                ListNode newNode = new ListNode(office, head);
                head = newNode;
                tail.setNextNode(newNode);
            }
        }
    }

    public void popFront() {
        size--;
        head = head.getNextNode();
        tail.setNextNode(head);
    }

    public void insert(Space office, int num) {
        if (num == 0){
            pushFront(office);
        }
        else {
            if (num == size){
                pushBack(office);
            }
            else {
                ListNode curListNode = head;
                for (int i = 0; i < num; i++){
                    curListNode = curListNode.getNextNode();
                }
                ListNode newListNode = new ListNode(office, curListNode.getNextNode());
                curListNode.setNextNode(newListNode);
                size++;
            }
        }
    }


    public void remove(int num) {
        if (num == 0) {
            popFront();
        }
        else {
            ListNode curListNode = head;
            for (int i = 0; i < num-1; i++) {
                curListNode = curListNode.getNextNode();
            }
            if (num == (size - 1)) {
                ListNode deletedNode = curListNode.getNextNode();
                curListNode.setNextNode(deletedNode.getNextNode());
                tail = curListNode;
            }
            else {
                ListNode deletedNode = curListNode.getNextNode();
                curListNode.setNextNode(deletedNode.getNextNode());
            }
            size--;
        }
    }


    public ListNode getNode(int num){
        int count = 0;
        ListNode curListNode = head;
        if(num == size - 1){
            return tail;
        }
        while (curListNode != tail){
            if (count == num) {
                break;
            }
            curListNode = curListNode.getNextNode();
            count++;
        }
        return curListNode;
    }

    public ListNode getHead(){
        return this.head;
    }
    public ListNode getTail(){
        return this.tail;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public void setTail(ListNode tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {

        // office0; office1;
        StringBuilder result = new StringBuilder();
        ListNode tmp = head.getNextNode();
        result.append(head.getSpace());
        result.append("; ");

        while (tmp!= head){
            result.append(tmp.getSpace());
            result.append("; ");
            tmp = tmp.getNextNode();
        }


        return result.toString();
    }
/*
    @Override
    public Object clone() {
        Object result = null;

        try {
            result = super.clone();
            ((SingleSideList) result).setHead((ListNode) this.getHead().clone());
            ((SingleSideList) result).setTail((ListNode) this.getTail().clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return result;
    }

*/

}
