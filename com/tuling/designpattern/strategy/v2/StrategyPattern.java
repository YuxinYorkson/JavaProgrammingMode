/*
    定义
    把一个类中经常改变或者将来可能改变的部分提取出来，作为一个接口，然后在类中包含这个对象的实例，这样类的实例在运行时
    就可以随意调用实现了这个接口的类的行为。比如定义一系列的算法,把每一个算法封装起来, 并且使它们可相互替换，使得算法
    可独立于使用它的客户而变化。这就是策略模式。

    适用情况
    许多相关的类仅仅是行为有异。 “策略”提供了一种用多个行为中的一个行为来配置一个类的方法。即一个系统需要动态地在几种
    算法中选择一种。当一个应用程序需要实现一种特定的服务或者功能，而且该程序有多种实现方式时使用。一个类定义了多种行为,
    并且这些行为在这个类的操作中以多个条件语句的形式出现。将相关的条件分支移入它们各自的Strategy类中以代替这些条件语句。

    优点
    1、算法可以自由切换。
    2、避免使用多重条件判断。
    3、扩展性良好。
    缺点
    1、策略类会增多。
    2、所有策略类都需要对外暴露。
 */
package com.tuling.designpattern.strategy.v2;

public class StrategyPattern {

    public static void main(String[] args) {
//        Zombie zombie = new NormalZombie();
        Zombie dancingZombie = new DancingZombie();

        Moveable move = new StepByStepMove();
        Attackable attackable = new BiteAttack();
        Zombie zombie = new NormalZombie(move,attackable);
        zombie.display();
        zombie.move();
        zombie.attack();
        System.out.println("\n---------------\n");
        dancingZombie.display();
        dancingZombie.move();
        dancingZombie.attack();
        System.out.println("\n--------改变普通僵尸移动方式-------\n");
        zombie.setMoveable(new DancingMove());
        zombie.move();
    }
}

interface Moveable {
    void move();
}

interface Attackable {
    void attack();
}

class StepByStepMove implements Moveable {

    @Override
    public void move() {
        System.out.println("一步一步移动.");
    }
}

class BiteAttack implements Attackable {

    @Override
    public void attack() {
        System.out.println("咬.");
    }
}

class DancingMove implements Moveable {

    @Override
    public void move() {
        System.out.println("Dancing");
    }
}

abstract class Zombie {

    Moveable moveable;
    Attackable attackable;
    abstract public void display();
    abstract void move();
    abstract void attack();

    public Zombie(Moveable moveable, Attackable attackable) {
        this.moveable = moveable;
        this.attackable = attackable;
    }

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
}

class NormalZombie extends Zombie {

    public NormalZombie() {
        super(new StepByStepMove(), new BiteAttack());
    }

    public NormalZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("普通僵尸.");
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

class DancingZombie extends Zombie {

    public DancingZombie() {
        super(new DancingMove(), new BiteAttack());
    }

    public DancingZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("Dancing僵尸.");
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