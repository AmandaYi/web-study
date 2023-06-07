package com.bjpowernode.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class BasicSort {

    public static void main(String[] args) {
        int[] arrays = new int[]{53,542,3,63,14,214,154,748,616};

        SimpleDateFormat simpleDateFormat  =new SimpleDateFormat("yyyy-mm-dd HH:MM:ss:SS");
        System.out.println("开始前:"+simpleDateFormat.format(new Date()));


        sort(arrays);

        System.out.println("结束:"+simpleDateFormat.format(new Date()));

    }

    /**
     * 1.获取原序列的最大位多少
     * @param arrays
     */
    public static void sort(int[] arrays){

        /**
         * 获取最大位数
         */
        int max = 0;
        for(int i=0;i<arrays.length;i++){
            if (arrays[i]>max){
                max = arrays[i];
            }
        }
        /**
         * 获取字符串长度，所以把int类型转字符串类型
         */
        int maxLength = (max+"").length();


        /**
         * 定义二维数组，大小10，表示10个桶，每一个桶则是一个数组
         * [[],[],[],[],[]...]
         */
        int[][] bucket = new int[10][arrays.length];

        /**
         * 辅助数组
         */
        int[] bucketElementCount = new int[10];


        /**
         * 循环获取无序数列
         */
        for (int j=0;j<arrays.length;j++){
            int locationElement = arrays[j]%10;

            /**
             * 放入桶中
             */
            bucket[locationElement][bucketElementCount[locationElement]] = arrays[j] ;
            bucketElementCount[locationElement]++;
        }

        /**
         * 遍历每一个桶，讲元素存放原数组中
         */
        int index = 0;
        for (int k = 0;k<bucketElementCount.length;k++){
            if (bucketElementCount[k] !=0){
                for (int l = 0;l<bucketElementCount[k];l++){
                    arrays[index++] = bucket[k][l];
                }
            }
            bucketElementCount[k] = 0;
        }

        System.out.println(Arrays.toString(arrays));

        /**
         * 第一轮针对个位数进行比较
         */

        for (int j = 0;j<arrays.length;j++){
            int locationElement = arrays[j]/1%10;

            bucket[locationElement][bucketElementCount[locationElement]] = arrays[j];
            bucketElementCount[locationElement]++;
        }

        /**
         * 取出来按照桶的顺序放回原数组中
         */
        int indx = 0;
        for (int k = 0;k<bucketElementCount.length;k++){
            if (bucketElementCount[k] !=0){
                for (int l=0;l<bucketElementCount[k];l++){
                    arrays[indx++] = bucket[k][l];
                }
            }
            bucketElementCount[k] = 0;
        }

        /**
         * 判断十位数
         */

        for (int j = 0;j<arrays.length;j++){
            int locationElement = arrays[j]/10%10;

            bucket[locationElement][bucketElementCount[locationElement]] = arrays[j];
            bucketElementCount[locationElement]++;
        }

        /**
         * 取出来按照桶的顺序放回原数组中
         */
        indx = 0;
        for (int k = 0;k<bucketElementCount.length;k++){
            if (bucketElementCount[k] !=0){
                for (int l=0;l<bucketElementCount[k];l++){
                    arrays[indx++] = bucket[k][l];
                }
            }
            bucketElementCount[k] = 0;
        }

        /**
         * 获取百位数比较
         */

        for (int j = 0;j<arrays.length;j++){
            int locationElement = arrays[j]/100%10;

            bucket[locationElement][bucketElementCount[locationElement]] = arrays[j];
            bucketElementCount[locationElement]++;
        }

        /**
         * 取出来按照桶的顺序放回原数组中
         */
        indx = 0;
        for (int k = 0;k<bucketElementCount.length;k++){
            if (bucketElementCount[k] !=0){
                for (int l=0;l<bucketElementCount[k];l++){
                    arrays[indx++] = bucket[k][l];
                }
            }
            bucketElementCount[k] = 0;
        }


        System.out.println("基数排序后的顺序:"+Arrays.toString(arrays));
    }

}
