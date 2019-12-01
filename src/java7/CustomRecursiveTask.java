package java7;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Integer> {
    private int[] arr;

    private static final int THRESHOLD = 20;

    private CustomRecursiveTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
        if (arr.length > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubTasks())
                    .stream()
                    .mapToInt(ForkJoinTask::join)
                    .sum();
        } else {
            return processing(arr);
        }
    }

    private Collection<CustomRecursiveTask> createSubTasks() {
        return List.of(new CustomRecursiveTask(Arrays.copyOfRange(arr, 0, arr.length / 2)),
                new CustomRecursiveTask(Arrays.copyOfRange(arr, arr.length / 2, arr.length)));
    }

    private Integer processing(int[] arr) {
        return Arrays.stream(arr).filter(a -> a > 10 && a < 27).map(a -> a * 10).sum();
    }

    public static void main(String[] args) {
        final int[] a = new int[1000];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (30 * Math.random());
        }
        System.out.println(new CustomRecursiveTask(a).compute());
    }
}
