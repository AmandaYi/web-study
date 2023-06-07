public class QueueArrayImpl {
    // 用来存储队列的数组，为了简便，使用int数组，也可以使用泛型数组。
    int[] queue;
    // 数组的最大容量
    int maxStack;
    // 队列队首指针指向，默认是-1.不指向任何项
    int frontPoint;
    // 队列队尾指针指向，默认是-1，不指向任何项
    int realPoint;

    /**
     * @param maxStack
     * @name 构造器，用于类的初始化
     * @description 主要是初始化存放队列的数组
     * @description 数组的最大容量
     * @description 队列队首指针指向初始值-1，队列队尾指针指向初始值-1
     */
    public QueueArrayImpl(int maxStack) {
        this.queue = new int[maxStack];
        this.maxStack = maxStack;
        this.frontPoint = -1;
        this.realPoint = -1;
    }

    /**
     * @name 判断队列已满
     * @descrition 原理，队列队尾指针指向如果指向了最后一个值，那么就认为这个队列已经是满载状态了。
     * @return {boolean}
     */
    public boolean isFull() {
        return this.realPoint == this.maxStack - 1;
    }

    /**
     * @name 判断队列空
     * @descrition 原理，队列队首指针是递增的，当队首指针递增到与队列队尾指针相同的位置，代表了队列是空的。
     * @return {boolean}
     */
    public boolean isEmpty() {
        return this.frontPoint == this.realPoint;
    }

    /**
     * @name 入列
     * @description 对队列而言，入列就相当于从队尾推进一个值，同时把队列队尾指针指向新添加的这个值。
     */
    public void set(int t) {
        if (this.isFull()) {
            System.out.println("队列满了");
            return;
        }
        this.realPoint++;
        this.queue[this.realPoint] = t;
    }

    /**
     * @name 出列
     * @description 对队列而言，出列就相当于从队首弹出一个值，同时把队列队首指针指向弹出值得后一个指针。
     */
    public int get() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列空");
        }
        this.frontPoint++;
        int result = this.queue[this.frontPoint];
        return result;
    }

    /**
     * @name 查找第一个值
     * @description 根据队列队首指针指向的值，查找第一个值。
     */
    public int findFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列空");
        }
        return this.queue[this.frontPoint];
    }
}