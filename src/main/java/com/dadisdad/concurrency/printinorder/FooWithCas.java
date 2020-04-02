package com.dadisdad.concurrency.printinorder;

/**
 * @author 10308
 * @date 2020/4/2
 */
public class FooWithCas extends Foo {

    private volatile int flag = 0;

    public FooWithCas() {
    }

    @Override
    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        flag++;
    }

    @Override
    public void second(Runnable printSecond) throws InterruptedException {
        while (flag != 1) {
        }
        printSecond.run();
        flag++;
    }

    @Override
    public void third(Runnable printThird) throws InterruptedException {
        while (flag != 2) {
        }
        printThird.run();
    }
}
