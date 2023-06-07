package com.zhaozheyun.base;


interface Win {
    public abstract void use(String action);
}

//远程服务器类
class OriginServer implements Win {

    public void use(String action) {
        System.out.println(action);
    }
}

//自己的电脑装有ssh
class SelfPC implements Win {
    private OriginServer originServer;

    public SelfPC(OriginServer originServer) {
        this.originServer = originServer;
    }


    public void use(String action) {
        System.out.println("等一会啊，我慢慢的链接看看等会给你消息");
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.originServer.use(action);
    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        new SelfPC(new OriginServer()).use("我在控制远程机器了");
    }
}
