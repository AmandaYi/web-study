public class ArrayStack implements ZStack {
    // 最大容量
    int maxStack = 0;
    // 索引指针
    int top = -1;
    // 定义一个栈
    int[] stack;

    // 构造器
    public ArrayStack(int maxStack) {
        this.maxStack = maxStack;
        this.stack = new int[maxStack];
    }

    // 压栈
    public void push(int v) {
        // 压栈， 增加数据，索引+1，然后在索引出赋上压入的值
        this.top += 1;
        this.stack[this.top] = v;
    }

    // 弹栈，返回值弹出了什么值，返回值可以用泛型，但是这里为了理解用int即可
    public int pop() {
        // 先把弹出的值保存下来，方便返回，然后索引减一
        int popResult = this.stack[this.top];
        this.top -= 1;
        return popResult;
    }

    public int length() {
        return this.top + 1;
    }

    // 查看
    public void list() {
        int len = this.length();
        for (int i = 0; i < len; i++) {
            System.out.printf("stack[%d] = %d", i, this.stack[i]);
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(1);
        arrayStack.pop();
        arrayStack.pop();
    }
}   