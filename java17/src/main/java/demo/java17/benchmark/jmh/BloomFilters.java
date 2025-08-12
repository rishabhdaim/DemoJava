package demo.java17.benchmark.jmh;

import com.google.common.hash.Funnels;
import org.apache.commons.codec.digest.MurmurHash3;
import org.apache.commons.collections4.bloomfilter.BloomFilter;
import org.apache.commons.collections4.bloomfilter.EnhancedDoubleHasher;
import org.apache.commons.collections4.bloomfilter.Hasher;
import org.apache.commons.collections4.bloomfilter.Shape;
import org.apache.commons.collections4.bloomfilter.SimpleBloomFilter;
import org.jetbrains.annotations.NotNull;
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

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@BenchmarkMode(Mode.AverageTime)
@Fork(2)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class BloomFilters {

    @Param({"1", "100", "10000", "1000000"})
    private int count;

    @Benchmark
    public void guava(Blackhole bh) {
        com.google.common.hash.BloomFilter<String> bloomFilter = com.google.common.hash.BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8), 9000000);
        for (int i = 0; i < count; i++) {
            bh.consume(bloomFilter.put("value-" + i));
        }
    }

    @Benchmark
    public void apache(Blackhole bh) {
        BloomFilter<SimpleBloomFilter> bloomFilter = new SimpleBloomFilter(Shape.fromNP(9000000, 0.03));
        for (int i = 0; i < count; i++) {
            bh.consume(bloomFilter.merge(hasher("value-" + i)));
        }
    }

    @Benchmark
    public void apacheSha(Blackhole bh) throws NoSuchAlgorithmException {
        BloomFilter<SimpleBloomFilter> bloomFilter = new SimpleBloomFilter(Shape.fromNP(9000000, 0.03));
        for (int i = 0; i < count; i++) {
            bh.consume(bloomFilter.merge(hasherSha("value-" + i)));
        }
    }

    private static @NotNull Hasher hasher(final @NotNull String value) {
        final long[] hashed128 = MurmurHash3.hash128(value.getBytes(StandardCharsets.UTF_8));
        return new EnhancedDoubleHasher(hashed128[0], hashed128[1]);
    }

    private static @NotNull Hasher hasherSha(final @NotNull String value) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(value.getBytes(StandardCharsets.UTF_8));
        return new EnhancedDoubleHasher(digest);
    }



    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(demo.java17.benchmark.jmh.BloomFilters.class.getSimpleName() + ".*")
                .build();
        new Runner(opt).run();
    }
}
