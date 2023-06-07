package com.bjpowernode.linked;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class LinkedTest {

    public static void main(String[] args) {

        /*DualLinkedList dualLinkedList = new DualLinkedList();

        BookNode bookNode1 = new BookNode(1,"红楼梦",66.00);
        BookNode bookNode2 = new BookNode(2,"西游记",66.00);
        BookNode bookNode3 = new BookNode(3,"水浒传",66.00);
        BookNode bookNode4 = new BookNode(4,"三国演义",66.00);

        dualLinkedList.addLast(bookNode1);
        dualLinkedList.addLast(bookNode2);
        dualLinkedList.addLast(bookNode3);
        dualLinkedList.addLast(bookNode4);

        //dualLinkedList.delNode(1);
        dualLinkedList.updateNode(new BookNode(3,"计算机",66.00));

        System.out.println("");*/



        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1,2,5);













    }

}
