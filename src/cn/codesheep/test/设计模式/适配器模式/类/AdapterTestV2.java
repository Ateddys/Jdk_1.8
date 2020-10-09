package cn.codesheep.test.设计模式.适配器模式.类;

/**
 * @program: javaSourceLearn
 * @description: 类适配器模式实现
 * @author: Mr.Teddy
 * @create: 2020-09-22 08:59
 **/
public class AdapterTestV2 {
    public static void main(String[] args) {
        Adpater adpater = new Adpater();
        System.out.println(adpater.outPut5v());
        System.out.println(adpater.outPut220());
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

// Class 使用extends方式实现（容易误导接口方法，父方法也会暴露出，使用方不宜区分）
class Adpater extends Adaptee implements Target {

    @Override
    public int outPut5v() {
        return outPut220() / (outPut220() / 5);
    }
}
