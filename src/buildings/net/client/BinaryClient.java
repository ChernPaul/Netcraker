package buildings.net.client;

import buildings.interfaces.Building;
import buildings.Buildings;
import buildings.Factories.DwellingFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class BinaryClient {
    public static void main(String[] args) {

        try(
                Socket socket = new Socket("127.0.0.1", 8000);
                DataOutputStream dos =  new DataOutputStream(socket.getOutputStream());
                DataInputStream dis = new DataInputStream(socket.getInputStream());
            ){

            String type;
            Building building;
            String result;
            String path = "D:\\Рабочий стол\\Practice8\\result.txt";
            FileWriter writer = new FileWriter(new File(path));
            Scanner scanner = new Scanner(new FileReader("D:\\Рабочий стол\\Practice8\\ExistBeforeStartBuildingsTypes.txt"));
            BufferedReader reader = new BufferedReader(new FileReader("D:\\Рабочий стол\\Practice8\\ExistBeforeStartBuildingsInfo.txt"));
            Thread.sleep(5000);
            while(scanner.hasNext()){

                type = scanner.nextLine();
                System.out.println(type);
                Thread.sleep(1000);
                dos.writeUTF(type);
                building = Buildings.readBuilding(reader);
                Thread.sleep(1000);
                Buildings.outputBuilding(building, dos);
                result = dis.readUTF();
                //Thread.sleep(1000);
                writer.write(result + "\n");
                System.out.println(result);
                //totalRes += result + " ";
            }

            writer.close();
            scanner.close();
            reader.close();
            dos.writeUTF("Exit");
            System.out.println("Exit");
            //System.out.println(totalRes);
            dos.flush();
            //scanner.close();
            //reader.close();

            //System.out.println(results);
            //StringTokenizer tokenizer = new StringTokenizer()
            //StringTokenizer tokenizer = new StringTokenizer()
            //byte[] arr = dis.readAllBytes();
            //String str = new String(arr);
        } catch (IOException | InterruptedException e) {
                e.printStackTrace();
        }

        }
}


