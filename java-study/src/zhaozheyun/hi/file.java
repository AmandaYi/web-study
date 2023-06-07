package com.zhaozheyun.hi;

import java.io.File;

public class file {
    public static void main (String[] args) {
        String pathnameSuccess = "C:\\Users\\AmandaZhang\\Pictures\\1001183.jpg";
        File f = new File(pathnameSuccess);
        File[] list = f.listRoots();
        System.out.println(list[0]); // C

    }
}
