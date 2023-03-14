package java19;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;
import static java19.ThreadCount.readPoolName;
import static java19.ThreadCount.readWorkerName;

public class VirtualThreadReentrantLock {
    static int counter = 0;
    static final ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {

        Set<String> poolNames = ConcurrentHashMap.newKeySet();
        Set<String> pThreadNames = ConcurrentHashMap.newKeySet();

        ChronoUnit delay = ChronoUnit.MICROS;

        var threads = IntStream.range(0, 100).mapToObj(i -> Thread.ofVirtual().unstarted(() -> {
            try {
                if (i == 0) System.out.println(currentThread());
                poolNames.add(readPoolName());
                lock.lock();
                try {
                    sleep(Duration.of(1, delay));
                    counter++;
                } finally {
                    lock.unlock();
                }
                if (i == 0) System.out.println(currentThread());
                poolNames.add(readPoolName());
                lock.lock();
                try {
                    sleep(Duration.of(1, delay));
                    counter++;
                } finally {
                    lock.unlock();
                }
                if (i == 0) System.out.println(currentThread());
                poolNames.add(readPoolName());
                lock.lock();
                try {
                    sleep(Duration.of(1, delay));
                    counter++;
                } finally {
                    lock.unlock();
                }
                if (i == 0) System.out.println(currentThread());
                poolNames.add(readPoolName());

            } catch (Exception ignored) {

            }
            pThreadNames.add(readWorkerName());
        })).toList();

        threads.forEach(Thread::start);
        for (var thread : threads) thread.join();

        synchronized (lock) {
            System.out.println("# counters : " + counter);
            System.out.println("# Platform Threads: " + pThreadNames.size());
        }

    }
}
