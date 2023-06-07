package com.bjpowernode.sort;

import java.util.Arrays;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class BubblingSort {

    public static void main(String[] args) {

        int[] arrays = new int[]{4,5,6,3,2,1};

        /**
         * 底层for循环控制行数
         */
        for (int i=0;i<arrays.length-1;i++){
            /**
             * 控制比较次数
             */
            for(int j=0;j<arrays.length-1-i;j++){

                if (arrays[j] > arrays[j+1]){
                    int temp = 0;//类似空桶

                    temp = arrays[j]; //蓝颜色水倒入空桶
                    arrays[j] = arrays[j+1];//把橘色的水倒入原来蓝色的空桶
                    arrays[j+1] = temp;//把蓝颜色水倒入原橘色的空桶中

                }
            }
        }

        System.out.println(Arrays.toString(arrays));


    }

}
