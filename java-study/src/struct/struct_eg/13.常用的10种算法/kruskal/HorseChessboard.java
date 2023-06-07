package com.bjpowernode.kruskal;

import com.bjpowernode.huffman.Test;
import com.sun.org.apache.regexp.internal.RE;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class HorseChessboard {

    private static int X;

    private static int Y;

    //判断是否已经访问过
    private static boolean[] visited;

    //表示棋盘中所有的位置是否都被标记了
    private static boolean finished;

    public static void main(String[] args) {

        //描述棋盘
        X = 8;
        Y = 8;
        int row = 1;
        int column = 1;

        int[][] chessBoard = new int[X][Y];
        visited = new boolean[X*Y];


        long start = System.currentTimeMillis();
        chessboard(chessBoard,row-1,column-1,1);

        long end = System.currentTimeMillis();

        System.out.println(end-start);

    }

    public static void chessboard(int[][] chessBoard,int row,int column,int step){
        chessBoard[row][column] = step;
        visited[row*X+column] = true;

        //没跳一步，都要计算当前所在的位置下一步要跳的位置数量，可以存储在集合中去
        ArrayList<Point> ps = next(new Point(column, row));

        //预判未来要跳的次数，减少回溯
        sort(ps);

        while (!ps.isEmpty()){
            Point nextPiont = ps.remove(0);
            if (!visited[nextPiont.y*X + nextPiont.x]){
                chessboard(chessBoard,nextPiont.y,nextPiont.x,step+1);
            }
        }

        //计算当前已经走的次数是否已经走完，完成任务 step<x*y,
        if (step<X*Y && !finished){
            chessBoard[row][column] = 0;
            visited[row*X+column] = false;
        }else {
            finished = true;
        }

    }

    /**
     *
     * @param curPoint 当前所在的位置
     * @return  下一次跳的位置集合
     */
    public static ArrayList<Point> next(Point curPoint){
        ArrayList<Point> ps = new ArrayList<>() ;
        Point point = new Point();

        if ((point.x = curPoint.x-2)>=0  && (point.y = curPoint.y-1)>=0){
            ps.add(new Point(point));
        }

        if ((point.x = curPoint.x-1)>=0  && (point.y = curPoint.y-2)>=0){
            ps.add(new Point(point));
        }

        if ((point.x = curPoint.x+1)<X  && (point.y = curPoint.y-2)>=0){
            ps.add(new Point(point));
        }

        if ((point.x = curPoint.x+2)<X  && (point.y = curPoint.y-1)>=0){
            ps.add(new Point(point));
        }

        if ((point.x = curPoint.x+2)<X  && (point.y = curPoint.y+1)<Y){
            ps.add(new Point(point));
        }

        if ((point.x = curPoint.x+1)<X  && (point.y = curPoint.y+2)<Y){
            ps.add(new Point(point));
        }

        if ((point.x = curPoint.x-1)>=0  && (point.y = curPoint.y+2)<Y){
            ps.add(new Point(point));
        }

        if ((point.x = curPoint.x-2)>=0  && (point.y = curPoint.y+1)<Y){
            ps.add(new Point(point));
        }
        return ps;
    }



    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int count1 = next(o1).size();
                int count2 = next(o2).size();

                if (count1<count2){
                    return -1;
                }else if (count1 == count2){
                    return 0;
                }else {
                    return 1;
                }
            }
        });

    }

}
