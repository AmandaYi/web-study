package com.zhaozheyun.object;


class ZhaoTongbin {
    public void welcome(){
        System.out.println("hi");
    }
};

class ZhaoZheyun extends ZhaoTongbin {
    @Override
    public void welcome(){
        System.out.println("你好");
    }
}

class ZhaoJunzhe extends ZhaoTongbin {
    @Override
    public void welcome() {
        System.out.println("你好呀");
    }
}


public class ObjectTest {
    public static void main(String[] args) {
//        我在外边，人家看到我在做一个跟我爸爸一样的动作，就想起来我爸爸了
        ZhaoZheyun zhaoZheyun = new ZhaoZheyun();

        ZhaoTongbin zhaoTongbin = zhaoZheyun;

        zhaoTongbin.welcome();

//        第二天，赵浚哲在外边，人家看到赵浚哲在做一个跟我爸爸一样的动作
        ZhaoJunzhe zhaoJunzhe = new ZhaoJunzhe();

        ZhaoTongbin zhaoTongbin1 = zhaoJunzhe;

        zhaoTongbin1.welcome();


    }
}
