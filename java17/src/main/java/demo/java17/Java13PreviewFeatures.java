package demo.java17;

import java.util.LongSummaryStatistics;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 * This class uses Java 13's preview features
 */
public class Java13PreviewFeatures {
    public static void main(String[] args) {
        switchCaseLambda();
        switchCaseYield();
        multiTestBlock();
        teeingCollector();
        exceptionalHandling();
    }

    private static void exceptionalHandling() {
        CompletableFuture.supplyAsync(() -> 0 / (1 -1)).exceptionally(ex -> 0).thenAccept(System.out::println);
    }

    private static void teeingCollector() {
        var count = gimmeStream().count();
        var sum = gimmeStream().mapToLong(l -> l).sum();
        System.out.printf("Sum is %s and count is %s%n", sum, count);

        // reducing
        CountAndSum countAndSum = gimmeStream().reduce(new CountAndSum(0L, 0L), (cas, e) -> new CountAndSum(cas.count() + 1, cas.sum() + e ),
                (cas1, cas2) -> new CountAndSum(cas1.count() + cas2.count(), cas1.sum() + cas2.sum()));
        System.out.println(countAndSum);

        // teeing
        countAndSum = gimmeStream().collect(Collectors.teeing(Collectors.counting(), Collectors.summingLong(l -> l), CountAndSum::new));
        System.out.println(countAndSum);

        // summaring long
        LongSummaryStatistics stats = gimmeStream().collect(Collectors.summarizingLong(e -> e));
        System.out.println(stats);

        long[] by2AndBy3 = gimmeStream().collect(Collectors.teeing(Collectors.filtering(l -> l % 2 == 0, Collectors.counting()),
                Collectors.filtering(l -> l % 2 == 0, Collectors.counting()), (by2, by3) -> new long[] {by2, by3}));

        System.out.println(format("%d Numbers divisble by 2 and %d numbers by 3", by2AndBy3[0], by2AndBy3[1]));
    }

    private static Stream<Long> gimmeStream() {
        return Stream.iterate(0L, i -> i < 20, i -> i + 1);
    }



    private static void multiTestBlock() {
        var v = """
        {
          "type": "photo",
          "flickr_type": "photo",
          "title": "ZB8T0193",
          "author_name": "‮‭‬bees‬",
          "author_url": "https://www.flickr.com/photos/bees/",
          "width": 1024,
          "height": 683,
          "url": "https://live.staticflickr.com/3123/2341623661_7c99f48bbf_b.jpg",
          "web_page": "https://www.flickr.com/photos/bees/2341623661/",
          "thumbnail_url": "https://live.staticflickr.com/3123/2341623661_7c99f48bbf_q.jpg",
          "thumbnail_width": 150,
          "thumbnail_height": 150,
          "web_page_short_url": "https://flic.kr/p/4yVr8K",
          "license": "All Rights Reserved",
          "license_id": 0,
          "html": "<a data-flickr-embed=\"true\" href=\"https://www.flickr.com/photos/bees/2341623661/\" title=\"ZB8T0193 by ‮‭‬bees‬, on Flickr\"><img src=\"https://live.staticflickr.com/3123/2341623661_7c99f48bbf_b.jpg\" width=\"1024\" height=\"683\" alt=\"ZB8T0193\"></a><script async src=\"https://embedr.flickr.com/assets/client-code.js\" charset=\"utf-8\"></script>",
          "version": "1.0",
          "cache_age": 3600,
          "provider_name": "Flickr",
          "provider_url": "https://www.flickr.com/"
        }
        """;
        System.out.println(v);
    }

    private static void switchCaseLambda() {
        var day = DayOfWeek.getRandomDay();
        int value = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY ->  {
                System.out.println("Its Tuesday");
                yield 7;
            }
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
        };

        System.out.println(day + " " + value);
    }

    private static void switchCaseYield() {
        var day = DayOfWeek.getRandomDay();
        int value = switch (day) {
            case MONDAY, FRIDAY, SUNDAY: yield 6;
            case TUESDAY: yield 7;
            case THURSDAY, SATURDAY: yield 8;
            case WEDNESDAY: yield 9;
        };

        System.out.println(day + " " + value);
    }

    private record CountAndSum(long count, long sum) {
    }
}
