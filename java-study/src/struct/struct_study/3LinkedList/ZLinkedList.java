// 链表的方法
public interface ZLinkedList<T> {

    /**
     * @name 在链表尾部添加一个节点
     */
    public void push(T t);

    /**
     * @name 在链表尾部弹出一个节点
     */
    public T pop();

    /**
     * @name 查出全部节点
     */
    public void list();

    /**
     * @name 获取节点的长度
     */
    public int length();

    /**
     * @name 根据传入的值，更新某个节点，具体逻辑实现类自我实现
     */
    public void update(T t);

    /**
     * @name 根据传入的值，删除某个节点的值，具体逻辑实现类自我实现
     */
    public T delete(T t);

    /**
     * @name 根据传入的值，按照一定的顺序添加节点，具体逻辑顺序实现类自我实现
     */
    public void pushSort(T t);
}





































