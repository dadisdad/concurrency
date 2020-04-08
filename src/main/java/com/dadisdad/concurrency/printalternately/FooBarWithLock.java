package com.dadisdad.concurrency.printalternately;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 10308
 * @date 2020/4/8
 */
public class FooBarWithLock extends FooBar {

    private ReentrantLock lock;
    private Condition condition;
    private boolean flag;

    public FooBarWithLock(int n) {
        super(n);
        this.lock = new ReentrantLock();
        this.condition = this.lock.newCondition();
        this.flag = false;

    }

    @Override
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            lock.lock();
            try {
                if (flag) {
                    condition.await();
                }
                printFoo.run();
                flag = true;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    @Override
    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            lock.lock();
            try {
                if (!flag) {
                    condition.await();
                }
                printBar.run();
                flag = false;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
