package demo.java17.benchmark.jmh;

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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Warmup(iterations = 2, time = 1)
@Measurement(iterations = 2, time = 1)
@BenchmarkMode(Mode.AverageTime)
@Fork(2)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class StringIntern {
    @Param({"1", "100", "10000", "1000000"})
    private int size;

    private StringInterner str;
    private CHMInterner chm;
    private HMInterner hm;

    @Setup
    public void setup() {
        str = new StringInterner();
        chm = new CHMInterner();
        hm = new HMInterner();
    }

    public static class StringInterner {
        public String intern(String s) {
            return s.intern();
        }
    }

    @Benchmark
    public void intern(Blackhole bh) {
        for (int c = 0; c < size; c++) {
            bh.consume(str.intern("String" + c));
        }
    }

    public static class CHMInterner {
        private final Map<String, String> map;

        public CHMInterner() {
            map = new ConcurrentHashMap<>();
        }

        public String intern(String s) {
            String exist = map.putIfAbsent(s, s);
            return (exist == null) ? s : exist;
        }
    }

    @Benchmark
    public void chm(Blackhole bh) {
        for (int c = 0; c < size; c++) {
            bh.consume(chm.intern("String" + c));
        }
    }

    public static class HMInterner {
        private final Map<String, String> map;

        public HMInterner() {
            map = new HashMap<>();
        }

        public String intern(String s) {
            String exist = map.putIfAbsent(s, s);
            return (exist == null) ? s : exist;
        }
    }

    @Benchmark
    public void hm(Blackhole bh) {
        for (int c = 0; c < size; c++) {
            bh.consume(hm.intern("String" + c));
        }
    }

    public static void main(String[] args) throws IOException, RunnerException {
        Options opt = new OptionsBuilder()
                .include(StringIntern.class.getSimpleName() + ".*")
                .build();
        new Runner(opt).run();
    }
}
