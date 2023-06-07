package com.bjpowernode.binarysort;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class Test {

    public static void main(String[] args) {

        int[] array = {7,3,10,12,5,1,9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i=0;i<array.length;i++){
            binarySortTree.add(new Node(array[i]));
        }

        binarySortTree.infixSelect();
        System.out.println("-------------------------------------------------");

        binarySortTree.delNode(3);
        binarySortTree.infixSelect();




    }


}
