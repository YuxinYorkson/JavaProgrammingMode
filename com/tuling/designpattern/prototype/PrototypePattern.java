/*
    用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象

    应用场景：
    1.当代码不应该依赖与需要复制对象的具体类时，例如邮件群发，如果群发10000次，就需要new 1000个 Mail对象，这时利用clone将提高性能
    因为Object类的clone方法是一个本地方法，它直接操作内存中的二进制流，特别是复制大对象时，性能的差别非常明显。
    2.进行保护性拷贝，可以通过返回一个拷贝对象的形式，实现只读的限制。

    注意：
    使用原型模式复制对象不会调用类的构造方法。因为对象的复制是通过调用Object类的clone方法来完成的，它直接在内存中复制数据，
    因此不会调用到类的构造方法。不但构造方法中的代码不会执行，甚至连访问权限都对原型模式无效。单例模式中，只要将构造方法的访
    问权限设置为private型，就可以实现单例。但是clone方法直接无视构造方法的权限，所以，单例模式与原型模式是冲突的，在使用时要特别注意
 */
package com.tuling.designpattern.prototype;

import java.io.*;

public class PrototypePattern {

    public static void main(String[] args) throws CloneNotSupportedException {

        BaseInfo baseInfo = new BaseInfo("XXX");
        BaseInfo clone1 = baseInfo.clone();
        Product product = new Product("part1","part2","part3",4,5,clone1);
        Product clone = product.clone();

        System.out.println(product);
        System.out.println(clone);
        //修改原始对象的baseInfo为 yyy
        product.getBaseInfo().setCompanyName("yyy");
        System.out.println(product);
        System.out.println(clone);
    }
}

class Product implements Cloneable, Serializable {
    //8种基本类型，以及对应的包装类Integer等，还有BigDecimal等为不可变对象，只需要进行super.clone()即可完成复制，即为浅拷贝
    private String part1;
    private String part2;
    private String part3;
    private Integer part4;
    private Integer part5;
    //... could have a lot
    //BaseInfo为自定义类，为可变对象，需要进行深拷贝
    private BaseInfo baseInfo;

    @Override
    protected Product clone() throws CloneNotSupportedException {
        //深拷贝
        Product clone = ((Product) super.clone());
        BaseInfo clone1 = this.baseInfo.clone();
        clone.setBaseInfo(clone1);
        return clone;

        /*
            如果可变对象过多，可以采用序列化的方式进行深拷贝

            缺点：
            CPU密集，影响性能

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Product object = ((Product) objectInputStream.readObject());
            return object;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;*/
    }

    public Product() {
    }

    public Product(String part1, String part2, String part3, Integer part4, Integer part5, BaseInfo baseInfo) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
        this.part5 = part5;
        this.baseInfo = baseInfo;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public String getPart3() {
        return part3;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }

    public Integer getPart4() {
        return part4;
    }

    public void setPart4(Integer part4) {
        this.part4 = part4;
    }

    public Integer getPart5() {
        return part5;
    }

    public void setPart5(Integer part5) {
        this.part5 = part5;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    @Override
    public String toString() {
        return super.hashCode() + "> Product{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4=" + part4 +
                ", part5=" + part5 +
                ", baseInfo=" + baseInfo +
                '}';
    }
}

class BaseInfo implements Cloneable,Serializable {

    private String companyName;

    public BaseInfo() {
    }

    public BaseInfo(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException {
        return ((BaseInfo) super.clone());
    }

    @Override
    public String toString() {
        return super.hashCode() + "> BaseInfo{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}
