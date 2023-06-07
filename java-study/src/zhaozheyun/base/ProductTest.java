package com.zhaozheyun.base;

//线程通信
//售货员
class Clerk {
    private int product = 0;

    public synchronized void addProduct() {
        if (this.product > 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            this.product++;
            System.out.println("生产者生产了第" + product + "个产品");

            notifyAll();
        }
    }

    public synchronized void getProduct() {
        if (this.product <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            this.product--;
            System.out.println("消费者取走了第" + product + "个产品");

            notifyAll();
        }
    }

}


// 生产者
class Productor implements Runnable {
    Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产产品");
        while (true) {
            try {
//                Thread.sleep((int) Math.random() * 1000);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
}

//消费者
class Consumer implements Runnable {
    Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者开始取走产品");
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.getProduct();
        }
    }
}


public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Thread productThread = new Thread(new Productor(clerk));
        Thread consumerThread = new Thread(new Consumer(clerk));
        productThread.start();
        consumerThread.start();
    }
}
