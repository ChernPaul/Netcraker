package buildings;

import buildings.Factories.DwellingFactory;
import buildings.Factories.OfficeFactory;
import buildings.interfaces.Building;
import buildings.interfaces.BuildingFactory;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import buildings.office.OfficeBuilding;
import java.io.*;
import java.util.Comparator;
import java.util.Scanner;

public class Buildings {


    public static void outputBuilding (Building building, OutputStream out){
        try {
            DataOutputStream dos = new DataOutputStream(out);
            try {
                dos.writeInt(building.getFloorsQuantity());
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(int i = 0; i <building.getFloorsQuantity();i++){
                try {
                    dos.writeInt(building.getFloorByNumber(i).getSpacesQuantity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for(int j = 0; j < building.getFloorByNumber(i).getSpacesQuantity(); j++){

                    try {
                        dos.writeInt(building.getFloorByNumber(i).getSpaceByNumber(j).getRoomsQuantity());
                        dos.writeDouble(building.getFloorByNumber(i).getSpaceByNumber(j).getSquare());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Building inputBuilding (InputStream in){
        OfficeFactory officeFactory = new OfficeFactory();
        setBuildingFactory(officeFactory);
        DataInputStream dis = new DataInputStream(in);
        int floorsQuantity = 0;
        try {
            floorsQuantity = dis.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (floorsQuantity == 0){

            return null;
        }


        Building redBuilding = new OfficeBuilding(floorsQuantity);

        for(int curFloorNum = 0; curFloorNum < floorsQuantity; curFloorNum++){
            int curSpacesQuantity = 0;

            try {
                curSpacesQuantity = dis.readInt();
            } catch (IOException e) {
                e.printStackTrace();
            }



            for(int curSpaceNum = 0; curSpaceNum < curSpacesQuantity;curSpaceNum++){
               int rmsQnt = 0;
               double  square = 0;

                try {
                    rmsQnt = dis.readInt();
                    square = dis.readDouble();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                redBuilding.getFloorByNumber(curFloorNum).addSpace(curSpaceNum, buildingFactory.createSpace(rmsQnt, square));

            }

        }

        return  redBuilding;
        //3     2{ 3 150.0 2 100.0}  1{3 250.0} 3{2 140.0 1 60.0 1 50.0}

    }



    public static void writeBuilding (Building building, Writer out){

        try {
            out.write(building.getFloorsQuantity() + " ");

        for(int i =0; i < building.getFloorsQuantity(); i++){

           out.write(building.getFloorByNumber(i).getSpacesQuantity() + " ");

           for(int j = 0; j < building.getFloorByNumber(i).getSpacesQuantity();j++){
               out.write(building.getFloorByNumber(i).getSpaceByNumber(j).getRoomsQuantity() + " ");
               out.write((building.getFloorByNumber(i).getSpaceByNumber(j).getSquare()) + " ");
           }

        }

       } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static Building readBuilding (Reader in) {
        OfficeFactory officeFactory = new OfficeFactory();
        setBuildingFactory(officeFactory);
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        try {
            tokenizer.nextToken();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        int floorsQuantity = (int) tokenizer.nval;
        if (floorsQuantity == 0) {
            return null;
        }
        int spacesQuantity;
        int roomsQuantity;
        double square;
        Floor[] floorsArr = new Floor[floorsQuantity];
        for (int i = 0; i < floorsQuantity; i++) {
            try {
                tokenizer.nextToken();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            spacesQuantity = (int) tokenizer.nval;
            floorsArr[i] =  buildingFactory.createFloor(spacesQuantity);
            for (int j = 0; j < spacesQuantity; j++) {
                try {
                    tokenizer.nextToken();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                roomsQuantity = (int) tokenizer.nval;
                try {
                    tokenizer.nextToken();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                square = tokenizer.nval;
                floorsArr[i].setSpace(j, buildingFactory.createSpace(roomsQuantity, square));
            }


        }
        return new OfficeBuilding(floorsArr);
    }

    public static void serializeBuilding (Building building, OutputStream out){

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(building);
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
    }

    public static Building deserializeBuilding (InputStream in){
        Building building = null;
        ObjectInputStream inpStream = null;
        try {
            inpStream = new ObjectInputStream(in);
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
        try{
            building = (Building)inpStream.readObject();
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return building;
    }

    public static void writeBuildingFormat (Building building, Writer out){


        ((PrintWriter) out).printf("\tBuilding");
        int floorsQuantity = building.getFloorsQuantity();
        ((PrintWriter) out).printf("\n Floors number: %d", floorsQuantity);
        int spacesQuantity;
        int roomsQuantity;
        double square;
        ((PrintWriter) out).printf("\n");
        for (int i = 0; i < floorsQuantity; i++) {
            spacesQuantity = building.getFloorByNumber(i).getSpacesQuantity();
            ((PrintWriter) out).printf("\n Floor %d", i);
            ((PrintWriter) out).printf("\n Spaces Quantity: %d\n", spacesQuantity );
            for (int j = 0; j < spacesQuantity; j++) {
                roomsQuantity = building.getFloorByNumber(i).getSpaceByNumber(j).getRoomsQuantity();
                square = building.getFloorByNumber(i).getSpaceByNumber(j).getSquare();
                ((PrintWriter) out).printf("\n Rooms: %d  Square: %f\n", roomsQuantity, square );
            }
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static Building readBuilding(Scanner scanner) {
        scanner.skip("\tBuilding");
        scanner.skip("\n Floors number: ");
        int floorsQuantity = scanner.nextInt();
        Floor [] floorsArr = new Floor[floorsQuantity];
        int spacesQuantity;
        int roomsQuantity;
        double square;
        //scanner.skip("\n");
        for(int i = 0; i <floorsQuantity; i++){
            scanner.skip("\n\n Floor " + (i));
            scanner.skip("\n Spaces Quantity: ");
            spacesQuantity = scanner.nextInt();
            floorsArr[i] =  buildingFactory.createFloor(spacesQuantity);
            for(int j =0; j < spacesQuantity; j++ ){
                scanner.skip("\n\n Rooms: ");
                roomsQuantity= scanner.nextInt();
                scanner.skip("  Square: ");
               // System.out.println("1 " + scanner.next() + " 1");
                //square = Double.parseDouble(scanner.next());
                square = scanner.nextDouble();
                floorsArr[i].addSpace(j, buildingFactory.createSpace(roomsQuantity, square));

            }
        }
    Building redBuilding =  buildingFactory.createBuilding(floorsArr);
    return redBuilding;
    }




    public static void sortSpacesBySquare(Space[] spacesArr){
        boolean wasChanges = true;
        Space tmp = null;
        while(wasChanges)
        {
            wasChanges = false;

            for(int i = 0; i < spacesArr.length - 1; i++){

                if(spacesArr[i].compareTo(spacesArr[i+1]) == 1){
                    tmp = spacesArr[i+1];
                    spacesArr[i+1] = spacesArr[i];
                    spacesArr[i] = tmp;
                    wasChanges = true;
                }
            }


        }

    }


    public static void sortFloorsBySpacesQuantity(Floor[] floorsArr) {
        boolean wasChanges = true;
        Floor tmp = null;
        while (wasChanges) {
            wasChanges = false;

            for (int i = 0; i < floorsArr.length - 1; i++) {

                if (floorsArr[i].compareTo(floorsArr[i + 1]) == 1) {
                    tmp = floorsArr[i + 1];
                    floorsArr[i + 1] = floorsArr[i];
                    floorsArr[i] = tmp;
                    wasChanges = true;
                }
            }


        }

    }

    public static <T extends Comparable<T>> void sort(T[] arr){
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - 1; j++){
                T tmp;
                if (arr[j].compareTo(arr[j+1]) > 0){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }


    public static void sortSpacesBySquareCrit(Space [] spacesArr) {
        boolean wasChanges = true;
        Space tmp = null;
        CriteriaForSpaces crit = new CriteriaForSpaces();
        while (wasChanges) {

            wasChanges = false;

            for (int i = 0; i < spacesArr.length - 1; i++) {

                if (crit.compare(spacesArr[i], spacesArr[i + 1]) == 1) {
                    tmp = spacesArr[i + 1];
                    spacesArr[i + 1] = spacesArr[i];
                    spacesArr[i] = tmp;
                    wasChanges = true;
                }
            }


        }
    }

    public static void sortFloorsBySpacesQuantityCrit(Floor[] floorsArr) {
        boolean wasChanges = true;
        Floor tmp = null;
        CriteriaForFloors crit = new CriteriaForFloors();

        while (wasChanges) {
            wasChanges = false;

            for (int i = 0; i < floorsArr.length - 1; i++) {

                if (crit.compare(floorsArr[i],floorsArr[i + 1]) == 1) {
                    tmp = floorsArr[i + 1];
                    floorsArr[i + 1] = floorsArr[i];
                    floorsArr[i] = tmp;
                    wasChanges = true;
                }
            }


        }

    }

    public static <T extends Comparator<T>> void sortComparator(T[] arr, Comparator<T> comparator){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - 1; j++){
                if (comparator.compare(arr[j],arr[j+1]) > 0){
                    T tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static BuildingFactory buildingFactory = new DwellingFactory();
    public static void setBuildingFactory(BuildingFactory newFactory){
        buildingFactory = newFactory;
    }

    public static Space createSpace(double area){
        return buildingFactory.createSpace(area);
    }
    public static Space createSpace(int roomsCount, double area){
        return buildingFactory.createSpace(roomsCount,area);
    }
    public static Floor createFloor(int spacesCount){
        return buildingFactory.createFloor(spacesCount);
    }

    public static Floor createFloor(Space[] spaces){
        return buildingFactory.createFloor(spaces);
    }

    public static Building createBuilding(int floorsCount, int[] spacesCounts){
        return buildingFactory.createBuilding(floorsCount,spacesCounts);
    }
    public static Building createBuilding(Floor[] floors){
        return  buildingFactory.createBuilding(floors);
    }
}




















