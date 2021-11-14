package buildings.exceptions;
import buildings.interfaces.Space;

public class InexchangeableSpacesException extends IllegalArgumentException{
    public InexchangeableSpacesException(Space sp1, Space sp2){
        String string = "InexchangeableSpacesException\n "
                +  "Invalid argument VALUES: Space1 rooms: " +sp1.getRoomsQuantity() + " Space1 square: " + sp1.getSquare()
                +  "AND Space2 rooms: " + sp2.getRoomsQuantity() + " Space2 square: " + sp2.getSquare() + "SHOULD BE EQUAL";


        throw new IllegalArgumentException(string);
    }

    }


