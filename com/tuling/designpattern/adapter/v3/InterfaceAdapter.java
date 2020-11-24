/*
    当不需要全部实现接口提供的方法时，可先设计一个抽象类实现接口，并为该接口中每个方法提供一个默认实现（空方法），
    那么该抽象类的子类可有选择地覆盖父类的某些方法来实现需求，它适用于一个接口不想使用其所有的方法的情况
 */
package com.tuling.designpattern.adapter.v3;

public class InterfaceAdapter {

    public static void main(String[] args) {
        AdapterUsb2VgaImpl adapterUsb2VgaImpl = new AdapterUsb2VgaImpl();
        adapterUsb2VgaImpl.projection();
    }
}

interface USB {
    void showPPT();
}

interface VGA {
    void projection();
    void c();
    void b();
}

class USBImpl implements USB {

    @Override
    public void showPPT() {
        System.out.println("USB show PPT.");
    }
}

/*
    利用抽象类实现接口，再使用抽象类的子类做适配
 */
abstract class AdapterUsb2Vga implements VGA {

    @Override
    public void projection() {

    }

    @Override
    public void c() {

    }

    @Override
    public void b() {

    }
}

class AdapterUsb2VgaImpl extends AdapterUsb2Vga {

    private USB u = new USBImpl();

    @Override
    public void projection() {
        u.showPPT();
    }
}