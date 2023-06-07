package com.bjpowernode.sort;

import java.util.Arrays;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] array = new int[]{2,5,6,3,4,7,1,8};
        //控制拿去每一个元素
        for(int i=1;i<array.length;i++){
            //比较次数
            for (int j=i;j>=1;j--){
                //是否小于前面的元素
                if (array[j]<array[j-1]){
                    int temp = 0;
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }else {

                    //continue 与 break

                    break;
                }
            }

        }

        System.out.println("排序后的结果："+ Arrays.toString(array));


    }

}
