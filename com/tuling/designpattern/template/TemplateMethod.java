/*
    概述
    模板方法模式是类的行为模式。准备一个抽象类，将部分逻辑以具体方法以及具体构造函数的形式实现，
    然后声明一些抽象方法来迫使子类实现剩余的逻辑。不同的子类可以以不同的方式实现这些抽象方法，从
    而对剩余的逻辑有不同的实现。这就是模板方法模式的用意。
    比如定义一个操作中的算法的骨架，将步骤延迟到子类中。模板方法使得子类能够不去改变一个算法的结
    构即可重定义算法的某些特定步骤。
 */
package com.tuling.designpattern.template;

public class TemplateMethod {

    public static void main(String[] args) {

        AbstractClass abstractClass = new SubClass();
        abstractClass.operation();

    }
}

abstract class AbstractClass {

    public void operation() {

        System.out.println("pre ...");
        System.out.println("step 1");
        System.out.println("step 2");

        templateMethod();
    }

    abstract protected void templateMethod();
}

class SubClass extends AbstractClass {

    @Override
    protected void templateMethod() {
        System.out.println("Subclass executed.");
    }
}
