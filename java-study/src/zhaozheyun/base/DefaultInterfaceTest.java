package com.zhaozheyun.base;


interface Interface1 {
    public final double PI = 3.14;

    public default void say() {
        System.out.println(PI);
    }

    public abstract void welcome();
}

public class DefaultInterfaceTest implements Interface1 {
    public static void main(String[] args) {
        new DefaultInterfaceTest().say();

    }

    @Override
    public void welcome() {
        System.out.println("welcomme");
    }
}








interface Filial{
    default void help (){
        System.out.println("老妈，我来救你了");
    }

}
interface Spoony{
    default void help (){
        System.out.println("媳妇，别怕，我来了！");
    }
}
class Man implements Filial, Spoony {
    @Override
    public void help(){
        System.out.println("xxx");
        Filial.super.help();
        Spoony.super.help();
    }

    public static void main(String[] args) {
        new Man().help();
    }
}