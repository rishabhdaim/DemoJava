package demo.java21;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

import static demo.java21.ThreadCount.readPoolName;
import static demo.java21.ThreadCount.readWorkerName;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class VirtualThreadSynchronization {
    static int counter = 0;
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();
        Set<String> poolNames = ConcurrentHashMap.newKeySet();
        Set<String> pThreadNames = ConcurrentHashMap.newKeySet();

        ChronoUnit delay = ChronoUnit.MICROS;

        var threads = IntStream.range(0, 100).mapToObj(i -> Thread.ofVirtual().unstarted(() -> {
            try {
                if (i == 0) System.out.println(currentThread());
                poolNames.add(readPoolName());
                synchronized (lock) {
                    sleep(Duration.of(1, delay));
                    counter++;
                }
                if (i == 0) System.out.println(currentThread());
                poolNames.add(readPoolName());
                synchronized (lock) {
                    sleep(Duration.of(1, delay));
                    counter++;
                }
                if (i == 0) System.out.println(currentThread());
                poolNames.add(readPoolName());
                synchronized (lock) {
                    sleep(Duration.of(1, delay));
                    counter++;
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
