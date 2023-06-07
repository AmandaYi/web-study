package com.bjpowernode.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class ShellSort {

    public static void main(String[] args) {

        int[] array = new int[]{1,5,9,7,2,6,0,3,8,4};

        /**
         * 实现增量变化
         */
        for (int gap = array.length/2;gap>0;gap/=2){

            for (int i=gap;i<array.length;i++){

                for (int j=i-gap;j>=0;j-=gap){
                        if (array[j]>array[j+gap]){
                            int temp = 0;
                            temp = array[j];
                            array[j] = array[j+gap];
                            array[j+gap] = temp;
                        }
                }
            }

        }

        System.out.println(Arrays.toString(array));

    }

}
