package ObjectPool;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private int counter = 0;
    private List<Object> userList;

    public User() {
        this.userList = new ArrayList<>();
        this.id = ++counter;
    }

    public void drawFromPool(ObjectPool objectPool){
        userList.add(objectPool.release());
        if (userList.get(userList.size()-1)==null){
            userList.remove(userList.size()-1);
        }else
            System.out.println("User: " + this.id + " limit has been reached");
    }

    public void returnToPool(ObjectPool objectPool){
        if (!userList.isEmpty()){
            objectPool.addObject(userList.get(userList.size()-1));
            userList.remove(userList.size()-1);
        }else
            System.out.println("User " + this.id + " has no objects");
    }


    public int getListSize(){
        return userList.size();
    }
}
