package buildings.dwelling.hotel;
import buildings.exceptions.StarsValueExecption;

public class HotelConstants {

    public static final double ONESTAR = 0.25;
    public static final double TWOSTARS = 0.5;
    public static final double THREESTARS = 1;
    public static final double FOURSTARS = 1.25;
    public static final double FIVESTARS = 1.5;

    public static double getFloorStarCoefficient(int starsQuantity){
        switch (starsQuantity) {
            case 1:
                return ONESTAR;
            case 2:
                return TWOSTARS;
            case 3:
                return THREESTARS;
            case 4:
                return FOURSTARS;
            case 5:
                return FIVESTARS;
        }
    throw new StarsValueExecption();
    }

}
