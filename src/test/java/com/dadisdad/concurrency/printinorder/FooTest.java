package com.dadisdad.concurrency.printinorder;

import org.junit.jupiter.api.Test;

/**
 * @author 10308
 * @date 2020/4/2
 */
public class FooTest {

    @Test
    public void testFooWithLock() {
        Foo foo = new FooWithLock();
        Thread t1 = new Thread(()->{
            try {
                foo.first(()->{
                    foo.one();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                foo.second(()->{
                    foo.two();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(()->{
            try {
                foo.third(()->{
                    foo.three();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    @Test
    public void testFooWithSemaphore() {
        Foo foo = new FooWithSemaphore();
        Thread t1 = new Thread(()->{
            try {
                foo.first(()->{
                    foo.one();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                foo.second(()->{
                    foo.two();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(()->{
            try {
                foo.third(()->{
                    foo.three();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    @Test
    public void testFooWithCountDownLatch() {
        Foo foo = new FooWithCountDownLatch();
        Thread t1 = new Thread(()->{
            try {
                foo.first(()->{
                    foo.one();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                foo.second(()->{
                    foo.two();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(()->{
            try {
                foo.third(()->{
                    foo.three();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    @Test
    public void testFooWithCas() {
        Foo foo = new FooWithCas();
        Thread t1 = new Thread(()->{
            try {
                foo.first(()->{
                    foo.one();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                foo.second(()->{
                    foo.two();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(()->{
            try {
                foo.third(()->{
                    foo.three();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    @Test
    public void testWithSynchronized() {
        Foo foo = new FooWithSynchronized();
        Thread t1 = new Thread(()->{
            try {
                foo.first(()->{
                    foo.one();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                foo.second(()->{
                    foo.two();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(()->{
            try {
                foo.third(()->{
                    foo.three();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
