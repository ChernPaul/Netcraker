package buildings.iterators;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class DwellingFloorIterator implements Iterator <Space> {


    private int currentPosition;
    private Floor floor;


    public DwellingFloorIterator(Floor floor) {
        this.floor = floor;
        currentPosition = -1;
    }

    public boolean hasNext(){
        if(currentPosition < floor.getSpacesQuantity() - 1)
            return true;
        return false;
    }

    public Space next() throws NoSuchElementException {
        if (!this.hasNext())
            throw new NoSuchElementException("No more spaces at this floor");

        currentPosition++;
        return floor.getSpaceByNumber(currentPosition);

    }




}
