package buildings.dwelling;

import buildings.interfaces.Space;
import buildings.exceptions.InvalidRoomsCountException;
import buildings.exceptions.InvalidSpaceAreaException;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class Flat implements Space, Serializable, Cloneable {

    private final double  standartSquare = 50;
    private final int standartRoomsQuantity = 2;

    private double flatSquare ;
    private int roomsQuantity;

    public Flat(){
        flatSquare = standartSquare;
        roomsQuantity = standartRoomsQuantity;
    }

    public Flat(double fltSqr){
        if (fltSqr < 5 || fltSqr > 1000){
            throw new InvalidSpaceAreaException(fltSqr);
        }
        flatSquare = fltSqr;
        roomsQuantity = standartRoomsQuantity;
    }

    public Flat(double fltSqr, int rmsQnt){
        if (fltSqr < 5 || fltSqr > 1000){
            throw new InvalidSpaceAreaException(fltSqr);
        }
        flatSquare = fltSqr;
        if (rmsQnt <= 0 || rmsQnt > 15){
            throw new InvalidRoomsCountException(rmsQnt);
        }
        roomsQuantity = rmsQnt;
    }


    public int getRoomsQuantity() {
        return roomsQuantity;
    }

    public double getSquare() {
        return flatSquare;
    }

    public void setSquare(double fltSqr) {
        if (fltSqr < 5 || fltSqr > 1000){
            throw new InvalidSpaceAreaException(fltSqr);
        }
        this.flatSquare = fltSqr;
    }

    public void setRoomsQuantity(int rmsQnt) {
        if (rmsQnt <= 0 || rmsQnt > 15){
            throw new InvalidRoomsCountException(rmsQnt);
        }
        this.roomsQuantity = rmsQnt;
    }

    public void printFlatInfo() {
        System.out.println("Square:" + flatSquare);
        System.out.println("RoomsQuantity:" + roomsQuantity);
    }

    @Override
    public String toString() {
        return "Flat (" +  roomsQuantity + ", " + flatSquare +')';
    }


    @Override
    public boolean equals(Object object){
        if (object instanceof Flat ){
            if( this.getRoomsQuantity() == ((Flat) object).getRoomsQuantity() && this.getSquare() == ((Flat) object).getSquare()) {
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
