package com.dadisdad.concurrency.printinorder;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 10308
 * @date 2020/4/1
 */
public class FooWithLock extends Foo {


    private Lock lock;
    private Condition condition1;
    private Condition condition2;
    private boolean firstFinished;
    private boolean secondFinished;

    public FooWithLock() {
        lock = new ReentrantLock();
        condition1 = lock.newCondition();
        condition2 = lock.newCondition();
        firstFinished = false;
        secondFinished = false;
    }


    @Override
    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            printFirst.run();
            firstFinished = true;
            condition1.signalAll();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (!firstFinished) {
                condition1.await();
            }
            printSecond.run();
            secondFinished = true;
            condition2.signalAll();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (!secondFinished) {
                condition2.await();
            }
            printThird.run();
        } finally {
            lock.unlock();
        }
    }
}
