package com.bjpowernode.huffman;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class Node implements  Comparable<Node>{

    public int value;

    public Node left;

    public Node right;


    public Node(int value) {
        this.value = value;
    }

    /**
     *
     * @param node
     * @return
     *
     * int
     * this.value  -    node.value
     *  -1  0   1
     */
    @Override
    public int compareTo(Node node) {

        return this.value-node.value;
    }

    /**
     * 前序遍历
     */
    public void preSelect(){
        System.out.println(this);
        if (this.left !=null){
            this.left.preSelect();
        }

        if (this.right !=null){
            this.right.preSelect();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
