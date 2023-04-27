package storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile<T> {
    private static ReadWriteFile INSTANCE = null;
    private ReadWriteFile (){

    }
    public static ReadWriteFile getINSTANCE(){
        if(INSTANCE==null)
            INSTANCE = new ReadWriteFile();
        return INSTANCE;
    }
    public List<T> readData(String path){
        List<T> list = new ArrayList<T>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<T>) ois.readObject();
            fis.close();
            ois.close();
            System.out.println("Read file successfully: " + list);
        } catch (IOException e){
            System.out.println("Read file fail: " + e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Find not found: " + e);
        }
        return list;
    }
    public void writeData(List<T> list, String path){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            fos.close();
            oos.close();
            System.out.println("Write file successful: "  + oos.toString());
        } catch (IOException e){
            System.out.println("Write file fail : " + e);
        }

    }

}
