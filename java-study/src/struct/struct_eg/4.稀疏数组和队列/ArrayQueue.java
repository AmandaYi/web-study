package com.bjpowernode.queue;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 *
 * 数组实现队列，插入
 */
public class ArrayQueue {

    private int[] array;

    private int maxSize;

    private int frontPoint;

    private int rearPoint;


    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        array  = new int[maxSize];

        frontPoint = -1;
        rearPoint = -1;

    }

    /**
     * 判断当前队列是否已满
     */
    public boolean isFull(){
        return rearPoint == maxSize-1;
    }

    /**
     * 判断是否是空队列
     */
    public boolean isEmpty(){
        return frontPoint == rearPoint;
    }

    /**
     * 添加元素进入队列
     */
    public void add(int n){
        //判断是否已满
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        rearPoint++;
        array[rearPoint] = n;
    }

    /**
     * 获取队列元素并且删除元素，出队列
     */
    public int get(){
        if (isEmpty()){
            throw new RuntimeException("空队列");
        }
        frontPoint++;
        return array[frontPoint];
    }

    /**
     * 查看队列中的元素
     */
    public void findQueue(){
        if (isEmpty()){
            throw new RuntimeException("空队列");
        }
        for (int i=0;i<array.length;i++){
            System.out.printf("array[%d]=%d\n",i,array[i]);
        }
    }

    /**
     * 查看队头元素，不能是出队列
     */
    public int frontQueue(){
        if (isEmpty()){
            throw new RuntimeException("空队列");
        }
        return array[frontPoint+1];
    }

}
