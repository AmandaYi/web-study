package com.bjpowernode.sort;

import java.util.Arrays;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arrays = new int[]{2,9,4,7,3,3,6,5};
        sort(arrays,0,arrays.length-1);

        System.out.println(Arrays.toString(arrays));

    }

    public static void sort(int[] arrays,int left,int right){
        int l  = left;
        int r = right;

        int pivot = arrays[(left+right)/2];
        int temp = 0;
        while (l<r){

            //在左边查找小于中间值的
            while(arrays[l]<pivot){
                l++;
            }

            //查询右边小于中间值
            while (arrays[r]>pivot){
                r--;
            }

            if (l>=r){
                break;
            }

            temp = arrays[l];
            arrays[l] = arrays[r];
            arrays[r] = temp;

            /**
             * 交换完数据arrays[l] = pivot
             */
            if (arrays[l]==pivot){
                r--;
            }

            if (arrays[r]==pivot){
                l++;
            }

            if (r==l){
                l++;
                r--;
            }

            if (left<r){
                sort(arrays,left,r);
            }

            if (right>l){
                sort(arrays,l,right);
            }


        }


    }

}
