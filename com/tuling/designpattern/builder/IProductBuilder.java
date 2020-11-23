package com.tuling.designpattern.builder;

interface IProductBuilder {

    void buildProductName(String productName);
    void buildCompanyName(String companyName);
    void buildProductPart1(String part1);
    void buildProductPart2(String Part2);
    void buildProductPart3(String Part3);
    void buildProductPart4(String Part4);
    Product build();
}
