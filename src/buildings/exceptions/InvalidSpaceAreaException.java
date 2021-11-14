package buildings.exceptions;

public class InvalidSpaceAreaException extends IllegalArgumentException {
    public InvalidSpaceAreaException(double space){
        String string = "InvalidSpaceAreaException\n Invalid argument: " + space + "\n Enter space between 5 and 1000";
        throw new IllegalArgumentException(string);
    }
}
