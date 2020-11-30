package com.tuling.designpattern.strategy.v1;

public class StrategyPattern {

    public static void main(String[] args) {

        AbsractZombie normalZombie = new NormalZombie();
        normalZombie.display();
        normalZombie.attack();
        normalZombie.move();

        AbsractZombie flagZombie = new FlagZombie();
        flagZombie.display();
        flagZombie.attack();
        flagZombie.move();
    }
}

abstract class AbsractZombie {
    public abstract void display();

    public void attack() {
        System.out.println("咬.");
    }

    public void move() {
        System.out.println("一步一步移动.");
    }
}

class NormalZombie extends AbsractZombie {

    @Override
    public void display() {
        System.out.println("普通僵尸.");
    }
}

class FlagZombie extends AbsractZombie {

    @Override
    public void display() {
        System.out.println("旗手僵尸.");
    }
}

class BigHeadZombie extends AbsractZombie {

    @Override
    public void display() {
        System.out.println("大头僵尸");
    }

    @Override
    public void attack() {
        System.out.println("头撞");
    }
}
