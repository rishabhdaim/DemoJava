package benchmark.jvm;

// -XX:+PrintCompilation -- to print jit info
// -XX:+UnlockDiagnosticVMOptions -XX:+LogCompilation  -- to print full jit info
// -XX:NativeMemoryTracking=[Summary|detail]  && jcmd <PID> VM.native_memory [detail|Summary]
// -XX:+AlwaysPreTouch
// -XX:-AdaptiveSizePolicy
public class SimpleProgram {
    static int blackhole;

    public static void main(String[] args) {
        int[] nums = randomInts(5_000);

        for (int i = 0; i < 100; i++) {
            long startTime = System.nanoTime();
            blackhole = sum(nums);
            long endTime = System.nanoTime();
            System.out.printf("%d\t%d%n", i, endTime - startTime);
        }
    }

    private static int[] randomInts(int i) {
        int[] a = new int[i];
        for (int j = 0; j < i; j++) {
           a[j] = (int) (Math.random() * i);
        }
        return a;
    }

    private static int sum(int[] a) {
        int sum = 0;
        for (int value : a) {
            sum += value;
        }
        return sum;
    }
}
