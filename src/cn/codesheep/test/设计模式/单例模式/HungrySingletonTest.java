package cn.codesheep.test.设计模式.单例模式;

/**
 * @program: javaSourceLearn
 * @description: 饿汉式
 * @author: Mr.Teddy
 * @create: 2020-09-21 11:09
 **/
public class HungrySingletonTest {

    public static void main(String[] args) {

        new Thread(() -> {
            HungrySingleton instance = HungrySingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(() -> {
            HungrySingleton instance = HungrySingleton.getInstance();
            System.out.println(instance);
        }).start();
    }
}

class HungrySingleton {

    // 类加载机制  保证线程安全
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }
}
