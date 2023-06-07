/**
 * @name 稀疏数组实现类
 * @description 包含一个全量数组得生产，使用数组压缩为稀疏数组，使用链表压缩为稀疏数组，通过数组方式还原数组，通过链表方式还原数组
 */
class SpaceArray {

    public int[][] originArray;

    /**
     * @name 1 生产一个二维数组，通过两个循环生产一个二维矩阵数组
     * @description 为了让有效值尽可能得少，所以随机数得判定也要尽可能得概率小，因此可以设置为Math.random() > 0.9，这样子有效值得概率就是0.1了
     */
    public int[][] initProducer(int n) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = Math.random() > 0.9 ? 1 : 0;
            }
        }
        return result;
    }
//
//    /**
//     * @name 1.1 打印生产的二维数组
//     */
//    public void printfOriginArray() {
//        for (int[] row : originArray) {
//            for (int v : row) {
//                System.out.printf(" %d ", v);
//            }
//            System.out.print("\n");
//        }
//    }

    /**
     * @name 2 使用数组压缩为稀疏数组
     */
    public int[][] useArrayCompressed() {
        // 要想压缩原始数组，那么需要得到多少行和多少列，还有有效值的个数。
        // 比如这个类的，有效值是1，0就是无效值，所以可以通过循环得到不为0的个数，作为有效值的个数
        // 那么数组的的长度和均可以确定下来。
        // 如，数组的第一项为
        // 行 [0][0] = 第一维的长度， 列 [0][1] = 第二维的长度（为了简单认知，不考虑第二维的长度各不相等的问题），有效值个数 [0][2] = 即不为0的总数
        // 第一维的长度
        int rowLen = this.originArray.length;
        // 第二维的长度
        int colLen = 0;
        if (rowLen > 0) {
            colLen = this.originArray[0].length; // 假定长度都大于0
        }
        // 有效值的个数
        int sum = 0;
        for (int[] row : this.originArray) {
            for (int v : row) {
                if (v != 0) {
                    sum++;
                }
            }
        }
        // 初始化一个数组,数组的长度刚好是有效值的个数+1,这里的1代表第一项,用来存储基本信息,或者说是元信息[行总数,列总数,有效值总数],
        // 从第二项开始开始,每一行存放的是有效值的行索引,列索引,有效值
        int[][] result = new int[sum + 1][3];
        // 压缩后的数组的第一项的值应该是,行的总数,列的总数,有效值的总数
        result[0] = new int[]{rowLen, colLen, sum};

        // 通过循环原始数组的方式, 记录有效值的行索引,列索引,有效值到新的压缩数组里面
        // 为了方便移动压缩后的数组的指针，这里定义当前数组的指针，因为前面已经用过了压缩后的数组的第一项了，所以这里指针可以直接从0开始,代表指针指向第0号索引项
        int top = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (this.originArray[i][j] != 0) {
                    // 当遇到有效值时，游标移动，移动后，给当前索引的值赋值
                    top++;
                    // 分别时付有效值的行索引，有效值的列索引，有效值的值
                    int[] _r = new int[]{i, j, this.originArray[i][j]};
                    result[top] = _r;
                }
            }
        }
        return result;
    }

    /**
     * @name 2.1 把使用数组方式压缩的数组还原为原始数组
     */
    public int[][] useArrayUnCompressed(int[][] compressArray) {
        // 首先根据压缩数组的第一项，可以很方便的得到行总数，列总数，有效值总数。
        // 那么通过这三个参数，可以初始化一个空数组
        // 然后通过循环压缩后的数组长度, 按照有效值的行索引,列索引,把值给赋值到指定位置即可
        int rowLen = compressArray[0][0];
        int colLen = compressArray[0][1];
        int sum = compressArray[0][2];

        // 初始化一个没有有效值的原始数组
        int[][] result = new int[rowLen][colLen];
        int rowIndex = 0;
        int colIndex = 0;
        int value = 0;
        // 因此第一项为基本信息，所以i要从1索引出发
        for (int i = 1; i < compressArray.length; i++) {
            rowIndex = compressArray[i][0];
            colIndex = compressArray[i][1];
            value = compressArray[i][2];

            result[rowIndex][colIndex] = value;
        }
        return result;
    }

    /**
     * @name 3 使用链表压缩为稀疏数组
     * @return 链表头地址
     */
    class SparseNode {
        int row = 0;
        int col = 0;
        int value = 0;

        SparseNode next;

        public SparseNode(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public String toString() {
            return "SparseNode{" +
                    "row=" + row +
                    ", col=" + col +
                    ", value=" + value +
                    '}';
        }
    }

    public SparseNode useLinkedCompressed() {
        // 使用链表的形式来压缩原始数组，跟用数组压缩基本思路一样，只是数据存放的地方存到了一个节点的data里面了
        // 步骤，先定义一个节点类, 这里为了方便返回值，定义在此方法的外边，作为该类的内部类使用
        // 然后计算行的总数，列的总数，有效值的总数，把汇总信息放到第一个节点，然后从二个节点开始才是记录值的行索引，值的列索引，值自身
        // 定义好内部类后
        // 计算行总数，列总数，有效值总数，可以参考数组压缩的部分注释代码
        int rowLen = this.originArray.length;
        int colLen = 0;
        if (rowLen > 0) {
            colLen = this.originArray[0].length;
        }
        int sum = 0;
        for (int[] row : this.originArray) {
            for (int v : row) {
                sum++;
            }
        }

        // 初始化一个链表头
        SparseNode headNode = new SparseNode(0, 0, 0);

        // 设置第一项为行总数，列总数，有效值总数
        headNode.next = new SparseNode(rowLen, colLen, sum);

        // 循环原始数组，如果遇到有效值后，追加链表
        // 为了方便找到每一个索引，这里把第一项的节点的地址保存下来
        SparseNode tmp = headNode.next;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (this.originArray[i][j] != 0) {
                    tmp.next = new SparseNode(i, j, this.originArray[i][j]);
                    // 移动游标到下一个链表节点地址上
                    tmp = tmp.next;
                }
            }
        }
        return headNode;
    }


    /**
     * @param headNode {SparseNode} 链表头地址
     * @return int[][]
     * @name 3.1 把使用链表方式压缩的链表还原为原始数组
     */
    public int[][] useLinkedUnCompressed(SparseNode headNode) {
        // 与数组类似，首先要拿到拿到第一个节点里面的基本信息，包括行总数，列总数，有效值总数
        if (headNode.next == null) {
            throw new RuntimeException("链表为空");
        }
        // 通过第一项拿到索引
        SparseNode tmp = headNode.next;
        int rowLen = tmp.row;
        int colLen = tmp.col;
        int sum = tmp.value;

        int[][] result = new int[rowLen][colLen];

        // 通过链表的循环语句得到每一项
        while (true) {
            if (tmp.next == null) {
                break;
            }
            result[tmp.row][tmp.col] = tmp.value;
            tmp = tmp.next;
        }
        return result;
    }

}