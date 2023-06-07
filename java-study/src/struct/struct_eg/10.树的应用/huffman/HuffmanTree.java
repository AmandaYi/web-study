package com.bjpowernode.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class HuffmanTree {

    public static void main(String[] args) {

        int[] array = {13,7,8,29,6,1};

        Node root = createHuffmanTree(array);

        preSelect(root);

    }

    /**
     * 把数列转赫夫曼树
     */
    public static Node createHuffmanTree(int[] array){
        /**
         * 1、遍历数组
         * 2、将每一个元素构成一个节点Node
         * 3、将Node放入到一个集合中并且已经是排序的，从小到大
         */

        List<Node> nodes = new ArrayList<Node>();
        //将元素转为Node对象
        for (int i:array){
            nodes.add(new Node(i));
        }

        /**
         * 1.排序 从小到大
         * 2.取出最小的两个数    从集合   index:0  index:1
         *
         * Node newRoot = new Node(index:0+index:1)
         * newRoot.left = index:0
         * newRoot.right = index:1;
         *
         * nodes.remove(index:0);
         * nodes.remove(index:1);
         * nodes.add(newRoot);
         */
        while (nodes.size()>1){
            //排序  从小到大
            Collections.sort(nodes);

            System.out.println("集合中的元素: "+nodes);

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //创建的新的结点
            Node root = new Node(leftNode.value+rightNode.value);
            root.left = leftNode;
            root.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //添加新的节点
            nodes.add(root);
        }

        return nodes.get(0);
    }

    /**
     * 前序遍历
     */
    public static void preSelect(Node root){
        if (root !=null){
            root.preSelect();
        }else {
            System.out.println("空树，无数据...");
        }
    }

}
