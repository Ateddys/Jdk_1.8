package cn.codesheep.test.thred;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: javaSourceLearn
 * @description: 线层锁
 * @author: Mr.Teddy
 * @create: 2020-09-18 11:51
 **/
public class Test {

    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> testSync());
        Thread t2 = new Thread(() -> testSync());
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();

        System.out.println("main");
    }

    public static void testSync(){
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }
}
