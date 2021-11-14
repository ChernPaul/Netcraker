package buildings;

import buildings.exceptions.FloorIndexOutOfBoundsException;
import buildings.exceptions.InexchangeableFloorsException;
import buildings.exceptions.InexchangeableSpacesException;
import buildings.exceptions.SpaceIndexOutOfBoundsException;
import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

public class PlacementExchanger {

    public static boolean isSpacesChangeable(Space sp1, Space sp2) {
        boolean bool = true;
        if (sp1.getRoomsQuantity() == sp2.getRoomsQuantity()){
            if(sp1.getSquare() != sp2.getSquare())
                bool = false;
        }
        else bool = false;
       return bool;

    }


    public static boolean isFloorsChangeable(Floor floor1, Floor floor2) {
        boolean bool = true;
        if (floor1.getSpacesQuantity() == floor2.getSpacesQuantity()){
            if(floor1.getTotalFloorSquare() != floor2.getTotalFloorSquare())
                bool = false;
        }
        else bool = false;
        return bool;

    }

    public static void exchangeFloorsSpaces(Floor floor1, Floor floor2, int index1, int index2){
        if(index1 < 0 || index1 > floor1.getSpacesQuantity()){
            throw new SpaceIndexOutOfBoundsException(index1, floor1.getSpacesQuantity());
        }

        if(index2 < 0 || index2 > floor2.getSpacesQuantity()){
            throw new SpaceIndexOutOfBoundsException(index1, floor1.getSpacesQuantity());
        }
        if(!isSpacesChangeable(floor1.getSpaceByNumber(index1),floor2.getSpaceByNumber(index2))){
            throw new InexchangeableSpacesException(floor1.getSpaceByNumber(index1),floor2.getSpaceByNumber(index2));
        }

        Space tmp = floor1.getSpaceByNumber(index1);
        floor1.setSpace(index1,floor2.getSpaceByNumber(index2));
        floor2.setSpace(index2,tmp);

    }

    public static void exchangeBuildingFloors(Building building1, Building building2, int index1, int index2){

        if (index1 < 0 || index1 > building1.getSpacesQuantity()) {
            throw new FloorIndexOutOfBoundsException(index1, building1.getSpacesQuantity());
        }
        if (index2 < 0 || index2 > building2.getSpacesQuantity()) {
            throw new FloorIndexOutOfBoundsException(index2, building2.getSpacesQuantity());
        }
        if(!isFloorsChangeable(building1.getFloorByNumber(index1),building2.getFloorByNumber(index2))){
            throw new InexchangeableFloorsException(building1.getFloorByNumber(index1),building2.getFloorByNumber(index2));
        }

    Floor tmp = building1.getFloorByNumber(index1);
    building1.setFloorByNumber(index1, building2.getFloorByNumber(index2));
    building2.setFloorByNumber(index2,tmp);


    }



}
