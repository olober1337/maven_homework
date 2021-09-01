package homework18.second;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    Lock lock = new ReentrantLock();

    public void agility() {
        lock.lock();
        for (int i = 1; i < 5; i++) {
            System.out.println("Add agility" + i);
        }
    }

    public void strength() {
        lock.lock();
        for (int i = 1; i < 5; i++) {
            System.out.println("Add strength" + i);
        }
    }

    public void stamina() {
        for (int i = 1; i < 5; i++) {
            System.out.println("Add stamina" + i);
        }
        lock.unlock();
    }
}
