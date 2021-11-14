package buildings;
import buildings.interfaces.Space;
import java.util.Comparator;

public class CriteriaForSpaces implements Comparator<Space> {

        @Override
        public int compare(Space space1, Space space2){
            if(space1.getRoomsQuantity() < space2.getRoomsQuantity())
                return 1;
            if (space1.getRoomsQuantity() > space2.getRoomsQuantity())
                return -1;
            return 0;
        }


    }
