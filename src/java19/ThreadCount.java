package java19;

import java.time.Instant;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static java.lang.Runtime.getRuntime;
import static java.lang.Thread.currentThread;
import static java.time.Duration.between;

public class ThreadCount {
    public static void main(String[] args) throws InterruptedException {
        Set<String> poolNames = ConcurrentHashMap.newKeySet();
        Set<String> pThreadNames = ConcurrentHashMap.newKeySet();

        var threads = IntStream.range(0, 10_000_000).mapToObj(i -> Thread.ofVirtual().unstarted(() -> {
            String poolName = readPoolName();
            poolNames.add(poolName);
            String workerName = readWorkerName();
            pThreadNames.add(workerName);
        })).toList();

        Instant begin = Instant.now();
        threads.forEach(Thread::start);
        for (var thread : threads) thread.join();

        Instant end = Instant.now();
        System.out.println("Time = " + between(begin, end).toMillis() + " ms");
        System.out.println("# Cores = " + getRuntime().availableProcessors());
        System.out.println("# Pools: " + poolNames.size());
        System.out.println("# Platform Threads: " + pThreadNames.size());
    }

    public static String readPoolName() {
        String name = currentThread().toString();
        Matcher poolMatcher = Pattern.compile("ForkJoinPool-[0-9]*").matcher(name);
        if (poolMatcher.find()) return poolMatcher.group();
        return "Pool not Found";
    }

    public static String readWorkerName() {
        String name = currentThread().toString();
        Matcher workerMatcher = Pattern.compile("worker-[0-9]*").matcher(name);
        if (workerMatcher.find()) return workerMatcher.group();
        return "Not Found";
    }
}
