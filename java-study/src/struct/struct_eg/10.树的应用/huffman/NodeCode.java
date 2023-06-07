package com.bjpowernode.huffman;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 *
 * Im
 *
 * I:1
 * m:1
 *
 *
 */
public class NodeCode implements Comparable<NodeCode>{
    //用来描述文字(字幕)十进制数
    public Byte data;

    public int weight;

    public NodeCode left;

    public NodeCode right;

    public NodeCode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public NodeCode(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(NodeCode o) {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "NodeCode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
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
}
