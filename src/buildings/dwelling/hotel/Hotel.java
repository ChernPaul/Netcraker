package buildings.dwelling.hotel;
import buildings.dwelling.Dwelling;
import buildings.dwelling.Flat;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

public class Hotel extends Dwelling {





    public Hotel (int tmpFloorsQuantity, int[] arrayOfQuantities) {
        super(tmpFloorsQuantity, arrayOfQuantities);
    }

    public Hotel (Floor[] array) {
        super(array);
    }




    public int getMaxStarsQuantity(){
        int result = 0;

        for(int i=0; i < this.dwellingFloors.length; i++){
            if(this.getFloorByNumber(i) instanceof HotelFloor)
               if( result < ((HotelFloor) this.getFloorByNumber(i)).getStarsQuantity())
                   result = ((HotelFloor) this.getFloorByNumber(i)).getStarsQuantity();
        }

        return result;

    }



    public Space getBestSpace() {
        Space result = null;
        double gradeValue = 0;
        for(int i =0; i < this.dwellingFloors.length; i++){
            if(this.getFloorByNumber(i) instanceof HotelFloor) {
                double currentFloorCoefficient = HotelConstants.getFloorStarCoefficient(((HotelFloor)this.getFloorByNumber(i)).getStarsQuantity());
                for (int j = 0; j < this.getFloorByNumber(i).getSpacesQuantity(); j++) {
                    if(gradeValue < this.getFloorByNumber(i).getSpaceByNumber(j).getSquare()*currentFloorCoefficient) {
                        gradeValue = this.getFloorByNumber(i).getSpaceByNumber(j).getSquare() * currentFloorCoefficient;
                        result = this.getFloorByNumber(i).getSpaceByNumber(j);
                    }
                }
            }
        }

    return result;
    }

    @Override
    public String toString() {

        StringBuffer result = new StringBuffer();
        result.append("Hotel (" + this.getMaxStarsQuantity() + " " + dwellingFloors.length + ",");

        for(int i = 0; i < dwellingFloors.length - 1; i++){
            result.append(" " + dwellingFloors[i].toString() + ",");
        }
        result.append(" " + dwellingFloors[dwellingFloors.length - 1].toString() + ")");

        return  result.toString();

    }

    @Override
    public boolean equals(Object object){
        if (object instanceof Hotel ){
            if (this.getFloorsQuantity() == ((Hotel) object).getFloorsQuantity()){

                for(int i = 0; i < this.getFloorsQuantity(); i++){
                    if(!this.getFloorByNumber(i).equals(((Hotel) object).getFloorByNumber(i))){
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











}
