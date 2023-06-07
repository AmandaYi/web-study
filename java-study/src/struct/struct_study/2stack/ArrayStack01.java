public class ArrayStack01 implements ZStack {
    // 栈
    private int[] stack;
    //    栈的大小
    private int maxStack;
    //    索引
    private int top = -1;

    public ArrayStack01(int maxStack) {
        this.stack = new int[maxStack];
        this.maxStack = maxStack;
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
        if (!isFull()) {
            System.out.println(v);
            this.top++;
            this.stack[this.top] = v;
        } else {
            throw new RuntimeException("已达到最大长度，无法压栈");
        }
    }

    //    出栈、弹栈
    public int pop() {
        if (!isEmpty()) {
            int v = this.stack[this.top];
            this.top--;
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

    //    测试
    public static void main(String[] args) {
        ArrayStack01 list = new ArrayStack01(10);
//        压栈
        list.push(1);
//        输出
        list.list();
//        弹栈
        list.pop();
//        输出
        list.list();
//        弹栈,但是已经空了,再次弹栈报错,在大多数编程语言中,即使空了也不会报错,但是这里会为了说明细节,就主动抛出一个运行时错误.
        list.pop();
    }
}