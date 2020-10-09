package cn.codesheep.test.设计模式.单例模式;

/**
 * @program: javaSourceLearn
 * @description: 单例模式(懒加载单例)
 * @author: Mr.Teddy
 * @create: 2020-09-21 10:04
 **/
public class LazySingletonTest {

    public static void main(String[] args) {
        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(() -> {
            LazySingleton instance2 = LazySingleton.getInstance();
            System.out.println(instance2);
        }).start();
    }
}

class LazySingleton {

    private volatile static LazySingleton instance;

    private LazySingleton () {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized(LazySingleton.class) { // 加锁 保证线程安全
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
