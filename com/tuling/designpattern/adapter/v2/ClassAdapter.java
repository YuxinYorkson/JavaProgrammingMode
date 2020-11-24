/*
    通过多重继承目标接口和被适配者类方式来实现适配

    注意：
    Target adapter = new Adapter();类型指向父类，防止泄露被适配类的信息
 */
package com.tuling.designpattern.adapter.v2;

public class ClassAdapter {

    public static void main(String[] args) {
        Target adapter = new Adapter();
        adapter.output5v();
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

class Adapter extends Adaptee implements Target {

    @Override
    public int output5v() {
        int i = output220v();
        System.out.println(String.format("原始电压：%d v -> 目标电压：%d v",i,5));
        return 5;
    }
}