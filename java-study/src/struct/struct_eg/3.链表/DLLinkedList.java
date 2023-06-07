package com.bjpowernode.linked;

import java.text.BreakIterator;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class DLLinkedList {

    private GoodsNode node = new GoodsNode(0,"",0.0);


    /**
     * 往链表中添加结点
     */
    public void add(GoodsNode goodsNode){
        GoodsNode temp = node;
        while (true){
            if (temp.next == null){
              break;
            }
            temp = temp.next;
        }

        temp.next = goodsNode;

    }

    /**
     * 按照商品编号id值进行添加，从小到大的顺序添加
     */
    public void addOrder(GoodsNode goodsNode){
        GoodsNode temp = node;
        boolean flg = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.id>goodsNode.id){
                break;
            }else if (temp.next.id==goodsNode.id){
                flg=true;
                break;
            }

            temp = temp.next;
        }

        if (flg){
            System.out.println("已经存在了该商品，不能添加重复元素");
        }else {
            goodsNode.next = temp.next;
            temp.next = goodsNode;
        }

    }

    /**
     * 修改结点
     * 1.先找到链表中目标结点，
     * 2.根据新的数据修改
     * 3.根据商品编号进行查找，
     */
    public void updateNode(GoodsNode goodsNode){
        /**
         * 如果链表空
         */
        if (node.next == null){
            System.out.println("链表为空...");
            return;
        }

        GoodsNode temp = node.next;

        //标识符，表示找到了结点
        boolean flg = false;
        while (true){
            if (temp == null){
                break;
            }

            if (temp.id == goodsNode.id){
                flg = true;
                break;
            }

            temp = temp.next;
        }

        if (flg){
            //真正的修改结点
            temp.name = goodsNode.name;
            temp.price = goodsNode.price;
        }else {
            System.out.println("在整个链表中未找到目标节点...");
        }
    }

    /**
     * 结点删除功能
     * 条件：根据结点的编号删除
     *
     */
    public void delNode(int id){

        GoodsNode temp = node;

        boolean flg = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.id == id){
                flg = true;
                break;
            }
            temp = temp.next;
        }

        if (flg){
            temp.next = temp.next.next;
        }else {
            System.out.println("未找到删除的结点...");
        }

    }

    /**
     * 定义查看链表中每一个结点元素
     */
    public void list(){
        if (node.next == null){
            System.out.println("空链表");
            return;
        }

        GoodsNode temp = node.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);

            temp = temp.next;
        }
    }

    /**
     * 面试题
     * 计算单链表中存在的节点个数
     * 不统计头结点
     */
    public int getLength(){
        if (node.next == null){
            System.out.println("空链表");
            return 0;
        }

        GoodsNode temp = node.next;
        int length = 0;
        while (temp !=null){
            //结点个数
            length++;

            temp = temp.next;
        }

        return length;
    }

}



