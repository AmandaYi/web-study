package com.bjpowernode.binarysort;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class Node {

    public int value;

    public Node left;

    public Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 添加节点
     * @param node
     */
    public void add(Node node){
        if (node == null){
            return;
        }

        //传入的值与当前节点关系比较
        if (node.value<this.value){
            if (this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历   关键码值递增
     */
    public void infixSelect(){
        if (this.left !=null){
            this.left.infixSelect();
        }
        System.out.println(this);
        if (this.right !=null){
            this.right.infixSelect();
        }
    }

    /**
     *
     * @param val  关键码值
     * @return  删除的节点
     */
    public Node selectByVal(int val){
        if (this.value == val){
            return this;
        }else if (val <this.value){
            //查左子树
            if (this.left == null){
                return null;
            }
            return this.left.selectByVal(val);
        }else {
            //查询右子树
            if (this.right == null){
                return null;
            }
            return this.right.selectByVal(val);
        }
    }

    /**
     *
     * @param val  删除节点关键码值
     * @return   删除节点的父结点对象
     */
    public Node selectByParent(int val){
        if ((this.left !=null && this.left.value == val) || (this.right !=null && this.right.value==val)){
            return this;
        }else {
            if (val < this.value && this.left !=null){
                return this.left.selectByParent(val);
            }else if (val>=this.value && this.right !=null){
                return this.right.selectByParent(val);
            }else {
                return null;
            }
        }
    }


}
