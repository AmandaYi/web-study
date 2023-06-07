package com.bjpowernode.kruskal.prim;

import com.sun.org.apache.xml.internal.security.keys.content.MgmtData;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class PrimAlgorithm {

    public static void main(String[] args) {

        char[] data = {'A','B','C','D','E','F','G'};

        int verxs = data.length;

        int[][] weight = {
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},
        };

        MGraph mGraph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph,verxs,data,weight);
        minTree.showGraph(mGraph);
        minTree.prim(mGraph,0);

    }

}
