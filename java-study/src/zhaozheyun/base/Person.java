package com.zhaozheyun.base;

class Chinese extends Person {
    String name = "中文";

    public void welcome() {
        System.out.println("你好");
    }
}

class USA extends Person {
    public void welcome() {
        System.out.println("hi");
    }
    public void method(Person p) {
        if (p instanceof USA) {
            USA u2 =  (USA) p;
            u2.welcome();
        }
    }
}

public class Person {
    String name = "语言";

    public void welcome() {
        System.out.println("Person welcome");
    }

    public static void main(String[] args) {
        Person p = new Chinese();
        p.welcome(); // 你好
        System.out.println(p.name); // 语言


        // 父类强制类型转换为子类
        USA u = new USA();
        u.method(u);

        System.out.println(u.equals(p));
    }


}
