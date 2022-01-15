package ObjectPool;

public class main {

    public static void main(String[] args) {

        User user_1 = new User();
        User user_2 = new User();
        ObjectPool objectPool = ObjectPool.getInstance();

        user_1.drawFromPool(objectPool);
        user_1.drawFromPool(objectPool);
        user_1.drawFromPool(objectPool);
        user_1.drawFromPool(objectPool);
        user_1.drawFromPool(objectPool);

        user_2.drawFromPool(objectPool);
        user_2.drawFromPool(objectPool);
        user_2.drawFromPool(objectPool);
        user_2.drawFromPool(objectPool);
        user_2.drawFromPool(objectPool);

        user_2.returnToPool(objectPool);
        user_1.returnToPool(objectPool);
        user_1.returnToPool(objectPool);
        user_1.returnToPool(objectPool);

        System.out.println("User objects: " + user_1.getListSize());
        System.out.println("User objects: " + user_2.getListSize());
        ObjectPool.printNumber();

    }
}
