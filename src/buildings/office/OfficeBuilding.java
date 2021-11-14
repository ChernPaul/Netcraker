package buildings.office;

import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import buildings.exceptions.FloorIndexOutOfBoundsException;
import buildings.exceptions.SpaceIndexOutOfBoundsException;
import buildings.iterators.OfficeBuildingIterator;
import lists.BothSideList;
import lists.BothSideListNode;

import java.io.Serializable;
import java.util.Iterator;

public class OfficeBuilding implements Building, Serializable,Cloneable {

    private BothSideList officeFloorsList;

    private BothSideListNode getNodeByNum(int number){
        if (number < 0 || number > getSpacesQuantity()){
            throw new SpaceIndexOutOfBoundsException(number, getSpacesQuantity());
        }
        return officeFloorsList.getNode(number);
    }

    private void addByNum(Floor newFloor, int number){
        if (number < 0 || number > getSpacesQuantity()){
            throw new SpaceIndexOutOfBoundsException(number, getSpacesQuantity());
        }
        officeFloorsList.insert(newFloor, number);
    }

    private void removeByNum(int number){
        if (number < 0 || number > getSpacesQuantity()){
            throw new SpaceIndexOutOfBoundsException(number, getSpacesQuantity());
        }
        officeFloorsList.remove(number);
    }

    public OfficeBuilding(int floorsQuantity){

        officeFloorsList = new BothSideList();
        for(int i = 0; i < floorsQuantity; i++){
            officeFloorsList.pushBack(new OfficeFloor());
        }
    }

    public OfficeBuilding(int floorsQuantity, int[] officesQuantity){
        officeFloorsList = new BothSideList();

        for(int i = 0; i < floorsQuantity; i++){
            officeFloorsList.pushBack(new OfficeFloor(officesQuantity[i]));
        }
    }

    public OfficeBuilding(Floor[] floors){
        officeFloorsList = new BothSideList();
        for (int i = 0; i < floors.length ; i++){
            officeFloorsList.pushBack(floors[i]);
        }
    }

    public int getFloorsQuantity(){
        return officeFloorsList.length();
    }

    public BothSideList getOfficeFloorsList() {
        return officeFloorsList;
    }

    public int getSpacesQuantity(){
        int sum = 0;
        for (int i = 0; i < officeFloorsList.length(); i++) {
            sum += officeFloorsList.getNode(i).getFloor().getSpacesQuantity();
        }
        return sum;
    }

    public double getTotalSquare(){
        int square = 0;
        for (int i = 0; i < officeFloorsList.length(); i++){
            square += officeFloorsList.getNode(i).getFloor().getTotalFloorSquare();
        }
        return square;
    }


    public int getRoomsQuantity(){
        int rooms = 0;
        for (int i = 0; i < officeFloorsList.length(); i++){
            rooms += officeFloorsList.getNode(i).getFloor().getFloorRoomsQuantity();
        }
        return rooms;
    }

    public Floor [] getFloorsArray(){
        Floor[] tmpFloors = new Floor[officeFloorsList.length()];
        for (int i = 0; i < officeFloorsList.length(); i++){
            tmpFloors[i] = officeFloorsList.getNode(i).getFloor();
        }
        return tmpFloors;
    }



    public Floor getFloorByNumber(int number){
        if (number < 0 || number > getFloorsQuantity()){
            throw new FloorIndexOutOfBoundsException(number, getSpacesQuantity());
        }
        return officeFloorsList.getNode(number).getFloor();
    }

    public void setFloorByNumber(int number, Floor newFloor){
        if (number < 0 || number > getSpacesQuantity()){
            throw new FloorIndexOutOfBoundsException(number, getSpacesQuantity());
        }
        if (newFloor instanceof OfficeFloor)
        officeFloorsList.getNode(number).setOfficeFloor((OfficeFloor)newFloor);
    }

    public Space getSpaceByNumber(int number){

        int count = 0;
        Space tmp = null;
        for (int i = 0; i < officeFloorsList.length(); i++){
            for (int j = 0; j < officeFloorsList.getNode(i).getFloor().getSpacesQuantity(); j++){
                if (count == number){
                    tmp = officeFloorsList.getNode(i).getFloor().getSpaceByNumber(j);
                }
                else count++;
            }
        }
        return  tmp;
    }




    public void setSpaceByNumber(int number, Space newOffice){
        int count = 0;
        for (int i = 0; i < officeFloorsList.length(); i++){
            for (int j = 0; j < officeFloorsList.getNode(i).getFloor().getSpacesQuantity(); j++){
                if (count == number){
                    officeFloorsList.getNode(i).getFloor().setSpace(j, newOffice);

                }
                count++;
            }
        }
    }


    public void addSpaceByNumber(int number, Space newOffice){
        int count = 0;
        for (int i = 0; i < officeFloorsList.length(); i++){
            for (int j = 0; j < officeFloorsList.getNode(i).getFloor().getSpacesQuantity(); j++){
                if (count == number){
                    officeFloorsList.getNode(i).getFloor().addSpace(j, newOffice);
                }
                else count++;
            }
        }
    }

    public void removeSpaceByNumber(int number){
        int count = 0;
        for (int i = 0; i < officeFloorsList.length(); i++){
            for (int j = 0; j < officeFloorsList.getNode(i).getFloor().getFloorRoomsQuantity(); j++){
                if (count == number){
                    officeFloorsList.getNode(i).getFloor().removeSpace(j);
                }
                else count++;
            }
        }
    }

    public Space getBestSpace(){
        Space tmp = new Office();
        for (int i = 0; i < officeFloorsList.length(); i++){
            if (officeFloorsList.getNode(i).getFloor().getBestSpace().getSquare() > tmp.getSquare())
                tmp = officeFloorsList.getNode(i).getFloor().getBestSpace();
        }
        return tmp;
    }

    public Space [] getSortedSpaceArray(){
        int count = 0;

        Space[] sortedArray = new Space[getSpacesQuantity()];
        for (int i = 0; i < officeFloorsList.length(); i++){
            for (int j = 0; j < officeFloorsList.getNode(i).getFloor().getSpacesQuantity(); j++, count++){
                Space currentSpace =officeFloorsList.getNode(i).getFloor().getSpaceByNumber(j);
                sortedArray[count] =  currentSpace;
            }
        }

        boolean isSorted = false;
        Space buf = new Office();
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i].getSquare() > sortedArray[i + 1].getSquare()) {
                    isSorted = false;

                    buf = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = buf;
                }
            }
        }
        return sortedArray;
    }


    public void setOfficeFloorList(BothSideList OfficeFloorListPtr){
        officeFloorsList = OfficeFloorListPtr;
    }



    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();

        result.append("OfficeBuilding (" + this.getFloorsQuantity() + ",");

        for (int i = 0; i < this.getFloorsQuantity() - 1; i++) {
            result.append(" " + getFloorByNumber(i).toString() + ",");
        }

        result.append(" " + getFloorByNumber(this.getFloorsQuantity() - 1).toString() + ")");
        return result.toString();

    }

    @Override
    public boolean equals(Object object){
        if (object instanceof OfficeBuilding ){
            if (this.getFloorsQuantity() == ((OfficeBuilding) object).getFloorsQuantity()){

                for(int i = 0; i < this.getFloorsQuantity(); i++){
                    if(!this.getFloorByNumber(i).equals(((OfficeBuilding) object).getFloorByNumber(i))){
                        return false;
                    }

                }
                return true;
            }
            else
                return false;



        }
        else
            return false;
    }

    @Override
    public int hashCode(){
        int result = this.getFloorsQuantity();
        for(int i = 0; i < this.getFloorsQuantity(); i++)
        {
            result = result^this.getFloorByNumber(i).hashCode();

        }

        return result;
    }


    @Override
    public Object clone(){
        Object result = null;
        BothSideList prepareBothSideList = new BothSideList();
        for(int i = 0; i < officeFloorsList.length(); i++){

            Floor prepareOfficeFloor = this.getFloorByNumber(i);
            prepareBothSideList.pushBack((Floor) prepareOfficeFloor.clone());
        }
        try {
            result = super.clone();
            ((OfficeBuilding) result).setOfficeFloorList(prepareBothSideList);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


        return result;
    }

    @Override
    public Iterator<Floor> iterator(){

        return new OfficeBuildingIterator(this);
    }


}
