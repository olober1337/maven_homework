package homework18.first;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicAndSecurityTest {

    private static final AtomicInteger atomicInteger = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(AtomicAndSecurityTest::threadMethod);
        thread1.start();
        Thread thread2 = new Thread(AtomicAndSecurityTest::threadMethod);
        thread2.start();

        Thread.sleep(10000);
        System.out.println("AtomicInteger " + atomicInteger.get());

    }

    private static synchronized void threadMethod() {

        for (int i = 10000; i > 0; i--) {
            Thread thread = new Thread(atomicInteger::decrementAndGet);
            thread.start();
        }
    }
}
