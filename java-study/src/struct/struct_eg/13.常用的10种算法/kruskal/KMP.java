package com.bjpowernode.kruskal;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class KMP {

    public static void main(String[] args) {

        System.out.println(KMP("ABCDE","ABC",0));

    }

    public static int KMP(String s,String t,int pos){

        int i = pos-1;
        int j = -1;
        int[] next = getNext(t);
        while (i<s.length() && j<t.length()){
            if (j==-1 || s.charAt(i) == t.charAt(j)){
                j++;
                i++;
            }else {
                j = next[j];
            }
        }

        if (j == t.length()){
            return i-t.length();
        }else {
            return -1;
        }


    }



    public static int[] getNext(String t){
        int[] next = new int[t.length()];
        int m = 0;
        int n = -1;
        next[0] = -1;
        while (m<t.length()-1){
            if (n==-1 || t.charAt(m) == t.charAt(n)){
                m++;
                n++;
                if (t.charAt(m) !=t.charAt(n)){
                    next[m] = n;
                }else {
                    next[m] = next[n];
                }
            }else {
                n = next[n];
            }
        }
        return next;

    }

}
