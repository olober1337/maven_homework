package homework18.first;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicAndSecurityTest {

    private static final AtomicInteger atomicInteger = new AtomicInteger(10);


    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(AtomicAndSecurityTest::threadMethod);
        Thread thread2 = new Thread(AtomicAndSecurityTest::threadMethod);
        thread1.setName("Thread 1 is running ");
        thread2.setName("Thread 2 is running ");
        thread1.start();
        thread2.start();

        Thread.sleep(2000);
        System.out.println("AtomicInteger" + atomicInteger.get());

    }

    private static synchronized void threadMethod() {

        for (int i = 10000; i > 0; i--) {
            System.out.println(Thread.currentThread().getName() + i);
        }
        atomicInteger.decrementAndGet();
    }
}
