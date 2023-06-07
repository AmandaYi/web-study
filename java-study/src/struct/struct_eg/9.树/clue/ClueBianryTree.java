package com.bjpowernode.clue;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class ClueBianryTree {

    private HeroNode root;


    //当前结点前驱节点指针
    private HeroNode pre=null;


    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 调用这个方法等于把非线索化二叉树转线索化二叉树
     */
    public void clueNode(){
        this.clueNode(root);
    }

    /**
     * 把普通二叉树转线索化二叉树
     *
     * root
     */
    public void clueNode(HeroNode node){

        //判断是否可以线索化当前节点

        if (node == null){
            return;
        }

        //先线索化左子树
        clueNode(node.getLeft());


        //处理当前结点前驱
        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setNoLeft(1);
        }

        //处理当前结点后继
        if (pre !=null && pre.getRight() ==null){
            pre.setRight(node);
            pre.setNoRight(1);
        }

        //保证处理完一个结点后，就需要让当前节点作为下一个结点的前驱
        pre = node;


        clueNode(node.getRight());
    }


    /**
     * 遍历线索化二叉树
     */
    public void clueList(){

        //临时结点
        HeroNode node = root;

        while (node !=null){


            /**
             * 向左查询头结点
             */
            while (node.getNoLeft() == 0){
                node = node.getLeft();
            }

            System.out.println(node);

            while (node.getNoRight() ==1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();

        }

    }


}
