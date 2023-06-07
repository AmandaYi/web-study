public class ArrayStack02 implements ZStack {
    // 栈
    private int[] stack;
    //    栈的大小
    private int maxStack;
    //    索引
    private int top = -1;

    public ArrayStack02(int maxStack) {
        this.stack = new int[maxStack];
        this.maxStack = maxStack;
    }

    // 自动扩容,扩容2倍，把值赋值一下
    public void expansion() {
        // 最大容量翻倍
        this.maxStack *= 2;
        // 保存当前的数组长度
        int len = this.length();
        // 声明一个扩容容量后的数组
        int[] tmp = new int[this.maxStack];
        // 把原有的数组的值，赋值给临时数组
        for (int i = 0; i < len; i++) {
            tmp[i] = this.stack[i];
        }
        this.stack = tmp; // 切换引用关系
    }

    // 自动缩减容量，在POP的时候，如果POP的长度远远小于了容量，那么自动缩减容量，避免浪费空间
    public void reduceStack() {
        this.maxStack /= 2;
        // 保存当前的数组长度
        int len = this.length();
        // 声明一个缩减容量后的数组
        int[] tmp = new int[this.maxStack];
        // 把原有的数组的值，赋值给临时数组
        for (int i = 0; i < len; i++) {
            tmp[i] = this.stack[i];
        }
        this.stack = tmp; // 切换引用关系
    }

    /*
     * 判空
     */
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * 判断是否无法插入
     */
    public boolean isFull() {
        return this.top == this.maxStack - 1;
    }

    //    入栈
    public void push(int v) {
        // 检查数组的最大容量，如果已满，那么扩容
        if (isFull()) {
            this.expansion();
        }
        // 正常添加
        this.top++;
        this.stack[this.top] = v;
        // if (!isFull()) {
        //    System.out.println(v);
        //    this.top++;
        //    this.stack[this.top] = v;
        // } else {
        //    throw new RuntimeException("已达到最大长度，无法压栈");
        // }
    }

    // 出栈、弹栈
    public int pop() {
        if (!isEmpty()) {
            int v = this.stack[this.top];
            this.top--;
            // 如果索引缩减后，索引依旧大于0，同时索引小于容量的1/4了，那么才会缩减空间
            if (this.top > -1 && (this.top <= (this.maxStack / 4))) {
                this.reduceStack();
            }
            return v;
        } else {
            throw new RuntimeException("长度为空，无法弹栈");
        }
    }

    public int length() {
        return this.top + 1;
    }

    public void list() {
        if (isEmpty()) {
            System.out.printf("[]");
            return;
        }
        int len = this.length();
        for (int i = 0; i < len; i++) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }

    public int getMaxStack() {
        return maxStack;
    }

    // 测试
    public static void main(String[] args) {
        ArrayStack02 list = new ArrayStack02(3);
        // 压栈
        list.push(1);
        list.push(1);
        list.push(1);
        // 达到最大容量后，依旧可以压栈
        list.push(1);
        list.push(1);
        list.list();

        // 举例自动缩减容量
        ArrayStack02 testPop = new ArrayStack02(100);
        testPop.push(1);
        testPop.push(2);
        testPop.push(3);
        testPop.push(4);
        testPop.push(5);
        testPop.push(5);
        testPop.push(5);
        testPop.pop();
        System.out.printf("%d\n", testPop.getMaxStack()); // 50
        testPop.pop();
        System.out.printf("%d\n", testPop.getMaxStack()); // 25
        testPop.pop();
        System.out.printf("%d\n", testPop.getMaxStack()); // 12
        testPop.pop();
        System.out.printf("%d\n", testPop.getMaxStack()); // 6
        testPop.pop();
        System.out.printf("%d\n", testPop.getMaxStack()); // 3
        testPop.pop();
        System.out.printf("%d\n", testPop.getMaxStack()); // 1
        testPop.pop();
        System.out.printf("%d\n", testPop.getMaxStack()); // 1
    }
}