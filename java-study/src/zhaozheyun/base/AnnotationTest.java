package com.zhaozheyun.base;


import java.lang.annotation.*;

//自定义注解
// SOURCE < CLASS < RUNTIME, 如果运行时能用，那么source源码级别的时候，注释肯定没有消失
@Retention(RetentionPolicy.RUNTIME) // 这个注解牛逼，主要用来保持注释，看看能不能保存到JSVM阶段
@Target(ElementType.TYPE)
@interface ZZyAnnotation {
    String value() default "赵哲云";
}

@ZZyAnnotation
public class AnnotationTest {
    public static void main(String[] args) {
        @SuppressWarnings(value = "unused")
        int aa = 11;


        Class clazz =  AnnotationTest.class;
        Annotation a = clazz.getAnnotation(ZZyAnnotation.class);
        ZZyAnnotation zZyAnnotation = (ZZyAnnotation) a; // 多态, 向下转型，造型
        String info = zZyAnnotation.value();
        System.out.println(info);
    }

    @Deprecated
    public void print() {
    }

    @Override
    public String toString() {
        return "100";
    }
}

