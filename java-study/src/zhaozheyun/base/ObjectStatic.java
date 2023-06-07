package com.zhaozheyun.base;


class Test {
//    static class Test1 {
//        public static void welcome() {
//            System.out.println("hi");
//        }
//    }

    public static void say() {
        System.out.println("say");
    }

//   private static String name = "123";
//    public static String getName(){
//        return name;
//    }
//    public static void setName(String n){
//        name = n;
//    }
}

class Test2 extends Test {
    public static void say(){
        System.out.println("say 2");

    }
}

public class ObjectStatic {
    public static void main(String[] args) {
//        Test test = new Test();
//        Test.setName("456");
//        System.out.println(Test.getName());
//        Test.say();
//        Test.Test1.welcome();
//        Test2 test2 = new Test2();
        Test2.say();
    }
}
