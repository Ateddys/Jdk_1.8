package cn.codesheep.test.设计模式.策略模式;

import java.util.Arrays;

/**
 * @program: javaSourceLearn
 * @description: 策略模式实现
 * @author: Mr.Teddy
 * @create: 2020-09-22 09:42
 **/
public class StrategyTest {
    public static void main(String[] args) {
        NormalZombie zombie = new NormalZombie();
        zombie.display();
        zombie.attack();
        zombie.move();

        System.out.println("-------------------");

        FlogZombie flogZombie = new FlogZombie();
        flogZombie.display();
        flogZombie.setAttackable(new HitAttack());
        flogZombie.attack();
        flogZombie.move();

    }
}

// 移动
interface Moveable {
    void move();
}

// 攻击
interface Attackable {
    void attack();
}

// 抽象类
abstract class Zombie {
    abstract public void display();
    Moveable moveable;
    Attackable attackable;

    abstract void move();
    abstract void attack();

    public Moveable getMoveable() {
        return moveable;
    }

    public void setMoveable(Moveable moveable) {
        this.moveable = moveable;
    }

    public Attackable getAttackable() {
        return attackable;
    }

    public void setAttackable(Attackable attackable) {
        this.attackable = attackable;
    }

    public Zombie(Moveable moveable, Attackable attackable) {
        this.moveable = moveable;
        this.attackable = attackable;
    }
}

// 僵尸怎么移动
class StepBySetpMove implements Moveable {
    @Override
    public void move() {
        System.out.println("移动方式：一步一步一步一步. ");
    }
}
// 僵尸攻击方法
class BiteAttack implements Attackable {
    @Override
    public void attack() {
        System.out.println("攻击方式：牙咬，莽撞. ");
    }
}
// 僵尸攻击方法2
class HitAttack implements Attackable {
    @Override
    public void attack() {
        System.out.println("攻击方式：长矛，冷兵器. ");
    }
}

// 普通僵尸️
class NormalZombie extends Zombie {

    public NormalZombie(){
        super(new StepBySetpMove(), new BiteAttack());
    }

    public NormalZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("我是普通僵尸. ");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}

// 骑手僵尸
class FlogZombie extends Zombie {

    public FlogZombie(){
        super(new StepBySetpMove(), new BiteAttack());
    }

    public FlogZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("我是骑手僵尸. ");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}