package buildings.exceptions;

public class SpaceIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public SpaceIndexOutOfBoundsException(int number, int size){
        String string = "SpaceIndexOutOfBoundsException\nInvalid argument: " + number + "\n Enter number between 0 and " + (size - 1);
        throw new IndexOutOfBoundsException(string);
    }

}
