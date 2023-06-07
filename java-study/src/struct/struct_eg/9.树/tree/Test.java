package com.bjpowernode.tree;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class Test {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        Node root = new Node(1,"孙尚香");
        Node node2 = new Node(2,"夏侯惇");
        Node node3 = new Node(3,"貂蝉");
        Node node4 = new Node(4,"吕布");
        Node node5 = new Node(5,"虞姬");
        Node node6 = new Node(6,"王昭君");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node3.setLeft(node5);
        node3.setRight(node6);



        binaryTree.setRoot(root);


        binaryTree.delNode(5);

        binaryTree.preSelect();
        System.out.println("---------------------------------------------------------");
        binaryTree.infixSelect();
        System.out.println("---------------------------------------------------------");
        binaryTree.postSelect();


        /*Node node = binaryTree.postNode(5);
        if (node !=null){
            System.out.printf("信息为：id=%d name=%s",node.getNo(),node.getName());
        }else {
            System.out.println("没有找到结点");
        }*/

    }

}
