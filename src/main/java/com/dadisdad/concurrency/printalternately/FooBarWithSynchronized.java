package com.dadisdad.concurrency.printalternately;

/**
 * @author 10308
 * @date 2020/4/8
 */
public class FooBarWithSynchronized extends FooBar {

    private Object lock;
    private volatile boolean flag;
    public FooBarWithSynchronized(int n) {
        super(n);
        this.lock = new Object();
        this.flag = false;
    }

    @Override
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized (lock) {
                if (flag){
                    lock.wait();
                }
                printFoo.run();
                flag = true;
                lock.notifyAll();
            }
        }
    }

    @Override
    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized (lock){
                if (!flag) {
                    lock.wait();
                }
                printBar.run();
                flag = false;
                lock.notifyAll();
            }
        }
    }
}
