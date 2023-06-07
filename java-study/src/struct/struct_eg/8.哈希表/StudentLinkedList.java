package com.bjpowernode.hashtable;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class StudentLinkedList {

    private Student head;


    /**
     * 添加结点
     *
     */
    public void add(Student newStudent){

        //1.如果添加时是第一个学生对象,则直接复制给第一个节点
        if (head == null){
            head = newStudent;
            return;
        }

        Student temp = head;

        while (true){
            if (temp.next == null){
                break;
            }
            //继续往后查找
            temp = temp.next;
        }
        //追加了新的结点
        temp.next = newStudent;
    }


    public void list(int no){

        if (head == null){
            System.out.println("第"+no+"链表是空...");
            return;
        }

        Student temp = head;
        while (true){
            System.out.printf("id=%d  name=%s\t",temp.id,temp.name);

            if (temp.next==null){
                break;
            }
            temp = temp.next;
        }

        System.out.println();


    }

    /**
     * 根据学员编号查询结点  id
     */
    public Student findById(int id){
        if (head == null){
            System.out.println("空链表...");
            return null;
        }

        Student temp = head;
        while (true){
            if (temp.id == id){
                break;
            }

            if (temp.next == null){
                temp = null;
                break;
            }
            temp = temp.next;
        }
        return temp;
    }






}
