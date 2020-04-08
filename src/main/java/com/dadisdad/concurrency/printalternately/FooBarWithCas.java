package com.dadisdad.concurrency.printalternately;

/**
 * @author 10308
 * @date 2020/4/8
 */
public class FooBarWithCas extends FooBar {

    private volatile boolean flag;

    public FooBarWithCas(int n) {
        super(n);
        this.flag = false;
    }

    @Override
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            while (flag) {
                Thread.yield();
            }
            printFoo.run();
            flag = true;
        }
    }

    @Override
    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            while (!flag) {
                Thread.yield();
            }
            printBar.run();
            flag = false;
        }
    }
}
