package com.bjpowernode.kruskal;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class FloydAlgorithm {

    public static int MaxValue = 100000;

    //中间节点存放的数组
    public static int[][] path;

    public static void main(String[] args) {

        //顶点数
        int vertex = 7;
        //边数
        int edge = 10;

        int[][] matrix = new int[vertex][vertex];

        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                matrix[i][j] = MaxValue;
            }
        }

        path = new int[matrix.length][matrix.length];


        matrix[0][1] = 6;
        matrix[1][2] = 5;
        matrix[0][3] = 2;
        matrix[3][1] = 7;
        matrix[3][4] = 5;
        matrix[1][2] = 5;
        matrix[1][5] = 3;
        matrix[5][2] = 3;
        matrix[5][4] = 2;
        matrix[4][6] = 1;
        floyd(matrix);
    }


    public static void floyd(int[][] matrix){

        //防止int类型数组中默认值是0，因为顶点也存在0的数据
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                path[i][j] = -1;
            }
        }

        /**
         * 计算 i通过中间顶点k 到达j 的路径
         * i --k--j
         * 0--0--0
         * 0--0--1
         * 0--0--2
         * ...
         * 0--0--6
         *
         * 1--0--0
         * 1--0--1
         * 1--0--2
         * 6--0--6
         *
         * 0--1--0
         *
         */
        for (int k = 0;k<matrix.length;k++){
            for (int i=0;i<matrix.length;i++){
                for (int j=0;j<matrix.length;j++){
                    if (matrix[i][k]+matrix[k][j]<matrix[i][j]){
                        matrix[i][j] = matrix[i][k]+matrix[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }

        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                if (i!=j){
                    if (matrix[i][j] == MaxValue){
                        System.out.println(i+"到"+j+"不可以直达");
                    }else {
                        System.out.print(i+"到"+j+"最短路径:"+matrix[i][j]);
                        System.out.print("最短路径:"+i+"----->");
                        searchPath(i,j);
                        System.out.println(j);
                    }
                }
            }
        }

    }

    public static void searchPath(int i,int j){
        int m = path[i][j];
        if (m == -1){
            return;
        }
        searchPath(i,m);
        System.out.println(m+"--->");
        searchPath(m,j);

    }

}
