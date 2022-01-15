package ObjectPool;

import java.util.ArrayList;
import java.util.List;

public class ObjectPool {

    private static ObjectPool instance = null;
    private static List<Object> objectList = null;
    private static int objectNr = 0;

    private ObjectPool(){
        objectList = new ArrayList<>();
    }
    public static ObjectPool getInstance(){
        if (instance == null){
            instance = new ObjectPool();
        }
        return instance;
    }

    public static void printNumber(){
        System.out.println("Number of objects: " + objectNr);
    }

    public void addObject(Object object){
        if (objectList.size()<5){
            objectList.add(object);
        }
    }
    public boolean limitReached(){
        return objectNr >=6;
    }

    public Object release(){
        if (objectList.isEmpty() && ! limitReached()){
            objectNr++;
            return new Object();
        }else if (!objectList.isEmpty()){
            Object object = objectList.get(objectList.size()-1);
            objectList.remove(objectList.size()-1);
            return object;
        }else
            return null;
    }
    public int getListSize(){
        return objectList.size();
    }
}
