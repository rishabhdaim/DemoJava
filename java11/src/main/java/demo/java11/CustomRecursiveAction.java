package demo.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

public class CustomRecursiveAction extends RecursiveAction {

    private String workload = "";
    private static final int THRESHOLD = 1000;

    private static Logger logger = Logger.getAnonymousLogger();

    private CustomRecursiveAction(String workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload.length() > THRESHOLD) {
            ForkJoinTask.invokeAll(createSubTasks());
        } else {
            processing(workload);
        }
//        processing(workload);
    }

    private List<CustomRecursiveAction> createSubTasks() {
        List<CustomRecursiveAction> subTasks = new ArrayList<>();

        String partOne = workload.substring(0, workload.length() / 2);
        String partTwo = workload.substring(workload.length() / 2);

        subTasks.add(new CustomRecursiveAction(partOne));
        subTasks.add(new CustomRecursiveAction(partTwo));

        return subTasks;
    }

    private void processing(String work) {
        String result = work.toUpperCase();
        logger.info("This result - (" + result + ") - was processed by " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws IOException {
        var start = Instant.now();
        var str = Files.readString(Path.of("large.json"));
        new CustomRecursiveAction(str).compute();
        var end = Duration.between(start, Instant.now()).toMillis();
        System.out.println(end);
    }

}
