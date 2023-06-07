package com.bjpowernode.tree;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class Node {

    private int no;

    private String name;

    private Node left;

    private Node right;

    /**
     *
     */
    public Node(int no,String name){
        this.no = no;
        this.name = name;

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }


    /**
     * 定义前序遍历
     */
    public void preSelect(){
        //先输出父结点
        System.out.println(this);
        if (this.left !=null){
            this.left.preSelect();
        }
        if (this.right !=null){
            this.right.preSelect();
        }
    }


    /**
     * 中序遍历结点
     */
    public void infixSelect(){
        // 左节点   父节点  右节点
        if (this.left !=null){
            this.left.infixSelect();
        }

        System.out.println(this);

        if (this.right !=null){
            this.right.infixSelect();
        }

    }

    /**
     * 后序遍历
     */
    public void postSelect(){
        if (this.left !=null){
            this.left.postSelect();
        }
        if (this.right !=null){
            this.right.postSelect();
        }

        System.out.println(this);

    }


    /**
     * 前序遍历查找
     */
    public Node preSearch(int no){

        //判断是否是当前节点
        if (this.no == no){
            return this;
        }

        //查询左子节点
        Node lNode = null;
        if (this.left !=null){
            lNode = this.left.preSearch(no);
        }

        if (lNode !=null){
            return lNode;
        }

        //查询当前节点右子节点，如果不为空，则继续递归前序查找
        if (this.right !=null){
            lNode = this.right.preSearch(no);
        }

        return lNode;

    }

    /**
     * 中序遍历查找
     */
    public Node infixSearch(int no){
        Node node = null;

        if (this.left !=null){
            node = this.left.infixSearch(no);
        }

        if (node !=null){
            return node;
        }

        /**
         * 对比当前节点
         */
        if (this.no == no){
            return this;
        }

        /**
         * 遍历右子结点
         */
        if (this.right !=null){
            node = this.right.infixSearch(no);
        }
        return node;
    }

    /**
     * 后序遍历查找结点
     * @param no
     * @return
     */
    public Node postSearch(int no){

        Node node = null;
        if (this.left !=null){
            node = this.left.postSearch(no);
        }

        if (node !=null){
            return node;
        }


        if (this.right !=null){
            node = this.right.postSearch(no);
        }

        if (node !=null){
            return node;
        }


        if (this.no == no){
            return this;
        }

        return node;

    }

    /**
     * 删除节点两种情况：
     * 1.删除的结点是叶子结点
     * 2.删除的结点是子树。非叶子结点
     *
     * 3.单向二叉树
     */

    public void delNode(int no){

        /**
         *1、当前节点左节点不为空，并且左子节点就是需要删除的结点，this.left=null
         *2、当前结点右结点不为空，并且右子节点就是需要删除的结点，this.right = null;
         *3、如果1，2步没有执行，那么需要向左子树进行递归删除
         *4、如果第3步没有执行，那么则向右子树进行递归删除
         *
         */

        if (this.left !=null && this.left.no == no){
            this.left = null;
            return;
        }

        if (this.right !=null && this.right.no == no){
            this.right = null;
            return;
        }

        /**
         * 向左子树进行递归删除
         */
        if (this.left !=null){
            this.left.delNode(no);
        }

        /**
         * 向右子树进行递归删除
         */
        if (this.right !=null){
            this.right.delNode(no);
        }


    }



}
