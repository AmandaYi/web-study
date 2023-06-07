package com.bjpowernode.graph;

import java.awt.*;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class Test {

    public static void main(String[] args) {

        Graph graph = new Graph(5);
        String[] vertexs = {"A","B","C","D","E"};

        for (String v:vertexs){
            graph.insertVertex(v);
        }

        graph.insertEdges(0,1,1);
        graph.insertEdges(0,2,1);
        graph.insertEdges(1,2,1);
        graph.insertEdges(1,3,1);
        graph.insertEdges(1,4,1);

        graph.showList();

        //graph.dfs();

        graph.bfs();


    }

}
