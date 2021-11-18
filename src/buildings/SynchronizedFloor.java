package buildings;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

import java.io.Serializable;
import java.util.Iterator;

public class SynchronizedFloor implements Floor, Serializable,Cloneable {

    protected Floor synchronizedFloor;

    public SynchronizedFloor(Floor floor){
        synchronizedFloor = floor;
    }

    public synchronized int getSpacesQuantity(){

        return synchronizedFloor.getSpacesQuantity();
    }

    public synchronized double getTotalFloorSquare(){

        return synchronizedFloor.getTotalFloorSquare();
    }


    public synchronized int getFloorRoomsQuantity(){

        return getFloorRoomsQuantity();
    }


    public synchronized Space[] getSpacesArray(){
        return synchronizedFloor.getSpacesArray();
    }



    public synchronized Space getSpaceByNumber(int num){

        return synchronizedFloor.getSpaceByNumber(num);
    }


    public synchronized void setSpace(int num, Space newSpace){

        synchronizedFloor.setSpace(num, newSpace);
    }

    public synchronized void addSpace(int num, Space newSpace){

        synchronizedFloor.addSpace(num, newSpace);
    }

    public synchronized void removeSpace(int num){
        synchronizedFloor.removeSpace(num);
    }


    public synchronized Space getBestSpace(){
        return synchronizedFloor.getBestSpace();
    }

    public synchronized Object clone(){
        return synchronizedFloor.clone();
    }

    public  synchronized int compareTo(Floor o){
        return synchronizedFloor.compareTo(o);
    }

    @Override
    public Iterator<Space> iterator() {
        return null;
    }
}
