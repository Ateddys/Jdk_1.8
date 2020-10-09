package cn.codesheep.test.设计模式.装饰者模式;

/**
 * @program: javaSourceLearn
 * @description: 装饰者模式实现
 * @author: Mr.Teddy
 * @create: 2020-09-22 09:19
 **/
public class DecoratorTest {
    public static void main(String[] args) {
        Component component = new ConreteDecorator1(new ConreteDecorator2(new ConcreteComponent()));
        component.operation();
    }
}

// 接口
interface Component {
    void operation();
}

class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("吃鸡腿. ");
    }
}

// 装饰器
abstract class Decorator implements Component {
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}

// 条件1
class ConreteDecorator1 extends Decorator {
    public ConreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("菜市场买菜. ");
        component.operation();  // 别忘记了带上原来的东西（不能丢三落四）
    }
}
// 条件2
class ConreteDecorator2 extends Decorator {
    public ConreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("高压锅开始炖肉. ");
        component.operation();  // 别忘记了带上原来的东西（不能丢三落四）
    }
}