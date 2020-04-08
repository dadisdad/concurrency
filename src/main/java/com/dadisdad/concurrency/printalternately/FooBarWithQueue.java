package com.dadisdad.concurrency.printalternately;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author 10308
 * @date 2020/4/8
 */
public class FooBarWithQueue extends FooBar {

    private BlockingDeque<Integer> fooQueue;
    private BlockingDeque<Integer> barQueue;

    public FooBarWithQueue(int n) {
        super(n);
        this.fooQueue = new LinkedBlockingDeque<>();
        this.barQueue = new LinkedBlockingDeque<>();
        try {
            fooQueue.put(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            fooQueue.take();
            printFoo.run();
            barQueue.put(1);
        }
    }

    @Override
    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            barQueue.take();
            printBar.run();
            fooQueue.put(1);
        }
    }
}
