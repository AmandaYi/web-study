package com.bjpowernode.kruskal;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class HanoiTower {

    public static void main(String[] args) {

        hanoitower(10,'A','B','C');


    }

    public static void hanoitower(int num,char a,char b,char c){
        if (num == 1){
            System.out.println("第"+num+"个盘从"+a+"---->"+c);
        }else {
            //把a移动到了b
            hanoitower(num-1,a,c,b);
            System.out.println("第"+num+"个盘从"+a+"---->"+c);
            hanoitower(num-1,b,a,c);
        }
    }

}
