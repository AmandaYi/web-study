package com.bjpowernode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class Graph {

    //顶点元素
    private ArrayList<String> vertexList;

    //邻接矩阵
    private int[][] edges;

    private int edgesNum;

    private boolean[] isSelectd;

    public Graph(int len) {
        this.vertexList = new ArrayList<String>(len);
        this.edges = new int[len][len];
        this.isSelectd = new boolean[len];
    }

    /**
     * 插入顶点方法
     */
    public void insertVertex(String vertex){
        this.vertexList.add(vertex);
    }

    /**
     * 添加图边
     */
    public void insertEdges(int x,int y,int w){
            edges[x][y] = w;
            edges[y][x] = w;

            //添加边的数量
            edgesNum++;
    }

    /**
     * 返回顶点个数
     */
    public int getVertexSize(){
        return this.vertexList.size();
    }

    /**
     * 返回边的数量
     * @return
     */
    public int getEdgesSize(){
        return this.edgesNum;
    }

    /**
     * 获取顶点权值   x,y坐标下权值
     */
    public int getWeight(int x,int y){
        return this.edges[x][y];
    }

    /**
     * 输出邻接矩阵图案
     */
    public void showList(){
        for (int[] arr:edges){
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 给定一个索引顶点位置，查找当前索引的第一个邻接点
     * 如果存在返回索引位置
     * 如果不存在返回-1
     */
    public int getFirstVertex(int index){
        for (int i=0;i<vertexList.size();i++){
            if (edges[index][i] >0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据给定的坐标，获取下一个邻接顶点
     */
    public int getNextVertex(int x,int y){
        for (int i = y+1;i<vertexList.size();i++){
            if (edges[x][i] >0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 访问的顶点
     */
    public String getValueIndex(int i){
        return this.vertexList.get(i);
    }


    /**
     * 深度优先算法
     */
    public void dfs(boolean[] isSelectd,int i){
        System.out.print(getValueIndex(i));
        //表示已经被访问过
        isSelectd[i] = true;
        //获取第一个邻接顶点
        int w = getFirstVertex(i);

        while (w !=-1){//存在第一个邻接点
            if (!isSelectd[w]){
                dfs(isSelectd,w);
            }
            //被访问过
            w = getNextVertex(i,w);
        }

    }

    public void dfs(){
        for (int i=0;i<getVertexSize();i++){
            if (!isSelectd[i]){
                dfs(isSelectd,i);
            }
        }
    }


    /**
     * 广度优先算法
     */
    public void bfs(boolean[] isSelectd,int i){
        //头取出结点
        int u;
        //第一个邻接点
        int w;

        //创建队列，queue
        LinkedList queue = new LinkedList();
        System.out.print(getValueIndex(i));
        isSelectd[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()){
            u = (Integer)queue.removeFirst();
            w = getFirstVertex(u);
            while (w !=-1){
                if (!isSelectd[w]){
                    System.out.print(getValueIndex(w));
                    isSelectd[w] = true;
                    queue.addLast(w);
                }
                w = getNextVertex(u,w);
            }

        }

    }

    public void bfs(){
        for (int i=0;i<getEdgesSize();i++){
            if (!isSelectd[i]){
                bfs(isSelectd,i);
            }
        }
    }


}
