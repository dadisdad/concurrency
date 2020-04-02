package com.dadisdad.concurrency.printinorder;

import java.util.concurrent.Semaphore;

/**
 * @author 10308
 * @date 2020/4/2
 */
public class FooWithSemaphore extends Foo {

    private Semaphore s1;
    private Semaphore s2;
    private Semaphore s3;

    public FooWithSemaphore() {
        s1 = new Semaphore(1);
        s2 = new Semaphore(0);
        s3 = new Semaphore(0);
    }


    @Override
    public void first(Runnable printFirst) throws InterruptedException {
        s1.acquire();
        printFirst.run();
        s2.release();
    }

    @Override
    public void second(Runnable printSecond) throws InterruptedException {
        s2.acquire();
        printSecond.run();
        s3.release();
    }

    @Override
    public void third(Runnable printThird) throws InterruptedException {
        s3.acquire();
        printThird.run();
        s1.release();
    }
}
