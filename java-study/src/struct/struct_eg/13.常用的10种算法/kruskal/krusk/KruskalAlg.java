package com.bjpowernode.kruskal.krusk;

import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class KruskalAlg {

    public static void main(String[] args) {

        Graph graph = new Graph();
        int[][] array = new int[7][7];
        for (int i=0;i<7;i++){
            for (int j = 0;j<7;j++){
                if (i==j){
                    array[i][j] = 0;
                }else {
                    array[j][i] = Integer.MAX_VALUE;
                }
            }
        }

        array[0][1] = 7;
        array[0][3] = 5;
        array[1][2] = 8;
        array[1][3] = 9;
        array[2][4] = 5;
        array[3][4] = 15;
        array[4][5] = 8;
        array[4][6] = 9;
        array[5][6] = 11;

        graph.array = array;
        int k = 0;
        Edge[] edge = new Edge[11];
        for (int i=0;i<edge.length;i++){
            Edge edge1 = new Edge();
            edge[i] = edge1;
        }

        for (int i=0;i<6;i++){
            for (int j=i+1;j<7;j++){
                if (array[i][j]<Integer.MAX_VALUE){
                    edge[k].begin = i;
                    edge[k].end = j;
                    edge[k].weight = array[i][j];
                    k++;
                }
            }
        }

        graph.edges = edge;
        Arrays.sort(edge);
        kruskal(graph);





    }

    /**
     * 是否会构成回路
     * @param terget
     * @param parent
     * @return
     */
    public static int findParentRoot(int terget,int[] parent){
        while (parent[terget]>0){
            terget = parent[terget];
        }
        return terget;
    }


    public static void kruskal(Graph graph){
        Edge[] edges = graph.edges;
        int[][] arr = graph.array;
        int[] parent = new int[7];

        for (int i = 0;i<edges.length;i++){
            Edge edge = edges[i];
            int begin = findParentRoot(edge.begin, parent);
            int end = findParentRoot(edge.end, parent);
            if (begin != end){
                System.out.println(String.format("(%d,%d)--->%d",begin,end,edge.weight));
                parent[begin] = end;
            }

        }
    }

}
