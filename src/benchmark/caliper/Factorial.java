package benchmark.caliper;

public  final class Factorial {

    static long recursive(int n) {
        return switch (checkArgument(n)) {
            case 0 -> 1;
            default -> recursive(n - 1) * n;
        };
    }

    static long iterative(int n) {
        int num = checkArgument(n);
        long result = 1L;
        for (int i = num; i > 0 ; i--) {
            result *= i;
        }
        return result;
    }

    private static int checkArgument(int n) {
        if (n < 0) throw new IllegalArgumentException();
        return n;
    }
}
