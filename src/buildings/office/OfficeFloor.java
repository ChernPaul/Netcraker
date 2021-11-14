package buildings.office;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import buildings.exceptions.SpaceIndexOutOfBoundsException;
import buildings.iterators.DwellingFloorIterator;
import buildings.iterators.OfficeBuildingIterator;
import buildings.iterators.OfficeFloorIterator;
import lists.ListNode;
import lists.SingleSideList;
import java.io.Serializable;
import java.util.Iterator;

public class OfficeFloor implements Floor, Serializable,Cloneable {

   private SingleSideList spacesList;

    public OfficeFloor() {
        spacesList = new SingleSideList();
    }

   public OfficeFloor(int number) {
        spacesList = new SingleSideList(number);
    }

    public OfficeFloor(Space[] offices) {
        spacesList = new SingleSideList();
        for (int i = 0; i < offices.length; i++){
            spacesList.pushBack(offices[i]);
        }

    }
    private ListNode getNodeByNumber(int number) {
        if (number < 0 || number > getSpacesQuantity()){
            throw new SpaceIndexOutOfBoundsException(number, getSpacesQuantity());
        }
        return spacesList.getNode(number);
    }

    private void addByNum(Office office, int number){
        if (number < 0 || number > getSpacesQuantity()){
            throw new SpaceIndexOutOfBoundsException(number, getSpacesQuantity());
        }
        spacesList.insert(office, number);
    }

    private void removeByNum(int number){
        if (number < 0 || number > getSpacesQuantity()){
            throw new SpaceIndexOutOfBoundsException(number, getSpacesQuantity());
        }
        spacesList.remove(number);
    }

    public int getSpacesQuantity() {
       return spacesList.lenght();
    }

    public double getTotalFloorSquare(){
        int square = 0;
        for (int i = 0; i < spacesList.lenght(); i++){
            square += spacesList.getNode(i).getSpace().getSquare();
        }
        return square;
    }

    public int getFloorRoomsQuantity() {
        int rooms = 0;
        for (int i = 0; i < spacesList.lenght(); i++){
            rooms += spacesList.getNode(i).getSpace().getRoomsQuantity();
        }
        return rooms;
    }


    public Space[] getSpacesArray(){
        Space[] tmp = new Office[spacesList.lenght()];
        for (int i = 0; i < spacesList.lenght(); i++){
            tmp[i] = spacesList.getNode(i).getSpace();
        }
        return tmp;
    }



    public Space getSpaceByNumber(int number){
        if(number > spacesList.lenght()){
            throw new SpaceIndexOutOfBoundsException(number, getSpacesQuantity());
        }
       return spacesList.getNode(number).getSpace();
    }

    public void setSpace(int number, Space newSpace){
        if(number > spacesList.lenght()){
            throw new SpaceIndexOutOfBoundsException(number, getSpacesQuantity());
        }
        if (newSpace instanceof Office) {

            spacesList.getNode(number).setSpace((Office)newSpace);
        }
    }

    public void addSpace(int number, Space newOffice){
        if(number > spacesList.lenght()){
            throw new SpaceIndexOutOfBoundsException(number, getSpacesQuantity());
        }
        if (newOffice instanceof Office) {

            addByNum((Office) newOffice, number);
        }
    }

    public void removeSpace(int number){
        if(number > spacesList.lenght()){
            throw new SpaceIndexOutOfBoundsException(number, getSpacesQuantity());
        }
        removeByNum(number);
    }

    public Space getBestSpace(){
        Space tmp = new Office();
        for (int i = 0; i < spacesList.lenght(); i++){
            if (tmp.getSquare() < spacesList.getNode(i).getSpace().getSquare())
                tmp = spacesList.getNode(i).getSpace();
        }
        return tmp;
    }
     public SingleSideList getSpacesList(){
       return spacesList;
     }


     public void setSpacesList(SingleSideList listPtr){
        spacesList = listPtr;
     }


    @Override
    public String toString() {

        StringBuffer result = new StringBuffer();
        result.append("OfficeFloor (" + this.getSpacesQuantity() + ",");

        for (int i = 0; i < this.getSpacesQuantity() - 1; i++){
            result.append(" " + getSpaceByNumber(i).toString() + ",");
        }
        result.append(" " + getSpaceByNumber(this.getSpacesQuantity() - 1).toString() + ")");

        return  result.toString();
    }

    @Override
    public boolean equals(Object object){
        if (object instanceof OfficeFloor ){
            if (this.getSpacesQuantity() == ((OfficeFloor) object).getSpacesQuantity()){

                for(int i = 0; i < this.getSpacesQuantity(); i++){
                    if(!this.getSpaceByNumber(i).equals(((OfficeFloor) object).getSpaceByNumber(i))){
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
        int result = this.getSpacesQuantity();
        for(int i = 0; i < this.getSpacesQuantity(); i++)
        {
            result = result^this.getSpaceByNumber(i).hashCode();

        }

        return result;
    }


    @Override
    public Object clone(){
        Object result = null;
        SingleSideList prepareSpacesList = new SingleSideList();

        for(int i = 0; i < spacesList.lenght(); i++){

            Space prepareOffice = this.getNodeByNumber(i).getSpace();
            prepareSpacesList.pushBack((Space) prepareOffice.clone());
        }

        try {
            result = super.clone();
            ((OfficeFloor) result).setSpacesList(prepareSpacesList);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }




        return result;
    }


    @Override
    public Iterator<Space> iterator(){
        return new OfficeFloorIterator(this);
    }

    @Override
    public int compareTo(Floor o) {
        if(o instanceof Floor) {

            if (this.getSpacesQuantity() > ((Floor) o).getSpacesQuantity()) {
                return 1;
            } else if (this.getSpacesQuantity() == ((Floor) o).getSpacesQuantity())
                return 0;

            return -1;
        }
        throw new IllegalArgumentException("Incorrect object type ");


    }

}
