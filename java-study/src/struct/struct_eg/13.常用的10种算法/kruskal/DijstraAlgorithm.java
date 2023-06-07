package com.bjpowernode.kruskal;

import java.awt.*;
import java.sql.SQLOutput;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class DijstraAlgorithm {

    public static int MaxValue = 100000;

    public static void main(String[] args) {

        //顶点数
        int vertex = 7;
        //边数
        int edge = 10;

        int[][] matrix = new int[vertex][vertex];

        for (int i=0;i<vertex;i++){
            for (int j=0;j<vertex;j++){
                matrix[i][j] = MaxValue;
            }
        }

        matrix[0][1] = 6;
        matrix[1][2] = 5;
        matrix[0][3] = 2;
        matrix[3][1] = 7;
        matrix[3][4] = 5;
        matrix[1][2] = 5;
        matrix[1][5] = 3;
        matrix[4][5] = 5;
        matrix[5][4] = 2;
        matrix[4][6] = 1;

        int source = 0;
        dijstra(matrix,source);
    }

    /**
     * 迪杰斯特拉算法
     * @param matrix
     * @param source
     */
    public static void dijstra(int[][] matrix,int source){

        //最短路径长度
        int[] shorttest = new int[matrix.length];

        //判断是否能够算出该顶点的最短距离
        int[] visited = new int[matrix.length];
        //拼接有效的路径
        String[] path =  new String[matrix.length];

        //初始化路径
        for (int i = 0;i<matrix.length;i++){
            path[i] = new String(source+"-->"+i);
        }
        //源点有效距离
        shorttest[source] = 0;
        //有效的路径
        visited[source] = 1;


        for (int i=1;i<matrix.length;i++){
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int j=0;j<matrix.length;j++){

                if (visited[j] == 0 && matrix[source][j]<min){
                    min = matrix[source][j];
                    index = j;
                }
            }

            shorttest[index] = min;
            visited[index] = 1;

            for (int m = 0;m<matrix.length;m++){

                if (visited[m] ==0 && matrix[source][index]+matrix[index][m]<matrix[source][m]){
                    matrix[source][m] = matrix[source][index]+matrix[index][m];
                    path[m] = path[index]+"--->"+m;
                }
            }


        }

        for (int i=0;i<matrix.length;i++){
            if (i !=source){
                if (shorttest[i] == MaxValue){
                    System.out.println(source+"到"+i+"不可以直接到达");
                }else {
                    System.out.println(source+"到"+i+"的最短路径是:"+path[i]+" 最短距离是:"+shorttest[i]);
                }
            }
        }


    }

}
