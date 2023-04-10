package demo.java.java8;

import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CheckThanAct {


    private static final int VIEWS = 10_000_000;
    private static final String MOVIE = "Sooryavansham";
    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        final Map<String, BigDecimal> movieViews = Maps.newConcurrentMap();
        movieViews.put(MOVIE, BigDecimal.ZERO);

//        seqAdd(movieViews);
        conAdd(movieViews);

        executorService.shutdown();

        try {
            while (!executorService.awaitTermination(1, TimeUnit.SECONDS));
            System.out.println(movieViews);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void seqAdd(Map<String, BigDecimal> movieViews) {
        for (int i = 0; i < VIEWS; i++) {
            addMovieViews(movieViews);
        }
    }

    private static void conAdd(Map<String, BigDecimal> movieViews) {
        for (int i = 0; i < VIEWS; i++) {
            executorService.submit(() -> addMovieViews(movieViews));
        }
    }

    private static void addMovieViews(Map<String, BigDecimal> movieViews) {
        movieViews.computeIfPresent(MOVIE, (movie, views) -> views.add(BigDecimal.ONE));
    }
}
