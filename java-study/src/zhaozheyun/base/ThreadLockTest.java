package com.zhaozheyun.base;

import java.math.BigInteger;
import java.util.concurrent.locks.ReentrantLock;

//银行有一个账户。
//有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
//印账户余额。
//使用lock
class BlankSystem {
    static Integer amount = 10000;

    public static Integer getAmount() {
        return amount;
    }

    public static void setAmount(Integer amount) {
        BlankSystem.amount = amount;
    }
}

class UseSystem implements Runnable {
    public static final ReentrantLock reentrantLock = new ReentrantLock();
    private Integer willSendAmount = 0;

    public UseSystem(Integer willSendAmount) {
        this.willSendAmount = willSendAmount;
    }

    @Override
    public void run() {
        UseSystem.reentrantLock.lock();
        BlankSystem.setAmount(BlankSystem.getAmount() + this.willSendAmount);
        System.out.println("现在的金额是" + BlankSystem.getAmount());
        UseSystem.reentrantLock.unlock();
    }
}

public class ThreadLockTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            UseSystem useSystem1 = new UseSystem(3000);
            new Thread(useSystem1).start();
        }
        for (int i = 0; i < 3; i++) {
            UseSystem useSystem2 = new UseSystem(3000);
            new Thread(useSystem2).start();
        }
        Thread.sleep(3000);
    }

}
