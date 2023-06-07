package com.bjpowernode.select;

import com.bjpowernode.stack.TestApp;

import java.lang.annotation.Target;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class BinarySearch {

    public static void main(String[] args) {

          int[] array = new int[]{10,11,12,13,14,15,16,17};

          int target = 10;

        int index = search(array, target);
        System.out.println(index);


    }
    public static int search(int[] array,int target){
        //最小索引指针
        int min = 0;

        int max = array.length-1;

        while (min<=max){
            //算出平均索引位置
            int mid = (min+max)/2;
            if (array[mid]== target){
                return mid;
            }

            if (array[mid]<target){
                min = mid+1;
            }
            if (array[mid]>target){
                max = mid-1;
            }

        }

        return -1;
    }

}
