package com.dadisdad.concurrency.printalternately;

import com.dadisdad.concurrency.printinorder.Foo;
import com.dadisdad.concurrency.printinorder.FooWithLock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FooBarTest {

    @Test
    public void testFooBarWithCas() {
        FooBar fooBar = new FooBarWithCas(6);
        Thread t1 = new Thread(()->{
            try {
                fooBar.foo(()->{
                    fooBar.printFoo();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                fooBar.bar(()->{
                    fooBar.printBar();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

    @Test
    public void testFooBarWithAtomic() {
        FooBar fooBar = new FooBarWithAtomic(6);
        Thread t1 = new Thread(()->{
            try {
                fooBar.foo(()->{
                    fooBar.printFoo();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                fooBar.bar(()->{
                    fooBar.printBar();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

    @Test
    public void testFooBarWithCountDownLatch() {
        FooBar fooBar = new FooBarWithCountDownLatch(6);
        Thread t1 = new Thread(()->{
            try {
                fooBar.foo(()->{
                    fooBar.printFoo();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                fooBar.bar(()->{
                    fooBar.printBar();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

    @Test
    public void testFooBarWithSemaphore() {
        FooBar fooBar = new FooBarWithSemaphore(6);
        Thread t1 = new Thread(()->{
            try {
                fooBar.foo(()->{
                    fooBar.printFoo();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                fooBar.bar(()->{
                    fooBar.printBar();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

    @Test
    public void testFooBarWithLock() {
        FooBar fooBar = new FooBarWithLock(6);
        Thread t1 = new Thread(()->{
            try {
                fooBar.foo(()->{
                    fooBar.printFoo();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                fooBar.bar(()->{
                    fooBar.printBar();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

    @Test
    public void testFooBarWithSynchronized() {
        FooBar fooBar = new FooBarWithSynchronized(6);
        Thread t1 = new Thread(()->{
            try {
                fooBar.foo(()->{
                    fooBar.printFoo();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                fooBar.bar(()->{
                    fooBar.printBar();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

    @Test
    public void testFooBarWithQueue() {
        FooBar fooBar = new FooBarWithQueue(6);
        Thread t1 = new Thread(()->{
            try {
                fooBar.foo(()->{
                    fooBar.printFoo();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                fooBar.bar(()->{
                    fooBar.printBar();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

}