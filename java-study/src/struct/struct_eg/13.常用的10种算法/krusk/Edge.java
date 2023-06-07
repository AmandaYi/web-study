package com.bjpowernode.kruskal.krusk;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class Edge implements Comparable<Edge>{

    int begin;
    int end;
    int weight;

    @Override
    public int compareTo(Edge o) {
        return this.weight-o.weight;
    }
}
