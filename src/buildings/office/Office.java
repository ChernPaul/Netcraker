package buildings.office;

import buildings.interfaces.Space;
import buildings.exceptions.InvalidRoomsCountException;
import buildings.exceptions.InvalidSpaceAreaException;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class Office implements Space, Serializable,Cloneable {

    private final double standartSquare = 250;
    private final int standartQuantityRooms = 1;

    private double officeSquare;
    private int roomsQuantity;


    public Office() {
        officeSquare = standartSquare;
        roomsQuantity= standartQuantityRooms;
    }

    public Office(double sqr) {
        if(sqr < 5 || sqr > 1000){
            throw new InvalidSpaceAreaException(sqr);
        }
        officeSquare = sqr;
        roomsQuantity= standartQuantityRooms;
    }


    public Office(double sqr, int rmsQnt) {
        if(sqr < 5 || sqr > 1000){
            throw new InvalidSpaceAreaException(sqr);
        }
        officeSquare = sqr;
        if (rmsQnt <= 0 || rmsQnt > 15){
            throw new InvalidRoomsCountException(rmsQnt);
        }
        roomsQuantity= rmsQnt;
    }

    public double getSquare() {
        return officeSquare;
    }

    public int getRoomsQuantity() {
        return roomsQuantity;
    }

    public void setSquare(double officeSquare) {
        this.officeSquare = officeSquare;
    }

    public void setRoomsQuantity(int roomsQuantity) {
        if (roomsQuantity <= 0 || roomsQuantity > 15){
            throw new InvalidRoomsCountException(roomsQuantity);
        }
        this.roomsQuantity = roomsQuantity;
    }

    @Override
    public String toString() {
        return "Office (" + roomsQuantity  + ", " + officeSquare + ')';
    }

    @Override
    public boolean equals(Object object){
        if (object instanceof Office ){
            if( this.getRoomsQuantity() == ((Office) object).getRoomsQuantity() && this.getSquare() == ((Office) object).getSquare()) {
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
        int result;
        byte [] arrDoubleBytes;
        arrDoubleBytes = ByteBuffer.allocate(8).putDouble(this.getSquare()).array();

        byte [] arrFPBytes = new byte[4];
        byte [] arrSPBytes = new byte[4];
        for(int i = 0 ; i < 4; i++){
            arrFPBytes[i] = arrDoubleBytes[i];
            arrSPBytes[i] = arrDoubleBytes[7-i];
        }


        int fp = ByteBuffer.wrap(arrFPBytes).getInt();
        int sp = ByteBuffer.wrap(arrSPBytes).getInt();

        result = this.getRoomsQuantity()^fp^sp;

        return result;
    }

    @Override
    public Object clone(){
        Object result = null;

        try {
            result = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public int compareTo(Space o) {
        if(o instanceof Space) {

            if (this.getSquare() > ((Space) o).getSquare()) {
                return 1;
            } else if (this.getSquare() == ((Space) o).getSquare())
                return 0;

            return -1;
        }
        throw new IllegalArgumentException("Incorrect object type ");


    }

}
