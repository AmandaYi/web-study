package com.zhaozheyun.base;

public class StringTest {
    public static void main(String[] args) {
        String str = "hello";
//本质上this.value = new char[0];
        String s1 = new String();
//this.value = original.value;

        String s2 = new String(str);
//this.value = Arrays.copyOf(value, value.length);
        char[] a = {1,2,3};
        String s3 = new String(a);
        char[] b = {1,2,3};
        String s4 = new String( b,1, 1);
        System.out.println(s4);
    }
}
