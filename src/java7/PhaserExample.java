package java7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.ThreadPoolExecutor;

import static com.google.common.util.concurrent.MoreExecutors.getExitingExecutorService;

public class PhaserExample {

    private static final ExecutorService executorService = getExitingExecutorService((ThreadPoolExecutor) Executors.newFixedThreadPool(5));
    private static Phaser phaser = new Phaser(3);

    public static void main(String[] args) {
        executorService.submit(phaser::arrive);
        executorService.submit(phaser::arrive);
        executorService.submit(phaser::arrive);

        phaser.awaitAdvance(1);

        System.out.println("All services initialized");

        phaser = new Phaser(3);
        executorService.submit(phaser::arriveAndAwaitAdvance);
        executorService.submit(phaser::arriveAndAwaitAdvance);
        executorService.submit(phaser::arriveAndAwaitAdvance);

        System.out.println("Message sent");
    }
}
