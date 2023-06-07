package com.zhaozheyun.multiplethread;


import java.util.LinkedList;

public class ThreadPool {
    int poolCount;


    // 任务容器
    LinkedList<Runnable> tasks = new LinkedList<Runnable>();


    public ThreadPool(int poolCount) {
        if (poolCount == 0) {
            poolCount = 10;
        }
        for (int i = 0; i < poolCount; i++) {
            new TaskConsumeThread("消费者线程" + (i + ""));
        }
    }

    public void add(Runnable r) {
        synchronized (tasks) {
            tasks.add(r);
            // 唤醒等待的任务消费者线程
            tasks.notifyAll();
        }
    }

    //    innerClass
    class TaskConsumeThread extends Thread {
        String name = "";

        TaskConsumeThread(String name) {
            this.name = name;
        }

        Object o = new Object();
        Runnable task;

        @Override
        public void run() {
            synchronized (o) {
                while (tasks.isEmpty()) {
                    try {
                        tasks.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                task = tasks.removeLast();
                // 允许添加任务的线程可以继续添加任务
                tasks.notifyAll();
            }
            System.out.println(this.getName() + " 获取到任务，并执行");
            task.run();
        }
    }


}
