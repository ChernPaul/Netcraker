package buildings.exceptions;

public class FloorIndexOutOfBoundsException extends IndexOutOfBoundsException{
    public FloorIndexOutOfBoundsException(int number, int size) {
        String string = "FloorIndexOutOfBoundsException\nInvalid argument: " + number + "\n Enter number between 0 and " + (size - 1);
        throw new IndexOutOfBoundsException(string);
    }
}
