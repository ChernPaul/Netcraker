package buildings.dwelling.hotel;

import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.interfaces.Space;

public class HotelFloor extends DwellingFloor {

    int starsQuantity;
    final int defaultStars = 1;

    public HotelFloor(int spacesQuantity) {
        super(spacesQuantity);
        starsQuantity = defaultStars;
    }

    public HotelFloor(Space[] flts) {
        super(flts);
        starsQuantity = defaultStars;
    }

    public int getStarsQuantity() {
        return starsQuantity;
    }

    public void setStarsQuantity(int starsQuantity) {
        this.starsQuantity = starsQuantity;
    }

    @Override
    public String toString() {

        StringBuffer result = new StringBuffer();
        result.append("HotelFloor (" + starsQuantity + " " + flats.length + ",");

        for(int i = 0; i < flats.length - 1; i++){
            result.append(" " + flats[i].toString() + ",");
        }

        result.append(" " + flats[flats.length - 1].toString() + ")");
        return  result.toString();
    }

    @Override
    public boolean equals(Object object){
        if (object instanceof HotelFloor ){
            if (this.getSpacesQuantity() == ((HotelFloor) object).getSpacesQuantity()){
                if(this.getStarsQuantity() != ((HotelFloor) object).getStarsQuantity())
                    return false;
                for(int i = 0; i < this.getSpacesQuantity(); i++){
                    if(!this.getSpaceByNumber(i).equals(((DwellingFloor) object).getSpaceByNumber(i))){
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
        int result = this.getSpacesQuantity() ^ this.getStarsQuantity();
        for(int i = 0; i < this.getSpacesQuantity(); i++)
        {
            result = result^this.getSpaceByNumber(i).hashCode();

        }

        return result;
    }





}
