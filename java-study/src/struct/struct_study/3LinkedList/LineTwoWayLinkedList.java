class DulNode {
    public int id;
    public String name;

    public DulNode next;
    public DulNode prev;

    public DulNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "DulNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

// 单一具有头节点的双向链表
public class LineTwoWayLinkedList implements ZLinkedList<DulNode> {
    DulNode headNode = new DulNode(0, "");

    @Override
    public void push(DulNode dulNode) {
        DulNode tmp = this.headNode;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;
        }
        tmp.next = dulNode;
        dulNode.prev = tmp;
    }

    @Override
    public DulNode pop() {
        // 首先判断是不是只有一个头结点，如果只有一个头节点，那么直接报错
        DulNode tmp = this.headNode;
        if (tmp.next == null) {
            throw new RuntimeException("双向链表为空");
        }
        while (true) {
            // 考虑假如如果长度为1的节点，如果发现这个节点是最后一个，那么需要把当前循环的节点的next指向null
            if (tmp.next.next == null) {
                break;
            }
            tmp = tmp.next;
        }
        DulNode popResult = tmp.next; // 存储要弹出的节点
        // 去掉弹出的节点的prev前驱引用
        tmp.next.prev = null;
        tmp.next = null;
        return popResult;
    }

    @Override
    public void list() {
//        判断空
        DulNode tmp = this.headNode;
        if (tmp.next == null) {
//            throw new RuntimeException("双向链表空");
            System.out.println("双向链表为空 + []");
            return;
        }
        tmp = tmp.next; // 从第一个元素开始。排除掉头结点
//        循环输出即可
        while (true) {
            if (tmp == null) {
                break;
            }
            System.out.println(tmp);
            tmp = tmp.next;
        }

    }

    @Override
    public int length() {
//        判断是否为空
        DulNode tmp = this.headNode;
        int result = 0;
        if (tmp.next == null) {
            return result;
        }
//        依次自增
        while (true) {
            if (tmp.next == null) {
                break;
            }
            result++;
            tmp = tmp.next;
        }
        return result;
    }

    @Override
    public void update(DulNode dulNode) {
        DulNode tmp = this.headNode;
        if (tmp.next == null) {
            throw new RuntimeException("链表为空");
        }

        boolean hasDulNode = false;
        while (true) {
            if (tmp.next == null) {
                break;
            }

            if (tmp.next.id == dulNode.id) {
                hasDulNode = true;
                break;
            }
            tmp = tmp.next;
        }
        if (hasDulNode) {
            tmp.next.name = dulNode.name;
        } else {
            System.out.println("没有找到节点" + dulNode);
        }
    }

    @Override
    public DulNode delete(DulNode dulNode) {
//        判断当前的链表是否为空，如果为空，直接抛异常
        DulNode tmp = this.headNode;
        if (tmp.next == null) {
            throw new RuntimeException("链表为空");
        }
        boolean hasDulNode = false;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            if (tmp.next.id == dulNode.id) {
                hasDulNode = true;
                break;
            }
            tmp = tmp.next;
        }
        if (hasDulNode) {
//            相当于找到了tmp.next，tmp.next就是要删除的节点
//            tmp.prev.next = tmp.next;
            tmp.next = tmp.next.next;
//            如果tmp刚好在最后一个节点，那么tmp.next即为空，对null是不可以进行调用的
            if (tmp.next != null) {
                tmp.next.prev = tmp;
            }
        } else {
            System.out.println("未找到");
        }
        return tmp;
    }

    @Override
    public void pushSort(DulNode dulNode) {
        DulNode tmp = this.headNode;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            // 如果下一项大于了当前的值，证明是可以排到这里的
            if (tmp.next.id > dulNode.id) {
                break;
            }
            if (tmp.next.id == dulNode.id) {
                // 如果相等就啥都不做
                break;
            }
            tmp = tmp.next;
        }
        dulNode.next = tmp.next;
        dulNode.prev = tmp;
        // 然后修改dulNode的前节点的next域为传入的节点
        tmp.next = dulNode;
        // 然后修改dulNode的后节点的prev域为传入的节点
        if (tmp.next != null) {
            tmp.next.prev = dulNode;
        }
    }

    public static void main(String[] args) {
        LineTwoWayLinkedList lineTwoWayLinkedList = new LineTwoWayLinkedList();
        lineTwoWayLinkedList.push(new DulNode(10, "宇宙"));
        lineTwoWayLinkedList.push(new DulNode(20, "万物"));
        lineTwoWayLinkedList.push(new DulNode(30, "时间"));
        lineTwoWayLinkedList.push(new DulNode(40, "红尘皆为虚无"));
        lineTwoWayLinkedList.push(new DulNode(50, "万物终会消散"));
    }
}
