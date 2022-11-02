package shadow.leetcode;

import java.util.concurrent.Semaphore;

public class PrintInOrder {

    private final Semaphore semaphore2;
    private final Semaphore semaphore3;

    public PrintInOrder() {
        semaphore2 = new Semaphore(0);
        semaphore3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
