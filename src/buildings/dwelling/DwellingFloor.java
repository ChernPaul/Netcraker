package buildings.dwelling;

import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import buildings.exceptions.SpaceIndexOutOfBoundsException;
import buildings.iterators.DwellingFloorIterator;
import lists.SingleSideList;
import java.io.Serializable;
import java.util.Iterator;

public class DwellingFloor implements Floor, Serializable,Cloneable {

   protected Flat flats[];


    public DwellingFloor(int fltsQnt) {
    flats = new Flat[fltsQnt];
    for(int i = 0; i < fltsQnt; i++) {
        flats[i] = new Flat();
        }
    }

    public DwellingFloor(Space[] flts) {
        flats = (Flat[]) flts;
    }

    public int getSpacesQuantity() {
        return flats.length;
    }

    public double getTotalFloorSquare() {
        double summarySquare = 0;
        for(int i = 0; i < flats.length; i++) {
           summarySquare += flats[i].getSquare();
            }
        return summarySquare;
        }

    public int getFloorRoomsQuantity() {
        int summaryRooms = 0;
        for(int i = 0; i < flats.length; i++) {
            summaryRooms += flats[i].getRoomsQuantity();
        }
        return summaryRooms;
    }

    public Space[] getSpacesArray() {
        return flats;
    }

    public Space getSpaceByNumber(int number) {
        if (number < 0 || number > flats.length){
            throw new SpaceIndexOutOfBoundsException(number, flats.length);
        }
        return flats[number];
    }

    public void setSpace(int number, Space newSpace) {
        if (number < 0 || number > flats.length) {
            throw new SpaceIndexOutOfBoundsException(number, flats.length);
        }
        if (newSpace instanceof Flat) {
            flats[number] = (Flat) newSpace;
        }
    }

    public void addSpace(int number, Space newSpace) {

            if ((number - flats.length) >= 1) {
                    throw new SpaceIndexOutOfBoundsException(number, flats.length);
            }

           int newQuantity = flats.length + 1;
           Flat[] tmpSpaces = new Flat[newQuantity];

           for (int i = 0; i < number; i++) {
               tmpSpaces[i] = flats[i];
           }
           if(newSpace instanceof  Flat) {
               tmpSpaces[number] = (Flat) newSpace;
           }
           for (int i = number + 1; i < flats.length; i++) {
               tmpSpaces[i + 1] = flats[i];
           }

            flats = tmpSpaces;
    }

    public void removeSpace(int number) {
        if (number < 0 || number > flats.length){
            throw new SpaceIndexOutOfBoundsException(number, flats.length);
        }
        Flat []  tmpFlats = new Flat[flats.length - 1];

        for(int i = 0; i < number; i++) {
            tmpFlats[i] = flats[i];
        }

        for(int i = number; i < flats.length - 1; i++) {
            tmpFlats[i] = flats[i + 1];

        }
        flats = tmpFlats;

    }

    public Space getBestSpace() {

        double  maxSquare = flats[0].getSquare();
        int indexOfMax = 0;
            for(int i = 0; i < flats.length; i++) {
                if (flats[i].getSquare() > maxSquare ) {
                    maxSquare = flats[i].getSquare();
                    indexOfMax = i;
                }
        }

        return flats[indexOfMax];
    }

    public void printFloorInfo() {
        System.out.println("FloorFlatsQuantity" + flats.length );
        for (int i = 0; i < flats.length; i++) {
            flats[i].printFlatInfo();
        }
    }
    /*
    public SingleSideList getSpacesList() {
        return null;
    }
    */
    public void setSpacesArray(Space [] spacePtr){
        flats = (Flat[]) spacePtr;
    }



    @Override
    public String toString() {

        StringBuffer result = new StringBuffer();
        result.append("DwellingFloor (" + flats.length + ",");

        for(int i = 0; i < flats.length - 1; i++){
            result.append(" " + flats[i].toString() + ",");
        }

        result.append(" " + flats[flats.length - 1].toString() + ")");
       return  result.toString();
    }


    @Override
    public boolean equals(Object object){
        if (object instanceof DwellingFloor ){
            if (this.getSpacesQuantity() == ((DwellingFloor) object).getSpacesQuantity()){

            for(int i = 0; i < this.getSpacesQuantity(); i++){
                if(!this.getSpaceByNumber(i).equals(((DwellingFloor) object).getSpaceByNumber(i))){
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
        int result = this.getSpacesQuantity();
        for(int i = 0; i < this.getSpacesQuantity(); i++)
        {
            result = result^this.getSpaceByNumber(i).hashCode();

        }

        return result;
    }


    @Override
    public Object clone()  {
        Object result = null;

        try {
            result = super.clone();
            ((DwellingFloor) result).setSpacesArray(flats.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Iterator<Space> iterator(){

        return new DwellingFloorIterator(this);
    }


    @Override
    public int compareTo(Floor o) {
        if(o instanceof Floor) {

            if (this.getSpacesQuantity() > ((Floor) o).getSpacesQuantity()) {
                return 1;
            } else if (this.getSpacesQuantity() == ((Floor) o).getSpacesQuantity())
                return 0;

            return -1;
        }
        throw new IllegalArgumentException("Incorrect object type ");


    }

}



