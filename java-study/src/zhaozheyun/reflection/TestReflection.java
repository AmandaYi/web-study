package com.zhaozheyun.reflection;

import com.zhaozheyun.charactor.Hero;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class TestReflection {
    public TestReflection() {

    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        Class p = null;
        try {

            p = Class.forName("com.zhaozheyun.charactor.Hero");
        } catch (Exception e) {
            Constructor self = p.getConstructor();
            Hero h = (Hero) self.newInstance();
//            h.name = "小明";
            Field f1 = h.getClass().getDeclaredField("name");
            f1.set(h, "小明A");
//        System.out.println(h);
        }

//        new Runnable(){
//            @Override
//            public void run() {
//                TestReflection.isEq();
//            }
//        };
//        TestReflection.isEq();
//
//       Class p1 = null;
//        try {
//            p1 = Class.forName("com.zhaozheyun.charactor.Hero");
//            System.out.println("1");
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        Class p3 = new TestReflection().getClass();
//        Class p2 = Hero.class;
    }

    //    判断三种获取类的方式,得到的结果是否相等
    public synchronized static void isEq() {
//        Class p1 = null;
//        try {
//            p1 = Class.forName("com.zhaozheyun.reflection.TestReflection");
//            System.out.println("1");
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        Class p2 = TestReflection.class;
//        System.out.println("2");
//
//        Class p3 = new TestReflection().getClass();
//        System.out.println("3");

//        if (p1 == p2) {
//            System.out.println("p1和p2相等");
//        }
//        if (p1 == p3) {
//            System.out.println("p1和p3相等");
//        }


    }

}
