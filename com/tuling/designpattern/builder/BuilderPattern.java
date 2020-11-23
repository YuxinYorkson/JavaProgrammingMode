/*
    定义：
    将一个复杂的对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。

    应用场景:
    需要生产的对象就有复杂的内部结构
    需要生产的对象内部属性本身相互依赖（V2中）
    与不可变对象配合使用（比如server的配置信息）
 */
package com.tuling.designpattern.builder;

public class BuilderPattern {

    public static void main(String[] args) {

        IProductBuilder defaultConcreteProductBuilder = new DefaultConcreteProductBuilder();
        Director director = new Director(defaultConcreteProductBuilder);
        Product product = director.produceProdcut("v1", "tuling", "part1","part2", "part3", "part4");
        System.out.println(product);


    }
}

class Director {

    private IProductBuilder builder;

    public Director(IProductBuilder builder) {
        this.builder = builder;
    }

    public Product produceProdcut(String productName, String companyName, String part1, String part2, String part3, String part4) {
        builder.buildProductName(productName);
        builder.buildCompanyName(companyName);
        builder.buildProductPart1(part1);
        builder.buildProductPart2(part2);
        builder.buildProductPart3(part3);
        builder.buildProductPart4(part4);

        return builder.build();
    }
}

class DefaultConcreteProductBuilder implements IProductBuilder {

    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    @Override
    public void buildProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void buildCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void buildProductPart1(String part1) {
        this.part1 = part1;
    }

    @Override
    public void buildProductPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public void buildProductPart3(String part3) {
        this.part3 = part3;
    }

    @Override
    public void buildProductPart4(String part4) {
        this.part4 = part4;
    }

    @Override
    public Product build() {
        return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3,this.part4);
    }
}
