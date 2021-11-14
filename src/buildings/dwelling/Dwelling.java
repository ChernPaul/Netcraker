package buildings.dwelling;

import buildings.exceptions.FloorIndexOutOfBoundsException;
import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import buildings.iterators.DwellingIterator;


import java.io.Serializable;
import java.util.Iterator;

public class Dwelling implements Building, Serializable,Cloneable {

    protected Floor[] dwellingFloors;


    public Dwelling(int tmpFloorsQuantity, int[] arrayOfQuantities) {

        dwellingFloors = new DwellingFloor[tmpFloorsQuantity];
        for (int i = 0; i < tmpFloorsQuantity; i++) {
            dwellingFloors[i] = new DwellingFloor(arrayOfQuantities[i]);
        }
    }


    public Dwelling(Floor[] array) {
        dwellingFloors = array;
    }

    public int getFloorsQuantity() {
        return dwellingFloors.length;
    }

    public int getSpacesQuantity() {
        int tmp = 0;
        for (int i = 0; i < dwellingFloors.length; i++) {
            tmp += dwellingFloors[i].getSpacesQuantity();
        }
        return tmp;
    }

    public double getTotalSquare() {
        double tmp = 0;
        for (int i = 0; i < dwellingFloors.length; i++) {
            tmp += dwellingFloors[i].getTotalFloorSquare();
        }
        return tmp;
    }

    public int getRoomsQuantity() {
        int tmp = 0;
        for (int i = 0; i < dwellingFloors.length; i++) {
            for (int j = 0; j < dwellingFloors[i].getSpacesQuantity(); j++)
            tmp += dwellingFloors[i].getSpacesArray()[j].getRoomsQuantity();
        }
        return tmp;
    }

    public Floor[] getFloorsArray() {
        return dwellingFloors;
    }

    public Floor getFloorByNumber(int number) {
        if (number < 0 || number > dwellingFloors.length){
            throw new FloorIndexOutOfBoundsException(number, dwellingFloors.length);
        }
        return dwellingFloors[number];
    }

    public void setFloorByNumber(int number, Floor newFloor) {
        if (number < 0 || number > dwellingFloors.length){
            throw new FloorIndexOutOfBoundsException(number, dwellingFloors.length);
        }
        if(newFloor instanceof DwellingFloor) {
            dwellingFloors[number] = (DwellingFloor) newFloor;
        }
    }

    public Space getSpaceByNumber(int number) {

        int currentFloor = 0;
        int firstFlatFloorNumber = 0;
        for (int i = 0; i < dwellingFloors.length; i++) {
            if (number - dwellingFloors[i].getSpacesQuantity() - firstFlatFloorNumber  <= 0) {
                currentFloor = i;
                break;
            }
            firstFlatFloorNumber += dwellingFloors[i].getSpacesQuantity();
        }
        return dwellingFloors[currentFloor].getSpacesArray()[number - firstFlatFloorNumber - 1];
    }

    public void setSpaceByNumber(int number, Space newFlat) {

        int currentFloor = 0;
        int firstFlatFloorNumber = 0;
        for (int i = 0; i < dwellingFloors.length; i++) {
            if (number - dwellingFloors[i].getSpacesQuantity() - firstFlatFloorNumber <= 0) {
                currentFloor = i;
                break;
            }
            firstFlatFloorNumber += dwellingFloors[i].getSpacesQuantity();
        }
        dwellingFloors[currentFloor].getSpacesArray()[number - firstFlatFloorNumber] = newFlat;
    }


    public void addSpaceByNumber(int number, Space newFlat) {
        int currentFloor = 0;
        int firstFlatFloorNumber = 0;
        for (int i = 0; i < dwellingFloors.length; i++) {
            if (number - dwellingFloors[i].getSpacesQuantity() - firstFlatFloorNumber <= 0) {
                currentFloor = i;
                break;
            }
            firstFlatFloorNumber += dwellingFloors[i].getSpacesQuantity();
        }
        dwellingFloors[currentFloor].addSpace(number - firstFlatFloorNumber, newFlat);
    }

    public void removeSpaceByNumber(int number) {
        int currentFloor = 0;
        int firstFlatFloorNumber = 0;
        for (int i = 0; i < dwellingFloors.length; i++) {
            if (number - dwellingFloors[i].getSpacesQuantity() - firstFlatFloorNumber <= 0) {
                currentFloor = i;
                break;
            }
            firstFlatFloorNumber += dwellingFloors[i].getSpacesQuantity();
        }

        int currentFloorFlatsQuantity =  dwellingFloors[currentFloor].getSpacesQuantity();


        Floor tmpDwFl = new DwellingFloor(currentFloorFlatsQuantity - 1);

        for (int i = 0; i < (number - firstFlatFloorNumber); i++ ) {

                   tmpDwFl.getSpacesArray()[i] = dwellingFloors[currentFloor].getSpacesArray()[i];
        }


        for (int i = (number - firstFlatFloorNumber) ; i < currentFloorFlatsQuantity - 1; i++ ) {

            tmpDwFl.getSpacesArray()[i] = dwellingFloors[currentFloor].getSpacesArray()[i+1];
        }

       dwellingFloors[currentFloor] = tmpDwFl;
    }

/*
    public Space getBestSpace() {
        Flat bestFlat = (Flat) dwellingFloors[0].getSpaceByNumber(0);
        double bestFlatSquare = dwellingFloors[0].getSpaceByNumber(0).getSquare();
        for (int i = 0; i < floorsQuantity; i++) {
            for (int j = 0; j < dwellingFloors[i].getSpacesQuantity(); j++) {
                if (dwellingFloors[i].getSpacesArray()[j].getSquare() > bestFlatSquare) {
                    bestFlat = (Flat) dwellingFloors[i].getSpacesArray()[j];
                    bestFlatSquare = dwellingFloors[i].getSpacesArray()[j].getSquare();
                }
            }
        }
        return bestFlat;
    }
*/
    public Space getBestSpace() {
        Flat bestFlat = (Flat) dwellingFloors[0].getSpaceByNumber(0);
        int bestFlatNumber = 0;
        int firstFlatFloorNumber = 0;

        double bestFlatSquare = dwellingFloors[0].getSpaceByNumber(0).getSquare();
        for (int i = 0; i < dwellingFloors.length; i++) {
            for (int j = 0; j < dwellingFloors[i].getSpacesQuantity(); j++) {
                if (dwellingFloors[i].getSpacesArray()[j].getSquare() > bestFlatSquare) {
                    bestFlat = (Flat) dwellingFloors[i].getSpacesArray()[j];
                    bestFlatSquare = dwellingFloors[i].getSpacesArray()[j].getSquare();
                    bestFlatNumber = firstFlatFloorNumber + j;
                }
            }
            firstFlatFloorNumber += dwellingFloors[i].getSpacesQuantity();
        }
        return getSpaceByNumber(bestFlatNumber);
    }


    public Space[] getSortedSpaceArray() {
        int totalFlatsQuantity = 0;
        for (int i = 0; i < dwellingFloors.length; i++) {

            totalFlatsQuantity += dwellingFloors[i].getSpacesQuantity();
        }
        Flat[] tmpArray1 = new Flat[totalFlatsQuantity];
        int curentNumber = 0;
        for(int i = 0; i < dwellingFloors.length; i++)
        {
            for(int j = 0; j < dwellingFloors[i].getSpacesQuantity(); j++) {

                tmpArray1[curentNumber + j] = (Flat) dwellingFloors[i].getSpacesArray()[j];
            }
            curentNumber += dwellingFloors[i].getSpacesQuantity();
        }

        double maxSquare = 0;
        int maxFlatIndex = 0;
        Flat temp = new Flat(5, 1);

        for (int i = 0; i <totalFlatsQuantity; i++) {

            for (int j = i; j < totalFlatsQuantity; j++) {
                if (tmpArray1[j].getSquare() > maxSquare)
                {
                    maxSquare = tmpArray1[j].getSquare();
                    maxFlatIndex = j;
                }
            }
            temp = tmpArray1[i];
            tmpArray1[i] = tmpArray1[maxFlatIndex];
            tmpArray1[maxFlatIndex] = temp;
            maxSquare = 0;
        }
        return tmpArray1;

    }

    public void printDwellingStructure() {

        for(int i = 0; i < dwellingFloors.length; i++) {

            System.out.println("Floor number " + i);
            for (int j = 0; j < dwellingFloors[i].getSpacesQuantity(); j++) {

                System.out.println("  Flat number "+ " " + j + "   Square " + dwellingFloors[i].getSpacesArray()[j].getSquare());

            }

        }

    }

    public void setDwellingFloors(Floor[] dwellingFloors) {
        this.dwellingFloors = dwellingFloors;
    }

    @Override
    public String toString() {

        StringBuffer result = new StringBuffer();
        result.append("Dwelling (" + dwellingFloors.length + ",");

        for(int i = 0; i < dwellingFloors.length - 1; i++){
            result.append(" " + dwellingFloors[i].toString() + ",");
        }
        result.append(" " + dwellingFloors[dwellingFloors.length - 1].toString() + ")");

        return  result.toString();

    }

    @Override
    public boolean equals(Object object){
        if (object instanceof Dwelling ){
            if (this.getFloorsQuantity() == ((Dwelling) object).getFloorsQuantity()){

                for(int i = 0; i < this.getFloorsQuantity(); i++){
                    if(!this.getFloorByNumber(i).equals(((Dwelling) object).getFloorByNumber(i))){
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
    public Object clone()  {
        Object result = null;

        Floor[] prepareDwellingFloors = new Floor[this.getFloorsQuantity()];
        for(int i = 0; i <this.getFloorsQuantity(); i++){
            prepareDwellingFloors[i] = (Floor) this.getFloorByNumber(i).clone();
        }

        try {
            result = super.clone();
            ((Dwelling) result).setDwellingFloors(prepareDwellingFloors);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Iterator<Floor> iterator(){

        return new DwellingIterator(this);
    }


}
