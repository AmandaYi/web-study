package com.bjpowernode.kruskal;

import sun.security.provider.MD2;

import java.lang.annotation.Target;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] array = {2,3,4,5,6,7,8,9};
        int i = binarySearch(array, 10);
        System.out.println(i);


    }

    public static int binarySearch(int[] array,int target){
        //指向最小位置的索引
        int min = 0;
        int max = array.length-1;

        while (min<=max){
            //求出平均值索引位置
            int mid = (min+max)/2;
            if (array[mid] == target){
                return mid;
            }else if (array[mid]>target){
                max = mid - 1;
            }else {
                min = mid + 1;
            }

        }

        return -1;
    }

}
