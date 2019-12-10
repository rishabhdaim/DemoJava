package benchmark.caliper;


import com.google.caliper.Benchmark;
import com.google.caliper.Param;

public final class FactorialBenchmark {

    @Param({"5", "10", "20"})
    int number; // -Dnumber=5,10,20


    @Benchmark
    long recursive(int reps) {
        int number = this.number;
        long dummy = 0L;
        for (int i = 0; i < reps; i++) {
            dummy |= Factorial.recursive(number);
        }
        return dummy;
    }

    @Benchmark
    long iterative(int reps) {
        int number = this.number;
        long dummy = 0L;
        for (int i = 0; i < reps; i++) {
            dummy |= Factorial.iterative(number);
        }
        return dummy;
    }
}
