/*
  定义一个用于创建对象的接口，让子类决定实例化哪一个类。Factory Method使得一个类的实例化延迟到子类。
 */
package com.tuling.designpattern.factory;

public class FactoryMethod {

    public static void main(String[] args) {

        AbstractApplcation applcation = new ConcreteProductA();
        //AbstractApplcation applcation = new ConcreteProductB();
        IProduct product = applcation.getObject();
        product.method();

    }
}

abstract class AbstractApplcation {

    abstract IProduct createProduct();

    IProduct getObject() {
        return createProduct();
    }
}

class ConcreteProductA extends AbstractApplcation {

    @Override
    IProduct createProduct() {
        return new ProductA();
    }
}

class ConcreteProductB extends AbstractApplcation {

    @Override
    IProduct createProduct() {
        return new ProductB();
    }
}
