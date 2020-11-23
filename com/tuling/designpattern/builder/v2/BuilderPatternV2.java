package com.tuling.designpattern.builder.v2;

public class BuilderPatternV2 {

    public static void main(String[] args) {
        Product build = new Product.Builder().setProductName("v2").setCompanyName("tuling").setPart1("part1").setPart4("part4").build();
        System.out.println(build);
    }
}

class Product {

    private final String productName;
    private final String companyName;
    private final String part1;
    private final String part2;
    private final String part3;
    private final String part4;
    // ... 可能有很多属性

    public Product(String productName, String companyName, String part1, String part2, String part3, String part4) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    static class Builder {
        private String productName;
        private String companyName;
        private String part1;
        private String part2;
        private String part3;
        private String part4;

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder setPart1(String part1) {
            this.part1 = part1;
            return this;
        }

        public Builder setPart2(String part2) {
            this.part2 = part2;
            return this;
        }

        public Builder setPart3(String part3) {
            this.part3 = part3;
            return this;
        }

        public Builder setPart4(String part4) {
            this.part4 = part4;
            return this;
        }

        Product build() {
            return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3,this.part4);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                '}';
    }
}
