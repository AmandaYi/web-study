package com.bjpowernode.kruskal.prim;

import com.bjpowernode.graph.Graph;

import java.util.Arrays;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class MinTree {



    public void createGraph(MGraph graph,int verxs,char[] data,int[][] weight){
        for (int i=0;i<verxs;i++){
            graph.data[i] = data[i];
            for (int j = 0;j<verxs;j++){
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    /**
     * 查看邻接矩阵
     * @param graph
     */
    public void showGraph(MGraph graph){
        for (int[] data:graph.weight){
            System.out.println(Arrays.toString(data));
        }
    }


    public void prim(MGraph graph,int v){
        //标记被访问过的，0表示没有访问过，1表示访问过
        int[] visied = new int[graph.verxs];
        visied[v] = 1;

        int x = -1;
        int y = -1;

        int minWeight = 10000;
        //最小生成树   边 = 顶点-1
        for (int i=1;i<graph.verxs;i++){

            //被访问过
            for (int j = 0;j<graph.verxs;j++){
                //没有被访问过
                for (int k=0;k<graph.verxs;k++){
                    if (visied[j] == 1 && visied[k] == 0 && graph.weight[j][k]<minWeight){
                        minWeight = graph.weight[j][k];
                        x = j;
                        y = k;
                    }
                }
            }

            System.out.println(graph.data[x]+"----->"+graph.data[y]+"="+minWeight);
            visied[y] = 1;
            minWeight = 10000;
        }

    }

}
