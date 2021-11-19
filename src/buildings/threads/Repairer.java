package buildings.threads;
import buildings.interfaces.Floor;

import java.io.OutputStream;
import java.io.PrintStream;

public class Repairer extends Thread {

    Floor floor;

    public Repairer(Floor floor){
        this.floor = floor;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < floor.getSpacesQuantity() && (!isInterrupted()); i++) {
            System.out.println("Repairing space number " + i + " with total area " + floor.getSpaceByNumber(i).getSquare() + " square meters");
        }
        System.out.println("Execution of Repairer.run ended");
    }




}
