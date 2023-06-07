package com.bjpowernode.kruskal.prim;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class MGraph {

    int verxs;
    char[] data;
    int[][] weight;

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
