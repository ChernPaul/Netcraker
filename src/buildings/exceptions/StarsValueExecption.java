package buildings.exceptions;

import buildings.interfaces.Floor;

public class StarsValueExecption extends IllegalArgumentException {

    public StarsValueExecption(){
        String string = "Stars value should be from 1 to 5";
        throw new IllegalArgumentException(string);
    }

}
