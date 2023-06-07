package com.zhaozheyun.base;

class NormalBlock {
    public static String name;
    private String pName;

    static {
        name = "1";

        System.out.println(name);
    }

    public NormalBlock() {
        System.out.println("无参构造器");
    }
    static {
        name = "2";
        System.out.println(name);
    }

    {
        pName = "普通变量1";
        System.out.println(pName);
    }

    {
        pName = "普通变量2";
        System.out.println(pName);
    }

    {
        pName = "普通变量3";
        System.out.println(pName);
    }

    static {
        name = "3";
        System.out.println(name);
    }
}


public class StaticBlockTest {
    public static void main(String[] args) {
//        new NormalBlock();
//        new NormalBlock();
        System.out.println(NormalBlock.name);
        new NormalBlock();

    }
}
