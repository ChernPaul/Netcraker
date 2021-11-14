package buildings.exceptions;
import buildings.interfaces.Floor;


public class InexchangeableFloorsException extends IllegalArgumentException{

    public InexchangeableFloorsException(Floor floor1, Floor floor2){
        String string = "InexchangeableSpacesException\n "
                +  "Invalid argument VALUES: floor1 totalSpaces: " + floor1.getSpacesQuantity() + " floor1 square: " + floor1.getTotalFloorSquare()
                +  "AND floor2 totalSpaces: " + floor2.getSpacesQuantity() + " floor2 square: " + floor2.getTotalFloorSquare() + "SHOULD BE EQUAL";


        throw new IllegalArgumentException(string);
    }



}
