package demo.java17.benchmark.jmh;

import com.google.common.collect.Iterables;
import org.jetbrains.annotations.NotNull;
import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.stream.StreamSupport;

@State(Scope.Benchmark)
@Warmup(iterations = 2, time = 1)
@Measurement(iterations = 2, time = 1)
@BenchmarkMode(Mode.AverageTime)
@Fork(2)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class IterableUtils {

    @Param({"1", "100", "10000", "1000000"})
    private int size;

    private Iterable<Integer> itr;

    @Setup
    public void setup() {
        itr = new Iterable<>() {
            @Override
            public @NotNull Iterator<Integer> iterator() {
                return new Iterator<>() {
                    int count;

                    @Override
                    public boolean hasNext() {
                        return count < size;
                    }

                    @Override
                    public Integer next() {
                        count++;
                        return count;
                    }
                };
            }
        };
    }

    @Benchmark
    public void guava(Blackhole bh) {
       bh.consume(Iterables.getFirst(itr, bh));
    }

    @Benchmark
    public void apache(Blackhole bh) {
        bh.consume(org.apache.commons.collections4.IterableUtils.first(itr));
    }

    @Benchmark
    public void stream(Blackhole bh) {
        bh.consume(StreamSupport.stream(itr.spliterator(), false).findFirst().orElse(0));
    }

    public static void main(String[] args) throws RunnerException, IOException {
        Main.main(args);
    }

}
