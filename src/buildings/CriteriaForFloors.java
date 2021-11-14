package buildings;
import buildings.interfaces.Floor;
import java.util.Comparator;

public class CriteriaForFloors implements Comparator<Floor> {

    @Override
    public int compare(Floor floor1, Floor floor2){
        if(floor1.getTotalFloorSquare() < floor2.getTotalFloorSquare())
            return 1;
        if (floor1.getTotalFloorSquare() > floor2.getTotalFloorSquare())
            return -1;
        return 0;
    }




}
