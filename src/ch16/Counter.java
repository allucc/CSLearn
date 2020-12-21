package ch16;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lucy
 */
public class Counter {
    private final Lock lock = new ReentrantLock();
    private volatile int count;

    public void incr() {
        lock.lock();
        try {
            ++count;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}
