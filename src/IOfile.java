import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOfile {

    private static final String filepath = "storage.dat";

    public IOfile() {
    }



    public static boolean WriteObjectToFile(Object serObj) {
        boolean write = false;
        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            //System.out.println("The Object  was succesfully written to a file");
            write = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return write;
    }



    public static Object ReadObjectFromFile() {

        try {

            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            //System.out.println(obj.toString());
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
