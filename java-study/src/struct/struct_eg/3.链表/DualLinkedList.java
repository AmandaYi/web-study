package com.bjpowernode.linked;

import java.awt.print.Book;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class DualLinkedList {

    private BookNode head = new BookNode(0,"",0.0);


    /**
     * 添加结尾新的节点
     * @param newNode
     */
    public void addLast(BookNode newNode){
        BookNode temp = head;

        while (true){

            //如果第一次进来则进入，表示双向链表是空数据
            if (temp.next == null){
                break;
            }

            temp = temp.next;
        }
        /**
         * 需要把新的节点给上一个节点
         * 需要把上一个节点next指向新的节点
         */
        temp.next = newNode;
        newNode.pre = temp;


    }

    /**
     * 修改节点
     * 条件：双向链表中的每一个结点的id和修改的id对比，如果对比成功，则进行修改该结点
     * ，如果没有对比成功，双向链表中未找到目标结点
     */
    public void updateNode(BookNode node){
        //是否是空链表
        if (head.next == null){
            System.out.println("空链表...");
            return;
        }

        BookNode temp = head.next;

        boolean flg = false;
        while (true){
            if (temp == null){
                break;
            }

            if (temp.id == node.id){
                flg = true;
                break;
            }

            temp = temp.next;
        }

        if (flg){
            temp.name = node.name;
            temp.price = node.price;
        }else {
            System.out.println("未找到要修改的节点...");
        }
    }

    /**
     * 双向链表删除
     *  条件：根据id编号进行删除节点
     */
    public void delNode(int id){
        if (head.next == null){
            System.out.println("空链表...");
            return;
        }

        BookNode temp = head.next;
        boolean flg = false;
        while (true){
            if (temp == null){
                break;
            }

            if (temp.id == id){
                flg = true;
                break;
            }

            temp = temp.next;
        }

        if (flg){
            temp.pre.next = temp.next;
            if (temp.next !=null){
                temp.next.pre = temp.pre;
            }

        }else {
            System.out.println("未找到该结点...");
        }


    }



}
