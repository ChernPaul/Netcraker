package buildings.interfaces;

public interface Space extends Cloneable, Comparable<Space>{
    int getRoomsQuantity();
    double getSquare();
    void setRoomsQuantity(int num);
    void setSquare(double square);
    Object clone();
}
