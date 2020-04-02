package com.dadisdad.concurrency.printinorder;

/**
 * @author 10308
 * @date 2020/4/2
 */
public class FooWithSynchronized extends Foo {

    private int state;
    private Object lock = new Object();

    public FooWithSynchronized() {
        state = 0;
    }

    @Override
    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            while (state != 0) {
                lock.wait();
            }
            printFirst.run();
            state = 1;
            lock.notifyAll();
        }
    }

    @Override
    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (state != 1) {
                lock.wait();
            }
            printSecond.run();
            state = 2;
            lock.notifyAll();
        }
    }

    @Override
    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (state != 2) {
                lock.wait();
            }
            printThird.run();
            state = 0;
            lock.notifyAll();
        }
    }
}
