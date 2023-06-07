package com.bjpowernode.queue;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class TestApp {
    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.add(4);
        arrayQueue.add(5);


        int i = arrayQueue.get();
        System.out.println(i);


        arrayQueue.findQueue();



    }

}
