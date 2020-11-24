/*
    定义：动态的将新功能附加到对象上。在对象功能扩展方面，它比继承更有弹性

    装饰者与被装饰者拥有共同的超类，继承的目的是继承类型，而不是行为和属性
 */
package com.tuling.designpattern.decorator;

public class DecoratorPattern {

    public static void main(String[] args) {
        Component component = new ConcreteDecorator2(new ConcreteDecorator1(new ConcreteComponent()));
        component.operation();
    }
}

interface Component {
    void operation();
}

class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("拍照.");
    }
}

abstract class Decorator implements Component {

    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}

class ConcreteDecorator1 extends Decorator {

    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加滤镜");
        component.operation();
    }
}

class ConcreteDecorator2 extends Decorator {

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加美颜");
        component.operation();
    }
}
