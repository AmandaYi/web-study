package com.bjpowernode.select;

import java.util.Arrays;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class FibonacciSelect {


    public static void main(String[] args) {

        int[] array = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};

        System.out.println(select(array,13));
    }


    /**
     * f[k] = (f[k-1])+ (f[k-2])
     * @return
     */
    public static int[] f(){

        int[] f = new int[20];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2;i<f.length;i++){
            f[i] = f[i-1]+f[i-2];
        }
        return f;
    }


    /**
     * mid = low+F(k-1)-1
     * @param array
     * @param key
     * @return
     */
    public static int select(int[] array,int key){

        int low = 0;
        int hight  = array.length-1;
        int k = 0;
        int mid = 0;
        int[] f = f();

        /**
         * 找分割点
         */
        while (hight>f[k]-1){
            k++;
        }

        int[] temp = Arrays.copyOf(array,f[k]);

        /**
         * {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89}  -=》{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89，89,89,}
         */
        for (int i = hight+1;i<temp.length;i++){
            temp[i] = array[hight];
        }


        while (low<=hight){
            mid = low+f[k-1]-1;

            // f[k-1]+f[k-2] = f[k];
            if (key<temp[mid]){
                hight=mid-1;
                k--;
            }else if (key>temp[mid]){
                low = mid+1;
                k-=2;

            }else{
                if (mid<=hight){
                    return mid;
                }else {
                    return hight;
                }

            }


        }

        return -1;
    }

}
