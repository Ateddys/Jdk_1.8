package cn.codesheep.test.设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javaSourceLearn
 * @description: 观察者实现
 * @author: Mr.Teddy
 * @create: 2020-09-22 10:22
 **/
public class ObserverTest {
    public static void main(String[] args) {
        Suject suject = new Suject();

        Test1 test1 = new Test1();
        Test2 test2 = new Test2();

        suject.addObserver(test1);
        suject.addObserver(test2);

        suject.notifyObserver("你好你好你好. ");

        suject.removeObserver(test2);

        suject.notifyObserver("哎哎哎哎哎. ");



    }
}

interface Observe {
    void update(Object object);
    void update2(Object object);
}

class Suject {
    // 容器
    private List<Observe> container = new ArrayList<>();

    // 添加
    public void addObserver(Observe observe) {
        container.add(observe);
    }

    // 删除
    public void removeObserver(Observe observe) {
        container.remove(observe);
    }

    // 发布数据
    public void notifyObserver(Object object) {
        for (Observe observe : container) { // 遍历客户  进行指定方法发送
            observe.update(object);
            observe.update2(object);
        }
    }
}

// 内容1
class Test1 implements Observe {

    @Override
    public void update(Object object) {
        System.out.println("test1 observe ：" + object);
    }

    @Override
    public void update2(Object object) {
        System.out.println("test1 observe2 ：" + object);
    }
}
// 内容2
class Test2 implements Observe {

    @Override
    public void update(Object object) {
        System.out.println("test2 observe ：" + object);
    }

    @Override
    public void update2(Object object) {
        System.out.println("test2 observe2 ：" + object);
    }
}