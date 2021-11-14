package buildings.interfaces;

public interface Building extends Cloneable, Iterable<Floor>{
    int getFloorsQuantity();
    int getSpacesQuantity();
    double getTotalSquare();
    int getRoomsQuantity();
    Floor[] getFloorsArray();
    Floor getFloorByNumber(int num);
    void setFloorByNumber(int num, Floor floor);
    Space getSpaceByNumber(int num);
    void setSpaceByNumber(int num, Space space);
    void addSpaceByNumber(int num, Space space);
    void removeSpaceByNumber(int num);
    Space getBestSpace();
    Object clone();

}
