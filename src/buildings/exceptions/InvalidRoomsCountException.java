package buildings.exceptions;

public class InvalidRoomsCountException extends IllegalArgumentException {
    public InvalidRoomsCountException(int number) {
        String string = "InvalidRoomsCountException\n Invalid argument: " + number + "\n Enter number between 1 and 15";
        throw new IllegalArgumentException(string);
    }
}
