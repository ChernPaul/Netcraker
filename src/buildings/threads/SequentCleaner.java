package buildings.threads;

import buildings.interfaces.Floor;
import java.util.concurrent.Semaphore;

public class SequentCleaner extends Thread implements Runnable {

    Floor floor;
    SemaphoreClass sem;

    public SequentCleaner(SemaphoreClass sem, Floor floor){
        this.sem = sem;
        this.floor = floor;
    }


    @Override
    public void run() {

        try {

            for (int i = 0; i < floor.getSpacesQuantity(); i++) {
                sem.acquire(2);
                System.out.println("Cleaning space number " + i + " with total area " + floor.getSpaceByNumber(i).getSquare() + " square meters");
                sem.release(2);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Execution of Cleaner.run ended");

    }
}
