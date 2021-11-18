package buildings.threads;
import buildings.interfaces.Floor;
import java.util.concurrent.Semaphore;

public class SequentRepairer extends Thread implements Runnable {

    Floor floor;
    SemaphoreClass sem;
    int threadId = 1;

    public SequentRepairer(SemaphoreClass sem, Floor floor){
        this.sem = sem;
        this.floor = floor;
    }


    @Override
    public void run() {



        try {

            for (int i = 0; i < floor.getSpacesQuantity(); i++) {
                sem.acquire(threadId);
                System.out.println("Repairing space number " + i + " with total area " + floor.getSpaceByNumber(i).getSquare() + " square meters");
                sem.release(threadId);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Execution of Repairer.run ended");

    }
}
