package buildings;

import buildings.Factories.DwellingFactory;
import buildings.Factories.HotelFactory;
import buildings.Factories.OfficeFactory;
import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.dwelling.hotel.Hotel;
import buildings.dwelling.hotel.HotelFloor;
import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import buildings.office.Office;
import buildings.office.OfficeBuilding;
import buildings.office.OfficeFloor;
import buildings.threads.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {


     /* Office [] officeArr = new Office[5];
        officeArr[0] = new Office(222,2);
        officeArr[1] = new Office(282,10);
        officeArr[2] = new Office(212,3);
        officeArr[3] = new Office(25,5);
        officeArr[4] = new Office(22,7);


        OfficeFloor obj = new OfficeFloor(officeArr);

        Office testoffice = new Office(20,5);

        System.out.println(" [0] " + obj.getSpaceByNumber(0).getSquare() + "  Rooms " + obj.getSpaceByNumber(0).getRoomsQuantity());
        System.out.println(" [1] " + obj.getSpaceByNumber(1).getSquare() + "  Rooms " + obj.getSpaceByNumber(1).getRoomsQuantity());
        System.out.println(" [2] " + obj.getSpaceByNumber(2).getSquare() + "  Rooms " + obj.getSpaceByNumber(2).getRoomsQuantity());
        System.out.println(" [3] " + obj.getSpaceByNumber(3).getSquare() + "  Rooms " + obj.getSpaceByNumber(3).getRoomsQuantity());
        System.out.println(" [4] " + obj.getSpaceByNumber(4).getSquare() + "  Rooms " + obj.getSpaceByNumber(4).getRoomsQuantity());


        System.out.println("Result Rooms " + obj.getFloorRoomsQuantity());
        System.out.println("Result Square " + obj.getTotalFloorSquare());
        System.out.println("Out method result");

        //obj.setSpace(2,testoffice);
        obj.addSpace(1,testoffice);


        System.out.println("New Data");

        System.out.println(" [0] " + obj.getSpaceByNumber(0).getSquare() + "  Rooms " + obj.getSpaceByNumber(0).getRoomsQuantity());
        System.out.println(" [1] " + obj.getSpaceByNumber(1).getSquare() + "  Rooms " + obj.getSpaceByNumber(1).getRoomsQuantity());
        System.out.println(" [2] " + obj.getSpaceByNumber(2).getSquare() + "  Rooms " + obj.getSpaceByNumber(2).getRoomsQuantity());
        System.out.println(" [3] " + obj.getSpaceByNumber(3).getSquare() + "  Rooms " + obj.getSpaceByNumber(3).getRoomsQuantity());
        System.out.println(" [4] " + obj.getSpaceByNumber(4).getSquare() + "  Rooms " + obj.getSpaceByNumber(4).getRoomsQuantity());
        System.out.println(" [5] " + obj.getSpaceByNumber(5).getSquare() + "  Rooms " + obj.getSpaceByNumber(5).getRoomsQuantity());


        System.out.println("Result Rooms " + obj.getFloorRoomsQuantity());
        System.out.println("Result Square " + obj.getTotalFloorSquare());




        Office testOffice = new Office(217.68, 8);

        System.out.println("Result Rooms " + testOffice.getRoomsQuantity());
        System.out.println("Result Square " + testOffice.getSquare());
        System.out.println("Out method result");

        testOffice.setRoomsQuantity(10);
        testOffice.setSquare(10);


        System.out.println("New Data");

        System.out.println("Result Rooms " + testOffice.getRoomsQuantity());
        System.out.println("Result Square " + testOffice.getSquare());


        //////////////////////////////////////////////////////////////////////Practice 4 test



        Flat [] array0 = new Flat[5];
        array0[0] = new Flat(20,2);
        array0[1] = new Flat();
        array0[2] = new Flat(6,10);
        array0[3] = new Flat(32,8);
        array0[4] = new Flat(62.1,8);


        Flat [] array1 = new Flat[5];
        array1[0] = new Flat(27,14);
        array1[1] = new Flat(102.4, 4);
        array1[2] = new Flat(6,11);
        array1[3] = new Flat(31.5,6);
        array1[4] = new Flat(66.1,5);

        Flat [] array2 = new Flat[5];
        array2[0] = new Flat(20,2);
        array2[1] = new Flat(11,1);
        array2[2] = new Flat(14.44,1);
        array2[3] = new Flat(34,4);
        array2[4] = new Flat(72.1,2);



        DwellingFloor [] arr = new  DwellingFloor[] [3];
        arr[0] = new DwellingFloor(array0);
        arr[1] = new DwellingFloor(array1);
        arr[2] = new DwellingFloor(array2);




        Dwelling dwelling = new Dwelling(arr);


        dwelling.printDwellingStructure();

        System.out.println("NEW INFO");



        dwelling.printDwellingStructure();


        System.out.println("NEW INFO");


        Flat [] arka = (Flat[]) dwelling.getSortedSpaceArray();
        for(int i = 0 ; i< 20; i++)
            System.out.println(arka[i].getSquare());




        Space [] arr1 = new Office[5];
        arr1[0] = new Office(12.5,2);
        arr1[1] = new Office(20.5,1);
        arr1[2] = new Office(52.5,4);
        arr1[3] = new Office(44,5);
        arr1[4] = new Office(102.5,6);

        Floor fl1 = new OfficeFloor(arr1);

        Space [] arr2 = new Office[5];
        arr2[0] = new Office(30,5);
        arr2[1] = new Office(30,5);
        arr2[2] = new Office(30,5);
        arr2[3] = new Office(30,5);
        arr2[4] = new Office(30,5);

        Floor fl2 = new OfficeFloor(arr2);

        Space [] arr3 = new Office[5];
        arr3[0] = new Office(22.5,7);
        arr3[1] = new Office(27.5,8);
        arr3[2] = new Office(32.5,9);
        arr3[3] = new Office(37.5,10);
        arr3[4] = new Office(42.5,11);

        Floor fl3 = new OfficeFloor(arr3);

        Floor [] arrFl = new Floor [3];
        arrFl[0] = fl1;
        arrFl[1] = fl2;
        arrFl[2] = fl3;



        Building test = new OfficeBuilding(arrFl);
        try {
            FileOutputStream fileOut = new FileOutputStream("D:\\Рабочий стол\\testbin.bin");
            Buildings.outputBuilding(test,fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Building testInp;

        try {
            FileInputStream fileIn = new FileInputStream("D:\\Рабочий стол\\testbin.bin");
             testInp = Buildings.inputBuilding(fileIn);
            System.out.println(testInp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



            File fileOut = new File("D:\\Рабочий стол\\testtxt.txt");
            FileWriter testWritter = null;
            try {
                testWritter = new FileWriter(fileOut.getAbsoluteFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Buildings.writeBuilding(test, testWritter);
        try {
            testWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileReader testReader = null;
        try {
            testReader = new FileReader(fileOut.getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Building testInp1 = Buildings.readBuilding(testReader);


        System.out.println("new task");

        System.out.println(testInp1);


        try {
            FileOutputStream fOut = new FileOutputStream("D:\\Рабочий стол\\testser.txt");
            Buildings.serializeBuilding(testInp1,fOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


            File fWOut = new File("D:\\Рабочий стол\\testWriter.txt");

            try {
                PrintWriter fw = new PrintWriter(fWOut);
                Buildings.writeBuildingFormat(test,fw);
            } catch (IOException e) {
                e.printStackTrace();
            }

        Building testInp2 = null;
        File fInFormat = new File("D:\\Рабочий стол\\testWriter.txt");

        try {
            Scanner fw = new Scanner(fInFormat);
            testInp2 = Buildings.readBuilding(fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("new task");
        System.out.println(testInp2);

        ////////////////////////////////////////////// End practice 4 test
        //////////////////////////////////////////////Practice 5 Main

        Flat[] flatsArr0 = new Flat[5];
        flatsArr0[0] = new Flat(222.0,2);
        flatsArr0[1] = new Flat(222.0,2);
        flatsArr0[2] = new Flat(6,10);
        flatsArr0[3] = new Flat(32,8);
        flatsArr0[4] = new Flat(62.1,8);


        Flat [] flatsArr1 = new Flat[5];
        flatsArr1[0] = new Flat(222.0,2);
        flatsArr1[1] = new Flat(102.4, 4);
        flatsArr1[2] = new Flat(6,11);
        flatsArr1[3] = new Flat(31.5,6);
        flatsArr1[4] = new Flat(66.1,5);

        Flat [] flatsArr2 = new Flat[5];
        flatsArr2[0] = new Flat(20,2);
        flatsArr2[1] = new Flat(11,1);
        flatsArr2[2] = new Flat(14.44,1);
        flatsArr2[3] = new Flat(34,4);
        flatsArr2[4] = new Flat(72.1,2);

        Flat [] copyFlatsArr0 = new Flat[5];
        copyFlatsArr0[0] = new Flat(222.0,2);
        copyFlatsArr0[1] = new Flat();
        copyFlatsArr0[2] = new Flat(6,10);
        copyFlatsArr0[3] = new Flat(32,8);
        copyFlatsArr0[4] = new Flat(62.1,8);



        DwellingFloor[] arrDwellingFloors = new  DwellingFloor[3];
        arrDwellingFloors[0] = new DwellingFloor(flatsArr0);
        arrDwellingFloors[1] = new DwellingFloor(flatsArr1);
        arrDwellingFloors [2] = new DwellingFloor(flatsArr2);


        DwellingFloor [] copyArrDwellingFloors = new  DwellingFloor[3];
        copyArrDwellingFloors[0] = new DwellingFloor(flatsArr0);
        copyArrDwellingFloors[1] = new DwellingFloor(flatsArr1);
        copyArrDwellingFloors [2] = new DwellingFloor(flatsArr2);


        DwellingFloor [] differentArrDwellingFloors = new  DwellingFloor[4];
        differentArrDwellingFloors[2] = new DwellingFloor(flatsArr0);
        differentArrDwellingFloors[1] = new DwellingFloor(flatsArr1);
        differentArrDwellingFloors [0] = new DwellingFloor(flatsArr2);
        differentArrDwellingFloors [3] = new DwellingFloor(flatsArr2);



        Dwelling testDwelling = new Dwelling(arrDwellingFloors);
        Dwelling copyTestDwelling = new Dwelling(arrDwellingFloors);
        Dwelling differentTestDwelling = new Dwelling(differentArrDwellingFloors);



        Office[] officeArr0 = new Office[5];
        officeArr0[0] = new Office(222.0,2);
        officeArr0[1] = new Office(222.0,2);
        officeArr0[2] = new Office(6,11);
        officeArr0[3] = new Office(31.5,6);
        officeArr0[4] = new Office(66.1,5);

        Office [] officeArr1 = new Office[5];
        officeArr1[0] = new Office(222.0,2);
        officeArr1[1] = new Office(32,6);
        officeArr1[2] = new Office(287,3);
        officeArr1[3] = new Office(115,4);
        officeArr1[4] = new Office(312,8);

        Office [] officeArr2 = new Office[5];
        officeArr2[0] = new Office(222,2);
        officeArr2[1] = new Office(262.51,7);
        officeArr2[2] = new Office(142,5);
        officeArr2[3] = new Office(21.32,5);
        officeArr2[4] = new Office(122.54,10);

        Office [] copyOfficeArr0 = new Office[5];
        copyOfficeArr0[0] = new Office(222.0,2);
        copyOfficeArr0[1] = new Office(282.42,10);
        copyOfficeArr0[2] = new Office(212.22,3);
        copyOfficeArr0[3] = new Office(25.12,5);
        copyOfficeArr0[4] = new Office(22.87,7);


        OfficeFloor[] arrOfficeFloors  = new OfficeFloor [3];
        arrOfficeFloors[0] = new OfficeFloor(officeArr0);
        arrOfficeFloors[1] = new OfficeFloor(officeArr1);
        arrOfficeFloors[2] = new OfficeFloor(officeArr2);

        OfficeFloor [] copyArrOfficeFloors  = new OfficeFloor [3];
        copyArrOfficeFloors[0] = new OfficeFloor(officeArr0);
        copyArrOfficeFloors[1] = new OfficeFloor(officeArr1);
        copyArrOfficeFloors[2] = new OfficeFloor(officeArr2);

        OfficeFloor [] differentArrOfficeFloors  = new OfficeFloor [4];
        differentArrOfficeFloors[2] = new OfficeFloor(officeArr0);
        differentArrOfficeFloors[1] = new OfficeFloor(officeArr1);
        differentArrOfficeFloors[0] = new OfficeFloor(officeArr2);
        differentArrOfficeFloors[3] = new OfficeFloor(officeArr2);




        OfficeBuilding testOfficeBuilding = new OfficeBuilding(arrOfficeFloors);
        OfficeBuilding copyTestOfficeBuilding = new OfficeBuilding(arrOfficeFloors);
        OfficeBuilding differentTestOfficeBuilding = new OfficeBuilding(differentArrOfficeFloors);

        System.out.println(" Checking toString");

        System.out.println(officeArr0[0].toString());
        System.out.println(flatsArr0[0].toString());


        System.out.println(arrOfficeFloors[0].toString());
        System.out.println(arrOfficeFloors[1].toString());
        System.out.println(arrOfficeFloors[2].toString());

        System.out.println(arrDwellingFloors[0].toString());
        System.out.println(arrDwellingFloors[1].toString());
        System.out.println(arrDwellingFloors[2].toString());


        System.out.println(testDwelling.toString());
        System.out.println(testOfficeBuilding.toString());


        System.out.println(" Checking Equals");

        System.out.println(" Checking Equals for Flat");
        System.out.println(flatsArr0[0].equals(copyFlatsArr0[0]));
        System.out.println(flatsArr0[0].equals(copyFlatsArr0[1]));
        System.out.println(flatsArr0[0].equals(officeArr1[0]));

        System.out.println(" Checking Equals for Office");
        System.out.println(officeArr0[0].equals(copyOfficeArr0[0]));
        System.out.println(officeArr0[0].equals(copyOfficeArr0[1]));
        System.out.println(officeArr0[0].equals(flatsArr0[0]));



        System.out.println(" Checking Equals for DwellingFloor");
        System.out.println(arrDwellingFloors[0].equals(copyArrDwellingFloors[0]));
        System.out.println(arrDwellingFloors[0].equals(copyArrDwellingFloors[1]));
        System.out.println(arrDwellingFloors[0].equals(arrOfficeFloors[0]));


        System.out.println(" Checking Equals for OfficeFloor");
        System.out.println(arrOfficeFloors[0].equals(copyArrOfficeFloors[0]));
        System.out.println(arrOfficeFloors[0].equals(copyArrOfficeFloors[1]));
        System.out.println(arrOfficeFloors[0].equals(arrDwellingFloors[0]));

        System.out.println(" Checking Equals for Dwelling");

        System.out.println(testDwelling.equals(copyTestDwelling));
        System.out.println(testDwelling.equals(differentTestDwelling));
        System.out.println(testDwelling.equals(testOfficeBuilding));


        System.out.println(" Checking Equals for OfficeBuilding");

        System.out.println(testOfficeBuilding.equals(copyTestOfficeBuilding));
        System.out.println(testOfficeBuilding.equals(differentTestOfficeBuilding));
        System.out.println(testOfficeBuilding.equals(testDwelling));


        System.out.println(" Checking Hash");
        System.out.println(" Checking Hash for Flat");
        System.out.println(flatsArr0[0].hashCode());
        System.out.println(flatsArr0[1].hashCode());
        System.out.println(flatsArr0[2].hashCode());

        System.out.println(" Checking Hash for Office");
        System.out.println(officeArr0[0].hashCode());
        System.out.println(officeArr0[1].hashCode());
        System.out.println(officeArr0[2].hashCode());

        System.out.println(" Checking Hash for DwellingFloor");
        System.out.println(arrDwellingFloors[0].hashCode());
        System.out.println(copyArrDwellingFloors[0].hashCode());
        System.out.println(differentArrDwellingFloors[0].hashCode());

        System.out.println(" Checking Hash for OfficeFloor");
        System.out.println(arrOfficeFloors[0].hashCode());
        System.out.println(copyArrOfficeFloors[0].hashCode());
        System.out.println(differentArrOfficeFloors[0].hashCode());

        System.out.println(" Checking Hash for Dwelling");
        System.out.println(testDwelling.hashCode());
        System.out.println(copyTestDwelling.hashCode());
        System.out.println(differentTestDwelling.hashCode());

        System.out.println(" Checking Hash for OfficeBuilding");
        System.out.println(testOfficeBuilding.hashCode());
        System.out.println(copyTestOfficeBuilding.hashCode());
        System.out.println(differentTestOfficeBuilding.hashCode());


        System.out.println(" Checking Clone");
        System.out.println(" Checking Clone for Flat");

        Flat cloneFlat = (Flat) flatsArr0[0].clone();
        System.out.println(cloneFlat.toString());

        System.out.println(" Checking Clone for Office");
        Office cloneOffice = (Office) officeArr0[2].clone();
        System.out.println(cloneOffice.toString());

        System.out.println(" Checking Clone for DwellingFloor");
        DwellingFloor cloneDwellingFloor = (DwellingFloor) arrDwellingFloors[0].clone();
        Flat testFlat = new Flat(211, 11);
        Office testOffice = new Office(211, 11);

        cloneDwellingFloor.setSpace(0 , testFlat);
        System.out.println( arrDwellingFloors[0].toString());
        System.out.println(cloneDwellingFloor.toString());




        System.out.println(" Checking Clone for OfficeFloor");
        OfficeFloor cloneOfficeFloor = (OfficeFloor) arrOfficeFloors[0].clone();
        cloneOfficeFloor.setSpace(0 , testOffice);
        System.out.println( arrOfficeFloors[0].toString());
        System.out.println(cloneOfficeFloor.toString());


        System.out.println(" Checking Clone for Dwelling");
        Dwelling cloneDwelling = (Dwelling) testDwelling.clone();
        cloneDwelling.setSpaceByNumber(0, testFlat);
        System.out.println( testDwelling.toString());
        System.out.println(cloneDwelling.toString());


        System.out.println(" Checking Clone for OfficeBuilding");
        OfficeBuilding cloneOfficeBuilding = (OfficeBuilding) testOfficeBuilding.clone();
        cloneOfficeBuilding.setSpaceByNumber(0, testOffice);
        System.out.println( testOfficeBuilding.toString());
        System.out.println(cloneOfficeBuilding.toString());

        /////////////////////////////////////////////////////////////////////////Practice 5 end

        ////////////////////////////////////////////////////////////////////////Practice 6 test
        Flat[] flatsArr0 = new Flat[5];
        flatsArr0[0] = new Flat(222.0,2);
        flatsArr0[1] = new Flat(222.0,2);
        flatsArr0[2] = new Flat(6,10);
        flatsArr0[3] = new Flat(32,8);
        flatsArr0[4] = new Flat(62.1,8);

        Flat [] flatsArr1 = new Flat[5];
        flatsArr1[0] = new Flat(222.0,2);
        flatsArr1[1] = new Flat(102.4, 4);
        flatsArr1[2] = new Flat(6,11);
        flatsArr1[3] = new Flat(31.5,6);
        flatsArr1[4] = new Flat(66.1,5);

        Flat [] flatsArr2 = new Flat[5];
        flatsArr2[0] = new Flat(20,2);
        flatsArr2[1] = new Flat(11,1);
        flatsArr2[2] = new Flat(14.44,1);
        flatsArr2[3] = new Flat(34,4);
        flatsArr2[4] = new Flat(72.1,2);


        HotelFloor[] hotelFloors = new HotelFloor[3];
        hotelFloors[0] = new HotelFloor(flatsArr0);
        hotelFloors[1] = new HotelFloor(flatsArr1);
        hotelFloors[2] = new HotelFloor(flatsArr2);

        Hotel obj = new Hotel(hotelFloors);




        Office[] officeArr0 = new Office[5];
        officeArr0[0] = new Office(222.0,2);
        officeArr0[1] = new Office(222.0,2);
        officeArr0[2] = new Office(6,11);
        officeArr0[3] = new Office(31.5,6);
        officeArr0[4] = new Office(66.1,5);

        Office [] officeArr1 = new Office[5];
        officeArr1[0] = new Office(222.0,2);
        officeArr1[1] = new Office(32,6);
        officeArr1[2] = new Office(287,3);
        officeArr1[3] = new Office(115,4);
        officeArr1[4] = new Office(312,8);

        Office [] officeArr2 = new Office[5];
        officeArr2[0] = new Office(222,2);
        officeArr2[1] = new Office(262.51,7);
        officeArr2[2] = new Office(142,5);
        officeArr2[3] = new Office(21.32,5);
        officeArr2[4] = new Office(122.54,10);


        OfficeFloor[] arrOfficeFloors  = new OfficeFloor [3];
        arrOfficeFloors[0] = new OfficeFloor(officeArr0);
        arrOfficeFloors[1] = new OfficeFloor(officeArr1);
        arrOfficeFloors[2] = new OfficeFloor(officeArr2);



        OfficeBuilding offObj = new OfficeBuilding(arrOfficeFloors);

        System.out.println( hotelFloors[0].toString());
        hotelFloors[1].setStarsQuantity(4);
        System.out.println( hotelFloors[1].toString());
        System.out.println( hotelFloors[2].toString());
        System.out.println( obj.toString());

        System.out.println("TEST");
        for(Space cur:offObj.getFloorByNumber(1))
        {
            System.out.println((cur).toString());
        }


        for(Floor cur:offObj)
        {
            System.out.println( cur.toString());
        }


        System.out.println("TEST");
        System.out.println(obj.getFloorByNumber(0).toString());
        Buildings.sortSpacesBySquareCrit(obj.getFloorByNumber(0).getSpacesArray());
        System.out.println("TEST");
        System.out.println(obj.getFloorByNumber(0).toString());

        /////////////////////////////////////////////////////////End practice 6 test
        ///////////////////////////////////////////////////////// Practice 7 Main


        Office[] officeArr0 = new Office[5];
        officeArr0[0] = new Office(222.0,2);
        officeArr0[1] = new Office(222.0,2);
        officeArr0[2] = new Office(6,11);
        officeArr0[3] = new Office(31.5,6);
        officeArr0[4] = new Office(66.1,5);

        Office [] officeArr1 = new Office[5];
        officeArr1[0] = new Office(222.0,2);
        officeArr1[1] = new Office(32,6);
        officeArr1[2] = new Office(287,3);
        officeArr1[3] = new Office(115,4);
        officeArr1[4] = new Office(312,8);

        Office [] officeArr2 = new Office[5];
        officeArr2[0] = new Office(222,2);
        officeArr2[1] = new Office(262.51,7);
        officeArr2[2] = new Office(142,5);
        officeArr2[3] = new Office(21.32,5);
        officeArr2[4] = new Office(122.54,10);


        OfficeFloor[] arrOfficeFloors  = new OfficeFloor [3];
        arrOfficeFloors[0] = new OfficeFloor(officeArr0);
        arrOfficeFloors[1] = new OfficeFloor(officeArr1);
        arrOfficeFloors[2] = new OfficeFloor(officeArr2);

        Repairer rep = new Repairer(arrOfficeFloors[0]);
        Cleaner cln = new Cleaner(arrOfficeFloors[0]);
        rep.start();
        cln.start();
        try {
            Thread.sleep(9);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rep.interrupt();
        System.out.println("Interrupt");

        /*

        System.out.println("TASK 2");


        SemaphoreClass testSem = new SemaphoreClass(2, false);
        SequentRepairer seqRep = new SequentRepairer(testSem, arrOfficeFloors[0]);
        SequentCleaner seqCln = new  SequentCleaner(testSem,arrOfficeFloors[0]);


        seqRep.start();
        seqCln.start();

        /////////////////////////////////////End practice 7 Main


        ////////////////////////////////////////////////////Check serialize
        Flat [] array0 = new Flat[5];
        array0[0] = new Flat(20,2);
        array0[1] = new Flat();
        array0[2] = new Flat(6,10);
        array0[3] = new Flat(32,8);
        array0[4] = new Flat(62.1,8);


        Flat [] array1 = new Flat[5];
        array1[0] = new Flat(27,14);
        array1[1] = new Flat(102.4, 4);
        array1[2] = new Flat(6,11);
        array1[3] = new Flat(31.5,6);
        array1[4] = new Flat(66.1,5);

        Flat [] array2 = new Flat[5];
        array2[0] = new Flat(20,2);
        array2[1] = new Flat(11,1);
        array2[2] = new Flat(14.44,1);
        array2[3] = new Flat(34,4);
        array2[4] = new Flat(72.1,2);



        DwellingFloor [] arr = new  DwellingFloor [3];
        arr[0] = new DwellingFloor(array0);
        arr[1] = new DwellingFloor(array1);
        arr[2] = new DwellingFloor(array2);

        System.out.println("Before deserialize Building");
        Dwelling testBuilding = new Dwelling(arr);
        System.out.println(testBuilding.toString());



        try {
            FileOutputStream fout = new FileOutputStream("D:\\Рабочий стол\\SerCheck.txt");
            Buildings.serializeBuilding(testBuilding, fout);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Building newBuilding = null;
        try {
            FileInputStream fin = new FileInputStream("D:\\Рабочий стол\\SerCheck.txt");
            newBuilding = Buildings.deserializeBuilding(fin);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("AfterDeserialize Building");
        System.out.println(newBuilding.toString());
        ////////////////////////////////////////////////////End check serialize


        ////////////////////////////////////////////////////Start check Practice 7
        Office[] officeArr0 = new Office[5];
        officeArr0[0] = new Office(222.0,2);
        officeArr0[1] = new Office(222.0,2);
        officeArr0[2] = new Office(6,11);
        officeArr0[3] = new Office(31.5,6);
        officeArr0[4] = new Office(66.1,5);

        Office [] officeArr1 = new Office[5];
        officeArr1[0] = new Office(222.0,2);
        officeArr1[1] = new Office(32,6);
        officeArr1[2] = new Office(287,3);
        officeArr1[3] = new Office(115,4);
        officeArr1[4] = new Office(312,8);

        Office [] officeArr2 = new Office[5];
        officeArr2[0] = new Office(222,2);
        officeArr2[1] = new Office(262.51,7);
        officeArr2[2] = new Office(142,5);
        officeArr2[3] = new Office(21.32,5);
        officeArr2[4] = new Office(122.54,10);


        OfficeFloor[] arrOfficeFloors  = new OfficeFloor [3];
        arrOfficeFloors[0] = new OfficeFloor(officeArr0);
        arrOfficeFloors[1] = new OfficeFloor(officeArr1);
        arrOfficeFloors[2] = new OfficeFloor(officeArr2);





        Repairer rep = new Repairer(arrOfficeFloors[0]);
        Cleaner cln = new Cleaner(arrOfficeFloors[0]);
        rep.start();
        cln.start();
        try {
            Thread.sleep(9);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //rep.interrupt();
        System.out.println("Interrupt");



        System.out.println("TASK 2");


        SemaphoreClass testSem = new SemaphoreClass(2, false);
        SequentRepairer seqRep = new SequentRepairer(testSem, arrOfficeFloors[0]);
        SequentCleaner seqCln = new  SequentCleaner(testSem,arrOfficeFloors[0]);


        seqRep.start();
        seqCln.start();


        ////////////////////////////////////////////////////End check Practice 7
        */

        ////////////////////////////////////////////////////Start check Practice 8  12 nodes

        OutputStream out = null;
        try {
            out = new FileOutputStream("D:\\Рабочий стол\\Practice8\\ExistBeforeStartBuildingsInfo.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        Flat [] array0 = new Flat[5];
        array0[0] = new Flat(20,2);
        array0[1] = new Flat();
        array0[2] = new Flat(6,10);
        array0[3] = new Flat(32,8);
        array0[4] = new Flat(62.1,8);


        Flat [] array1 = new Flat[5];
        array1[0] = new Flat(27,14);
        array1[1] = new Flat(102.4, 4);
        array1[2] = new Flat(6,11);
        array1[3] = new Flat(31.5,6);
        array1[4] = new Flat(66.1,5);

        Flat [] array2 = new Flat[5];
        array2[0] = new Flat(20,2);
        array2[1] = new Flat(11,1);
        array2[2] = new Flat(14.44,1);
        array2[3] = new Flat(34,4);
        array2[4] = new Flat(72.1,2);

        Flat [] array3 = new Flat[5];
        array3[0] = new Flat(120,2);
        array3[1] = new Flat(145,3);
        array3[2] = new Flat(54.44,5);
        array3[3] = new Flat(54,4);
        array3[4] = new Flat(32.1,7);

        Flat [] array4 = new Flat[5];
        array4[0] = new Flat(15,2);
        array4[1] = new Flat();
        array4[2] = new Flat(67,7);
        array4[3] = new Flat(32,4);
        array4[4] = new Flat(52.1,4);




        Office[] officeArr0 = new Office[5];
        officeArr0[0] = new Office(222.0,2);
        officeArr0[1] = new Office(222.0,2);
        officeArr0[2] = new Office(6,11);
        officeArr0[3] = new Office(31.5,6);
        officeArr0[4] = new Office(66.1,5);

        Office [] officeArr1 = new Office[5];
        officeArr1[0] = new Office(222.0,2);
        officeArr1[1] = new Office(32,6);
        officeArr1[2] = new Office(287,3);
        officeArr1[3] = new Office(115,4);
        officeArr1[4] = new Office(312,8);

        Office [] officeArr2 = new Office[5];
        officeArr2[0] = new Office(222,2);
        officeArr2[1] = new Office(262.51,7);
        officeArr2[2] = new Office(142,5);
        officeArr2[3] = new Office(21.32,5);
        officeArr2[4] = new Office(122.54,10);

        Office [] officeArr3 = new Office[4];
        officeArr3[0] = new Office(212,5);
        officeArr3[1] = new Office(232.51,3);
        officeArr3[2] = new Office(12,5);
        officeArr3[3] = new Office(21.32,5);

        Office [] officeArr4 = new Office[5];
        officeArr4[0] = new Office(21.0,2);
        officeArr4[1] = new Office(35,6);
        officeArr4[2] = new Office(17,3);
        officeArr4[3] = new Office(15,4);
        officeArr4[4] = new Office(12,8);




        HotelFloor hfl1 = new HotelFloor(array4);
        HotelFloor hfl2 = new HotelFloor(array3);
        HotelFloor hfl3 = new HotelFloor(array2);
        HotelFloor hfl4 = new HotelFloor(array1);
        HotelFloor hfl5 = new HotelFloor(array0);

        DwellingFloor dfl1 = new DwellingFloor(array0);
        DwellingFloor dfl2 = new DwellingFloor(array1);
        DwellingFloor dfl3 = new DwellingFloor(array2);
        DwellingFloor dfl4 = new DwellingFloor(array3);
        DwellingFloor dfl5 = new DwellingFloor(array4);

        OfficeFloor ofl1 = new OfficeFloor(officeArr0);
        OfficeFloor ofl2 = new OfficeFloor(officeArr1);
        OfficeFloor ofl3 = new OfficeFloor(officeArr2);
        OfficeFloor ofl4 = new OfficeFloor(officeArr3);
        OfficeFloor ofl5 = new OfficeFloor(officeArr4);

        DwellingFloor[] ardfl1 = new DwellingFloor[3];
        ardfl1[0] = dfl1;
        ardfl1[1] = dfl4;
        ardfl1[2] = dfl5;


        DwellingFloor[] ardfl2 = new DwellingFloor[4];
        ardfl2[0] = dfl3;
        ardfl2[1] = dfl2;
        ardfl2[2] = dfl4;
        ardfl2[3] = dfl5;



        DwellingFloor[] ardfl3 = new DwellingFloor[5];
        ardfl3[0] = dfl5;
        ardfl3[1] = dfl4;
        ardfl3[2] = dfl3;
        ardfl3[3] = dfl2;
        ardfl3[4] = dfl1;


        DwellingFloor[] ardfl4 = new DwellingFloor[2];
        ardfl4[0] = dfl4;
        ardfl4[1] = dfl5;




        HotelFloor[] arhfl1 = new HotelFloor[3];
        arhfl1[0] = hfl1;
        arhfl1[1] = hfl4;
        arhfl1[2] = hfl5;

        HotelFloor[] arhfl2 = new HotelFloor[5];
        arhfl2[0] = hfl1;
        arhfl2[1] = hfl4;
        arhfl2[2] = hfl5;
        arhfl2[3] = hfl2;
        arhfl2[4] = hfl1;


        HotelFloor[] arhfl3 = new HotelFloor[5];
        arhfl3[0] = hfl1;
        arhfl3[1] = hfl1;
        arhfl3[2] = hfl2;
        arhfl3[3] = hfl2;
        arhfl3[4] = hfl3;

        HotelFloor[] arhfl4 = new HotelFloor[4];
        arhfl4[0] = hfl4;
        arhfl4[1] = hfl3;
        arhfl4[2] = hfl2;
        arhfl4[3] = hfl1;

        OfficeFloor[] arofl1 = new OfficeFloor[5];
        arofl1[0] = ofl1;
        arofl1[1] = ofl2;
        arofl1[2] = ofl3;
        arofl1[3] = ofl4;
        arofl1[4] = ofl5;

        OfficeFloor[] arofl2 = new OfficeFloor[3];

        arofl2[0] = ofl3;
        arofl2[1] = ofl4;
        arofl2[2] = ofl5;


        OfficeFloor[] arofl3 = new OfficeFloor[3];
        arofl3[0] = ofl1;
        arofl3[1] = ofl2;
        arofl3[2] = ofl3;

        OfficeFloor[] arofl4 = new OfficeFloor[4];
        arofl4[0] = ofl4;
        arofl4[1] = ofl3;
        arofl4[2] = ofl2;
        arofl4[3] = ofl1;



        Hotel ht1 = new Hotel(arhfl1);
        Hotel ht2 = new Hotel(arhfl2);
        Hotel ht3 = new Hotel(arhfl3);
        Hotel ht4 = new Hotel(arhfl4);

        Dwelling dw1 = new Dwelling(ardfl1);
        Dwelling dw2 = new Dwelling(ardfl2);
        Dwelling dw3 = new Dwelling(ardfl3);
        Dwelling dw4 = new Dwelling(ardfl4);

        OfficeBuilding ofb1 = new OfficeBuilding(arofl1);
        OfficeBuilding ofb2 = new OfficeBuilding(arofl2);
        OfficeBuilding ofb3 = new OfficeBuilding(arofl3);
        OfficeBuilding ofb4 = new OfficeBuilding(arofl4);



        /*

        Buildings.outputBuilding(dw1,out);
        System.out.println();
        System.out.println();

        Buildings.outputBuilding(dw2,out);
        System.out.println();
        System.out.println();
        Buildings.outputBuilding(ht1,out);
        System.out.println();
        System.out.println();
        Buildings.outputBuilding(ht2,out);
        System.out.println();
        System.out.println();


        Buildings.outputBuilding(dw3,out);
        System.out.println();
        System.out.println();
        Buildings.outputBuilding(ofb1,out);
        System.out.println();
        System.out.println();
        Buildings.outputBuilding(ht3,out);
        System.out.println();
        System.out.println();


        Buildings.outputBuilding(ofb2,out);
        System.out.println();
        System.out.println();
        Buildings.outputBuilding(ofb3,out);
        System.out.println();
        System.out.println();
        Buildings.outputBuilding(ht4,out);
        System.out.println();
        System.out.println();


        Buildings.outputBuilding(dw4,out);
        System.out.println();
        System.out.println();
        Buildings.outputBuilding(ofb4,out);


        */


    }

}

