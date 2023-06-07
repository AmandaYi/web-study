package com.bjpowernode.sort;

import java.util.Arrays;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class SelectSort {

    public static void main(String[] args) {

        int[] arr = new int[]{3,2,4,5,6,8,7,1};
        for (int i=0;i<arr.length;i++){

            for (int j=arr.length-1;j>i;j--){

                if (arr[j]<arr[i]){

                    int temp = 0;
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;

                }

            }


        }

        System.out.println("选择排序后的结果:"+Arrays.toString(arr));

    }

}
