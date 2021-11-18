package buildings.threads;

import buildings.interfaces.Floor;

public class Cleaner extends Thread{

    Floor floor;

    public Cleaner(Floor floor){
        this.floor = floor;
    }


    @Override
    public void run() {
        super.run();
        for(int i=0; i < floor.getSpacesQuantity(); i++){
            System.out.println("Cleaning space number" + i + "with total area" + floor.getSpaceByNumber(i).getSquare() + " square meters");
        }
        System.out.println("Execution of Cleaner.run ended");
    }







}
