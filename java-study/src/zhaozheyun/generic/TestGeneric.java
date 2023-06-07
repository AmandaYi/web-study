package com.zhaozheyun.generic;

import java.util.ArrayList;

public class TestGeneric {
    public static void main(String[] args) {
//        根据数字类的知识，设计一个集合，这个集合里即可以放整数，也可以放浮点数，但是不能放字符串

        ArrayList<Float> list = new ArrayList<Float>();
        list.add(1.1f);
        list.add(2.2f);
        list.add(3.3f);
        list.add(4.4f);
        list.add(5.5f);
    }

}
