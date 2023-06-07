package com.bjpowernode.kruskal;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class Dyanmic {

    public static void main(String[] args) {
        int[][] arry = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        System.out.println(myanmic(arry));

    }

    public static int myanmic(int[][] array){

        if (array.length == 0){
            return 0;
        }

        //声明一个新的二维数组，用来存储计算路径值
        int[][] dp = new int[array.length][array[0].length];
        dp[0][0] = array[0][0];
        //从第一行左边开始计算路径值
        for (int i=1; i<dp[0].length;i++ ){
            dp[0][i] = dp[0][i-1] + array[0][i];
        }


        for (int i=1;i<array.length;i++){//遍历每行
            for (int j=0;j<dp[i].length;j++){
                if (j==0){
                    dp[i][j] = dp[i-1][j] + array[i][j];
                }else if (dp[i-1][j]<dp[i][j-1]){
                    //上边路径小
                    dp[i][j] = dp[i-1][j]+array[i][j];
                }else {
                    dp[i][j] = dp[i][j-1]+array[i][j];
                }
            }
        }

        return dp[dp.length-1][dp[dp.length-1].length-1];
    }

}
