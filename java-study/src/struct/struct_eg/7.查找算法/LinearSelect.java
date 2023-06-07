package com.bjpowernode.select;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class LinearSelect {

    public static void main(String[] args) {


        /**
         * 查询该数组下是否存在9这个元素，如果存在则返回索引值，否则返回-1
         *
         * 1.线性查找
         */
        int[] array = new int[]{2,4,8,6,4,9,0};
        int i = show(array, 10);
        System.out.println(i);


    }

    public static int show(int[] array,int target){

        for (int i=0;i<array.length;i++){
            if (array[i]==target){
                return i;
            }
        }

        return -1;

    }

}
