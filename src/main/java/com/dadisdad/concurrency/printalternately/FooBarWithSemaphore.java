package com.dadisdad.concurrency.printalternately;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author 10308
 * @date 2020/4/8
 */
public class FooBarWithSemaphore extends FooBar {

    private Semaphore fooSemaphore;
    private Semaphore barSemaphore;

    public FooBarWithSemaphore(int n) {
        super(n);
        this.fooSemaphore = new Semaphore(1);
        this.barSemaphore = new Semaphore(0);
    }

    @Override
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            fooSemaphore.acquire();
            printFoo.run();
            barSemaphore.release();
        }
    }

    @Override
    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            barSemaphore.acquire();
            printBar.run();
            fooSemaphore.release();
        }
    }
}
