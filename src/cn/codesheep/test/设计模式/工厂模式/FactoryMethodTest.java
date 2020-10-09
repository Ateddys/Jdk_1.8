package cn.codesheep.test.设计模式.工厂模式;

/**
 * @program: javaSourceLearn
 * @description: 工厂模式
 * @author: Mr.Teddy
 * @create: 2020-09-21 15:14
 **/
public class FactoryMethodTest {
    public static void main(String[] args) {
        Application application = new Application();

        // 测试  龟兔
        System.out.println("赛道总长20米");

        Thread t1 = new Thread(() -> {
            Run gui = application.getObject("乌龟");
            try {
                gui.$1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.setName("乌龟");
        t1.start();

        Thread t2 = new Thread(() -> {
            Run tu = application.getObject("兔子");
            try {
                tu.$1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.setName("兔子");
        t2.start();
    }
}

// 主入口
class Application {
    private Run create_$1(String type) {
        return SimpleFactory.create_$1(type);
    }
    Run getObject(String type) {
        return create_$1(type);
    }
}

// 公共接口 （跑）
interface Run {
    public void $1() throws InterruptedException;
}

// 工厂
class SimpleFactory {
    public static Run create_$1(String type) {
        Run run;
        switch (type) {
            case "乌龟":
                run = new ty_$1();
                break;
            case "兔子":
                run = new ty_$2();
                break;
            default:
                run = null;
                break;
        }
        return run;
    }
}

// 乌龟
class ty_$1 implements Run {
    @Override
    public void $1() throws InterruptedException {
        for (int i = 1; i <= 20; i++) {
            Thread.sleep(800);
            if (i == 8 || i == 16){
                System.out.println("看到了兔子，它在睡觉");
            }
            System.out.println("乌龟跑了" + i + "米");
        }
        System.out.println(Thread.currentThread().getName() + "到了终点站");
    }
}

// 兔子
class ty_$2 implements Run {
    @Override
    public void $1() throws InterruptedException {
        for (int i = 1; i <= 20; i++) {
            if (i == 8 || i == 16){
                Thread.sleep(8000);
            } else {
                Thread.sleep(500);
            }
            System.out.println("兔子跑了" + i + "米");
        }
        System.out.println(Thread.currentThread().getName() + "到了终点站");
    }
}

// 基层父类也可实现
//class ConCreateProcudtA extends Application {
//    @Override
//    Product createProduct() {
//        return new ProductA();
//    }
//}
//class ConCreateProcudtB extends Application {
//    @Override
//    Product createProduct() {
//        return new ProductB();
//    }
//}
