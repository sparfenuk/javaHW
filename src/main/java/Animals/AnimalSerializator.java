package Animals;

import java.io.*;
import java.util.ArrayList;

public class AnimalSerializator  {
    public static boolean Serialize(ArrayList<Animal> animalList) {
        try {
            FileOutputStream fos = new FileOutputStream("animals.anm");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(animalList);
            fos.close();
            oos.close();
            return true;

        }
        catch (Exception e){return false;}
    }


    public static ArrayList<Animal> Deserialize(){
        try {

            ArrayList <Animal> animalList = new ArrayList<Animal>();

            FileInputStream fis = new FileInputStream("animals.anm");
            ObjectInputStream oin = new ObjectInputStream(fis);
            animalList = (ArrayList) oin.readObject();

            oin.close();
            fis.close();

            return animalList;
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return null;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return null;
        }


    }
}
