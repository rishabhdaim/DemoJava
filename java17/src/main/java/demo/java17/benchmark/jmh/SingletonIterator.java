package demo.java17.benchmark.jmh;

import com.google.common.collect.Iterators;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@BenchmarkMode(Mode.AverageTime)
@Fork(2)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class SingletonIterator {

    @Param({"1", "100", "10000", "1000000", "100000000"})
    private int count;

    @Benchmark
    public void guava(Blackhole bh) {
        for (int i = 0; i < count; i++) {
            Iterator<String> iterator = Iterators.singletonIterator("asd");
            bh.consume(iterator.next());
        }
    }

    @Benchmark
    public void apache(Blackhole bh) {
        for (int i = 0; i < count; i++) {
            Iterator<String> iterator = UnmodifiableIterator.unmodifiableIterator(new org.apache.commons.collections4.iterators.SingletonIterator<>("asd", false));
            bh.consume(iterator.next());
        }
    }

    @Benchmark
    public void jdk(Blackhole bh) {
        for (int i = 0; i < count; i++) {
            Iterator<String> iterator = Collections.singleton("asd").iterator();
            bh.consume(iterator.next());
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(demo.java17.benchmark.jmh.SingletonIterator.class.getSimpleName() + ".*")
                .build();
        new Runner(opt).run();
    }
}
