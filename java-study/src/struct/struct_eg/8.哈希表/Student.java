package com.bjpowernode.hashtable;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class Student {


    public int id;
    public String name;
    //指向下一个结点指针
    public Student next;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
