package com.dadisdad.concurrency.printinorder;

import java.util.concurrent.CountDownLatch;

/**
 * @author 10308
 * @date 2020/4/2
 */
public class FooWithCountDownLatch extends Foo {

    private CountDownLatch c1;
    private CountDownLatch c2;

    public FooWithCountDownLatch() {
        c1 = new CountDownLatch(1);
        c2 = new CountDownLatch(1);
    }


    @Override
    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        c1.countDown();
    }

    @Override
    public void second(Runnable printSecond) throws InterruptedException {
        c1.await();
        printSecond.run();
        c2.countDown();
    }

    @Override
    public void third(Runnable printThird) throws InterruptedException {
        c2.await();
        printThird.run();
    }
}
