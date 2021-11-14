package buildings.interfaces;

import lists.SingleSideList;

public interface Floor extends Cloneable, Comparable<Floor>, Iterable<Space>{
    int getSpacesQuantity();
    double getTotalFloorSquare();
    int getFloorRoomsQuantity();
    Space[] getSpacesArray();
    Space getSpaceByNumber(int num);
    void setSpace(int num, Space newSpace);
    void addSpace(int num, Space newSpace);
    void removeSpace(int num);
    Space getBestSpace();
    Object clone();
    }