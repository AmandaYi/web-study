package com.bjpowernode.select;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class InsertSelect {

    public static void main(String[] args) {

        int[] array = {1,2,3,4,5,6};

        int left = 0;
        int right = array.length-1;

        int searchVal = 1;

        System.out.println(select(array,left,right,searchVal));

    }

    public static int select(int[] array,int left,int right,int searchVal){

        /**
         * 防止数组越界
         */
        if (left>right || searchVal<array[0] || searchVal>array[array.length-1]){
            return -1;
        }

        int mid = left+(right-left)*(searchVal-array[left])/(array[right]-array[left]);
        int midValue = array[mid];
        if (searchVal>midValue){
            return select(array,mid+1,right,searchVal);
        }else if (searchVal<midValue){
            return select(array,left,mid-1,searchVal);
        }else {
            return mid;
        }

    }

}
