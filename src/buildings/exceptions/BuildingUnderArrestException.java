package buildings.exceptions;

public class BuildingUnderArrestException extends IllegalArgumentException {
    public BuildingUnderArrestException() {
        String message = "Building is arrested!";
        try {
            throw new Exception(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
