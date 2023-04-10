package demo.java.benchmark.jmh;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.RunnerException;

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
        Main.main(args);
    }
}
