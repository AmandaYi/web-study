package com.bjpowernode.clue;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class TestApp {

    public static void main(String[] args) {

        HeroNode root = new HeroNode(1,"吕布");

        HeroNode node2 = new HeroNode(3,"貂蝉");

        HeroNode node3 = new HeroNode(6,"曹操");

        HeroNode node4 = new HeroNode(8,"刘备");

        HeroNode node5 = new HeroNode(10,"关羽");

        HeroNode node6 = new HeroNode(14,"张飞");


        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ClueBianryTree clueBianryTree = new ClueBianryTree();
        clueBianryTree.setRoot(root);

        //把普通二叉树线索化为线索二叉树
        clueBianryTree.clueNode();


        //获取10的前驱和后继

        HeroNode left = node5.getLeft();
        HeroNode right = node5.getRight();
        System.out.println("10号结点前驱是:"+left.getNo()+"  后继是："+right.getNo());


        //把线索化二叉树按照中序遍历查询
        clueBianryTree.clueList();


    }

}
