package demo.java;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadExecutor {
    public static void main(String[] args) {

        long startTime = System.nanoTime();

        try(var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 100_000).forEach( i -> executor.submit(() -> {
                Thread.sleep(Duration.ofSeconds(1));
                return i;
            }));
        }

        System.out.println(Duration.ofNanos(System.nanoTime() - startTime).toMillis());
    }
}
