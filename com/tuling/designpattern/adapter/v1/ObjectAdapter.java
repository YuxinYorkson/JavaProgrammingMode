/*
    对象适配器和类适配器使用了不同的方法实现适配，对象适配器使用组合，类适配器使用继承。
    将被适配的类作为适配器的属性
 */
package com.tuling.designpattern.adapter.v1;

public class ObjectAdapter {

    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.output5v();
    }
}

class Adaptee {
    public int output220v() {
        return 220;
    }
}

interface Target {
    int output5v();
}

class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5v() {

        int i = adaptee.output220v();
        System.out.println(String.format("原始电压：%d v -> 目标电压：%d v",i,5));
        return 5;
    }
}