/*
    定义： 定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。

    主要解决：一个对象状态改变给其他对象通知的问题，而且要考虑到易用和低耦合，保证高度的协作。

    何时使用：一个对象（目标对象）的状态发生改变，所有的依赖对象（观察者对象）都将得到通知，进行广播通知。

    如何解决：使用面向对象技术，可以将这种依赖关系弱化。

    关键代码：在抽象类里有一个 集合（比如:ArrayList） 存放观察者们。

    优点：
    1、观察者和被观察者是抽象耦合的。
    2、建立一套触发机制。

    缺点：
    1、如果一个被观察者对象有很多的直接和间接的观察者的话，将所有的观察者都通知到会花费很多时间。
    2、如果在观察者和观察目标之间有循环依赖的话，观察目标会触发它们之间进行循环调用，可能导致系统崩溃。
    3、观察者模式没有相应的机制让观察者知道所观察的目标对象是怎么发生变化的，而仅仅只是知道观察目标发生了变化。

    抽象被观察者角色：也就是一个抽象主题，它把所有对观察者对象的引用保存在一个集合中，每个主题都可以有任意数量的观察者。
                   抽象主题提供一个接口，可以增加和删除观察者角色。一般用一个抽象类和接口来实现。
    抽象观察者角色：为所有的具体观察者定义一个接口，在得到主题通知时更新自己。
    具体被观察者角色：也就是一个具体的主题，在集体主题的内部状态改变时，所有登记过的观察者发出通知。
    具体观察者角色：实现抽象观察者角色所需要的更新接口，一边使本身的状态与制图的状态相协调。
 */
package com.tuling.designpattern.observer;

import java.util.LinkedList;
import java.util.List;

public class ObserverPattern {

    public static void main(String[] args) {

        Subject subject = new Subject();
        Observer task1 = new Task1();
        Task2 task2 = new Task2();
        subject.addObserver(task1);
        subject.addObserver(task2);
        subject.notifyObserver("XXXX");
        System.out.println("\n------------\n");
        subject.removeObserver(task1);
        subject.notifyObserver("task1 is removed.");
    }
}

interface AbstractSubject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(Object object);
}

class Subject implements AbstractSubject {

    //container
    private List<Observer> container = new LinkedList<Observer>();

    @Override
    public void addObserver(Observer observer) {
        container.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        container.remove(observer);
    }

    @Override
    public void notifyObserver(Object object) {
        for (Observer item : container) {
            item.update(object);
        }
    }
}

interface Observer {
    void update(Object object);
}

class Task1 implements Observer {

    @Override
    public void update(Object object) {
        System.out.println(this.getClass().getSimpleName() + " received: " + object);
    }
}

class Task2 implements Observer {

    @Override
    public void update(Object object) {
        System.out.println(this.getClass().getSimpleName() + " received: " + object);
    }
}