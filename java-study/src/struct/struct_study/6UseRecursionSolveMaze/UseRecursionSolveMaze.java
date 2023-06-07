
public class UseRecursionSolveMaze {

    int[][] map;

    //    初始化地图
    public void initMap(int rowLen, int colLen) {
//        rowLen 和colLen都大点，长度为10起步
        if (rowLen < 10) {
            rowLen = 10;
        }
        if (colLen < 10) {
            colLen = 10;
        }
//        1代表墙体，0代表路线
        this.map = new int[rowLen][colLen];

//        让四周先设置为墙
//        设置第一行和最后一行为墙
        for (int i = 0; i < colLen; i++) {
            this.map[0][i] = 1;
            this.map[rowLen - 1][i] = 1;
        }

//        设置第一列和最后一列为墙
        for (int i = 0; i < rowLen; i++) {
            this.map[i][0] = 1;
            this.map[i][colLen - 1] = 1;
        }

//        设置几个墙
        this.map[3][1] = 1;
        this.map[3][2] = 1;
        this.map[3][3] = 1;
        this.map[3][4] = 1;
        this.map[3][5] = 1;
        this.map[3][6] = 1;

        this.map[5][5] = 1;
        this.map[5][6] = 1;
        this.map[5][7] = 1;

        this.map[5][8] = 1;

        this.map[8][5] = 1;
        this.map[8][6] = 1;
        /**
         1 1 1 1 1 1 1 1 1 1
         1 0 0 0 0 0 0 0 0 1
         1 0 0 0 0 0 0 0 0 1
         1 1 1 1 1 1 1 0 0 1
         1 0 0 0 0 0 0 0 0 1
         1 0 0 0 0 1 1 1 1 1
         1 0 0 0 0 0 0 0 0 1
         1 0 0 0 0 0 0 0 0 1
         1 0 0 0 0 1 1 0 0 1
         1 1 1 1 1 1 1 1 1 1
         **/
    }

    //    输出迷宫
    public void printfMaze() {
        for (int[] row : this.map) {
            for (int v : row) {
                System.out.printf("%d ", v);
            }
            System.out.print("\n");
        }
    }

    //    调用走迷宫的函数
//    传入起点位置和终点
    private int startRowIndex = 0;
    private int startColIndex = 0;
    private int endRowIndex = 0;
    private int endColIndex = 0;

    public void startRun(int startRowIndex, int startColIndex, int endRowIndex, int endColIndex) {
//        记录起点和终点位置的索引
        this.startRowIndex = startRowIndex;
        this.startColIndex = startColIndex;
        this.endRowIndex = endRowIndex;
        this.endColIndex = endColIndex;
//        检查者
        this.tryRun();
    }

    public boolean tryRun() {

        return true;
    }

    ;


    public static void main(String[] args) {
        UseRecursionSolveMaze useRecursionSolveMaze = new UseRecursionSolveMaze();
        useRecursionSolveMaze.initMap(10, 10);
        useRecursionSolveMaze.printfMaze();
        useRecursionSolveMaze.startRun(0, 0, 9, 9);

    }

}
