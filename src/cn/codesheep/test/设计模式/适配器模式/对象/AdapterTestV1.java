package cn.codesheep.test.设计模式.适配器模式.对象;

/**
 * @program: javaSourceLearn
 * @description: 对象适配器模式实现
 * @author: Mr.Teddy
 * @create: 2020-09-22 09:05
 **/
public class AdapterTestV1 {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();

        Adpater adpater = new Adpater(adaptee);

        System.out.println(adpater.outPut5v());
        System.out.println(adaptee.outPut220());
    }
}

class Adaptee {
    public int outPut220() {
        return 200;
    }
}

interface Target {
    int outPut5v();
}

class Adpater implements Target {
    private Adaptee adaptee;

    public Adpater (Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public int outPut5v() {
        int outPut220 = adaptee.outPut220();
        return outPut220 / (outPut220 / 5);
    }
}