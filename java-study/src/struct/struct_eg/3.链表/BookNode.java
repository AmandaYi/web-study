package com.bjpowernode.linked;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class BookNode {

    public int id;

    public String name;

    public double price;


    //节点下一个节点  直接后继
    public BookNode next;

    //上一个节点   直接前驱
    public BookNode pre;

    public BookNode(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
