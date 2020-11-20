/**
 * 享元（Flyweight）模式的定义：运用共享技术来有效地支持大量细粒度对象的复用。它通过共享已经存在的对象来大幅度减少需要创建的对象数量、避免大量相似类的开销，从而提高系统资源的利用率。
 *
 * 享元模式的主要优点是：相同对象只要保存一份，这降低了系统中对象的数量，从而降低了系统中细粒度对象给内存带来的压力。
 *
 * 其主要缺点是：
 * 为了使对象可以共享，需要将一些不能共享的状态外部化，这将增加程序的复杂性。
 * 读取享元模式的外部状态会使得运行时间稍微变长。
 */
package com.tuling.designpattern.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Flyweight {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1, 2, TreeFactory.getTree("tree1", "one tree"));
        TreeNode node1 = new TreeNode(2, 3, TreeFactory.getTree("tree1", "one tree"));

    }
}

class Tree {

    private final String name;
    private final String data;

    public Tree(String name, String data) {
        System.out.println("name: " + name + " is created.");
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

}

class TreeFactory {

    private static Map<String,Tree> map = new ConcurrentHashMap<>();

    public static Tree getTree(String name, String data) {
        if(map.containsKey(name)){
            return map.get(name);
        }
        Tree tree = new Tree(name,data);
        map.put(name, tree);
        return tree;
    }

}

class TreeNode {

    private int x;
    private int y;
    private Tree tree;

    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }
}
