class StackNode {
    int id;
    StackNode next;

    public StackNode(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "id=" + id +
                '}';
    }
}

// 单链表实现栈
//链表实现栈，要先考虑的是栈的特点，先进后出,
public class LinkedListStack {

    StackNode headNode = new StackNode(0);

    int top = -1;
    int maxStack = 0;

    public LinkedListStack(int maxStack) {
        this.maxStack = maxStack;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return (this.top + 1) == maxStack;
    }

    // 在头部插入
    public void push(StackNode stackNode) {
        if (this.isFull()) {
            throw new RuntimeException("栈已满");
        }
        StackNode tmp = this.headNode;
//        在头部插入数据
//        把即将要插入的节点的next指向头节点所指向的节点地址
        stackNode.next = tmp.next;
//        把头节点的next指向插入的节点
        tmp.next = stackNode;
        top++;
    }

    //  在头部弹出
    public int pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        // 弹出指的总是头部的节点
        StackNode tmp = this.headNode;
        StackNode popStackNode = tmp.next;

        tmp.next = tmp.next.next;
        top--;

        return popStackNode.id;
    }


    public int length() {
        return this.top + 1;
    }

    public void list() {
        if (this.isEmpty()) {
            System.out.println("[]");
            return;
        }

        StackNode tmp = this.headNode;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            System.out.println(tmp);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack(3);
        linkedListStack.push(new StackNode(0));
        linkedListStack.push(new StackNode(1));
        linkedListStack.push(new StackNode(2));
        linkedListStack.list();
//        linkedListStack.push(new StackNode(3)); // Exception in thread "main" java.lang.RuntimeException: 栈已满
        linkedListStack.pop();
        linkedListStack.list();
    }
}

