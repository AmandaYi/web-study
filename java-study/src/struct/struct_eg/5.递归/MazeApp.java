package com.bjpowernode.maze;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class MazeApp {

    public static void main(String[] args) {

        int[][] map = new int[8][7];

        /**
         * 设置第一行和最后一行为墙，设置为 1
         */
        for(int i=0;i<7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }

        /**
         * 设置第一列和第7列为墙
         */
        for (int i=0;i<8;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }

        /**
         * 设置障碍墙
         */
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("新的迷宫");

        for (int i=0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }


        isRun(map,1,1);


        System.out.println("小球走的过线");
        for (int i=0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }


    }


    /**
     * 1.小球从哪一个位置开始触发，起始位置   1、1
     * 2.map是地图对象
     * 3、最终小球到达了  6、5
     * 4、元素为0时表示该点没有走过，元素为1表示是墙，元素为2时表示通过可以走，当元素3时已经走过了
     * 但是走不通。
     *
     */

    public static boolean isRun(int[][] map,int i,int j){
        if (map[6][5]==2){
            return true;
        }else {
            if (map[i][j]==0){//没有走过该点
                map[i][j] = 2;

                //下，右，上，左
                if (isRun(map,i+1,j)){
                    return true;
                }else if (isRun(map,i,j+1)){
                    return true;
                }else if (isRun(map,i-1,j)){
                    return true;
                }else if (isRun(map,i,j-1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }

            }else {
                return false;
            }


        }

    }

}
