package com.zhaozheyun.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestException {
    public static void main(String[] args) throws FileNotFoundException {
//        String pathnameSuccess = "C:\\Users\\AmandaZhang\\Pictures\\1001183.jpg";
//        String pathnameFail = "C:\\Users\\AmandaZhang\\Pictures\\xxx.jpg";
//        File f = new File(pathnameFail);
//        try {
//            new FileInputStream(f);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally{
//            System.out.println("无论文件是否存在， 都会执行的代码");
//        }
//        return;
        TestException te = new TestException();
//        String s = te.showFile();
//        System.out.println(s);
        te.arithmetic();
        te.arrayIndexOutOfBounds();
    }
//    除数不能为0
    public void arithmetic () {
        int i = 10 / 0;
    }
//    数组越界
    public void arrayIndexOutOfBounds () {
        int[] list = new int[10];
        list[11] = 11;

    }
    public void nullPointer() {
        String s = null;
        s.length();
    }

    public String showFile() {
        try {
            String s = this.openFile();
            System.out.println(s);
        } catch (FileNotFoundException e) {
            System.out.println("文件展示失败！");
        }
        finally {
            System.out.println("showFile is running!");
        }
        return "";
    }

    public String openFile() throws FileNotFoundException {
        String pathnameSuccess = "C:\\Users\\AmandaZhang\\Pictures\\1001183.jpg";
        try {
            File f = new File(pathnameSuccess);
            new FileInputStream(f);
        } catch (FileNotFoundException e) {
            System.out.println("打开文件失败！");
        } finally {
            System.out.println("openFile is running!");
        }
        File f = new File(pathnameSuccess);
        new FileInputStream(f);
        return pathnameSuccess;
    }
}