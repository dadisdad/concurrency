package com.dadisdad.concurrency.printalternately;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author 10308
 * @date 2020/4/8
 */
public class FooBarWithCountDownLatch extends FooBar {

    private CountDownLatch fooLatch;
    private CountDownLatch barLatch;

    public FooBarWithCountDownLatch(int n) {
        super(n);
        this.fooLatch = new CountDownLatch(0);
        this.barLatch = new CountDownLatch(1);
    }

    @Override
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            fooLatch.await();
            printFoo.run();
            fooLatch = new CountDownLatch(1);
            barLatch.countDown();
        }
    }

    @Override
    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            barLatch.await();
            printBar.run();
            barLatch = new CountDownLatch(1);
            fooLatch.countDown();
        }
    }
}
