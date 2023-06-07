package com.bjpowernode.binarysort;

import java.util.Arrays;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class BinarySortTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    /**
     * 查询
     * @param val
     * @return
     */
    public Node selectByVal(int val){
        if (root == null){
            return null;
        }else {
            return root.selectByVal(val);
        }
    }

    /**查询父节点
     */
    public Node selectByParent(int val){
            if (root == null){
                System.out.println("root is null");
                return null;
            }else {
                return root.selectByParent(val);
            }
    }

    /**
     * 添加节点
     */
    public void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void infixSelect(){
        if (root != null){
            root.infixSelect();
        }else {
            System.out.println("空树...");
        }
    }


    /**
     * 找出右子树中最小值
     */
    public int rightTreeMin(Node node){

        Node target = node;
        while (target.left !=null){
            target = target.left;
        }

        delNode(target.value);
        return target.value;
    }
    /**
     * 删除节点
     * 1.如果删除的节点是叶子节点，找到父节点直接删除关联
     * 2.如果的点带有左子树或者带有右子树，把左子树或右子树的节点交给删除该节点的父结点
     * 3.如果删除的节点带有双亲节点，可以从左子树中找一个最大节点替换山删除节点，也可以找右子树最小的值节点
     * 替换要删除的节点
     *
     */
    /**
     * 删除的节点
     * @param val
     */
    public void delNode(int val){
        if (root == null){
            return;
        }else {
            Node target = selectByVal(val);
            if (target == null){
                return;
            }

            if (root.left == null && root.right == null){
                root = null;
                return;
            }

            //找到目标节点父结点
            Node parentNode = selectByParent(val);

            //1.假设删除的是一个叶子节点
            if (target.left == null && target.right == null){

                //判断删除节点时父结点的左节点还是右节点
                if (parentNode.left !=null && parentNode.left.value == val){
                    //左节点
                    parentNode.left = null;
                }else if (parentNode.right !=null && parentNode.right.value == val){
                    parentNode.right = null;
                }

            }else if (target.left !=null && target.right !=null){
                int minVal = rightTreeMin(target.right);
                target.value = minVal;
            }else {
                //删除只有一个子树(可能右子树，可能是左子树)
                if (target.left !=null){//左子树
                    if (parentNode !=null){
                        //确定是左子节点
                        if (parentNode.left.value == val){
                            parentNode.left = target.left;
                        }else {//右节点
                            parentNode.right = target.left;
                        }

                    }else {
                        root = target.left;
                    }

                }else {//右节点
                     if (parentNode !=null){
                         if (parentNode.left.value == val){
                             parentNode.left = target.right;
                         }else {
                             parentNode.right = target.right;
                         }
                     }else {
                         root = target.right;
                     }
                }

            }

        }

    }
}
