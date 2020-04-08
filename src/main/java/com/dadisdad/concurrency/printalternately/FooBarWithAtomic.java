package com.dadisdad.concurrency.printalternately;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author 10308
 * @date 2020/4/8
 */
public class FooBarWithAtomic extends FooBar {

    private AtomicBoolean flag;

    public FooBarWithAtomic(int n) {
        super(n);
        this.flag = new AtomicBoolean(false);
    }

    @Override
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            while (flag.get()) {
                Thread.yield();
            }
            printFoo.run();
            flag.set(true);
        }
    }

    @Override
    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            while (!flag.get()) {
                Thread.yield();
            }
            printBar.run();
            flag.set(false);
        }
    }

}
