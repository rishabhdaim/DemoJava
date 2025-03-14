package demo.java17.benchmark.jmh;

import org.apache.commons.collections4.set.UnmodifiableSet;
import org.jetbrains.annotations.NotNull;
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
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.google.common.collect.ImmutableSet.copyOf;

@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@BenchmarkMode(Mode.AverageTime)
@Fork(2)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class ImmutableSet {

    @Param({"1", "100", "10000", "1000000", "100000000"})
    private int size;

    private Iterable<Integer> itr;

    @NotNull
    public static <T> Set<T> toLinkedSet(@NotNull  final Iterable<? extends T> iterable) {
        Objects.requireNonNull(iterable);
        final Set<T> result = new LinkedHashSet<>();
        iterable.forEach(result::add);
        return result;
    }

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
        com.google.common.collect.ImmutableSet<Integer> immutableSet = copyOf(itr);
        for (Integer i : immutableSet) {
            bh.consume(i);
        }
    }

    @Benchmark
    public void apache(Blackhole bh) {
        Set<Integer> unmodifiableSet = UnmodifiableSet.unmodifiableSet(toLinkedSet(itr));
        for (Integer i : unmodifiableSet){
            bh.consume(i);
        }
    }

    @Benchmark
    public void jdk(Blackhole bh) {
        Set<Integer> unmodifiableSet = Collections.unmodifiableSet(toLinkedSet(itr));
        for (Integer i : unmodifiableSet){
            bh.consume(i);
        }
    }

    public static void main(String[] args) throws RunnerException, IOException {
        Options opt = new OptionsBuilder()
                .include(ImmutableSet.class.getSimpleName() + ".*")
                .build();
        new Runner(opt).run();
    }
}
