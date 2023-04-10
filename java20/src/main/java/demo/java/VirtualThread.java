package demo.java;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.ofPlatform;
import static java.lang.Thread.ofVirtual;
import static java.lang.Thread.sleep;

public class VirtualThread {
    public static void main(String[] args) throws InterruptedException {
        var pThread = ofPlatform().unstarted(() -> System.out.println(currentThread()));
        pThread.start();
        pThread.join();

        var vThread = ofVirtual().unstarted(() -> System.out.println(currentThread()));
        vThread.start();
        vThread.join();

        System.out.println(vThread.getClass());

        var task = ForkJoinPool.commonPool().submit(() -> System.out.println(currentThread()));
        task.join();

        var threads = IntStream.range(0, 100).mapToObj(i -> Thread.ofVirtual().unstarted(() -> {
            if (i == 0) System.out.println( currentThread());
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i == 0) System.out.println( currentThread());
        })).toList();

        threads.forEach(Thread::start);
        for (Thread t : threads) {
            t.join();
        }
    }
}
