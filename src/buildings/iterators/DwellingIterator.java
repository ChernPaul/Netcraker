package buildings.iterators;
import buildings.interfaces.Building;
import buildings.interfaces.Floor;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class DwellingIterator implements Iterator<Floor> {


    private Building dwelling;
    private int currentPosition;


    public DwellingIterator(Building building){

        dwelling = building;
        currentPosition = -1;
    }

    public boolean hasNext(){
        if(currentPosition < dwelling.getFloorsQuantity() - 1)
            return true;
        return false;
    }

    public Floor next() throws NoSuchElementException {
        if (!this.hasNext())
            throw new NoSuchElementException("No more floors in this building");
        currentPosition++;
        return dwelling.getFloorByNumber(currentPosition);
    }

}
