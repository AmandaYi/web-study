package com.bjpowernode.array;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class SparseArray {

    public static void main(String[] args) {

        /**
         * 1.模拟出来棋盘数据，使用二维数组
         */
        int[][] array = new int[11][11];
        array[1][2] = 1;
        array[2][4] = 2;

        //打印棋盘查看效果
        for (int[] row :array){
            for (int val :row){
                System.out.printf("%d\t",val);
            }
            System.out.println();
        }

        /**
         * 需要把如上的二维数组中有效数据压缩至稀疏数组中去
         */
        //计算二维数组中有效数据
        int sum = 0;
        for (int i=0;i<11;i++){
            for (int j=0;j<11;j++){
                if (array[i][j] !=0){
                    sum++;
                }
            }
        }

        //定义稀疏数组
        int [][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = 11;//行
        sparseArray[0][1] = 11;//列
        sparseArray[0][2] = sum;//有效数据个数

        //把有效数据存放至稀疏数组中去
        int count= 0;
        for(int i=0;i<11;i++){//行的索引
            for (int j=0;j<11;j++){//列的索引
                //判断是否是有效数据
                if (array[i][j] !=0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }

        /**
         * 打印稀疏数组
         */
        for (int i=0;i<sparseArray.length;i++){
            System.out.printf("%d,%d,%d\t",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }


        /**
         * 把稀疏数组转原始二维数组（面试题）
         */

        int[][] oldArray = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i=1;i<=count;i++){
            oldArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("---------------------------------------------------");

        /**
         * 原始二维数组棋盘
         */
        for (int[] row:oldArray){
            for (int val:row){
                System.out.printf("%d\t",val);
            }
            System.out.println();
        }


    }


}
