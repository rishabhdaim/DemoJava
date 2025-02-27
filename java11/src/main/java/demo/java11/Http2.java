package demo.java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Http2 {

    private static final List<URI> URLS = Stream.of(
            "https://en.wikipedia.org/wiki/List_of_compositions_by_Franz_Schubert",
            "https://en.wikipedia.org/wiki/2018_in_American_television",
            "https://en.wikipedia.org/wiki/List_of_compositions_by_Johann_Sebastian_Bach",
            "https://en.wikipedia.org/wiki/List_of_Australian_treaties",
            "https://en.wikipedia.org/wiki/2016%E2%80%9317_Coupe_de_France_Preliminary_Rounds",
            "https://en.wikipedia.org/wiki/Timeline_of_the_war_in_Donbass_(April%E2%80%93June_2018)",
            "https://en.wikipedia.org/wiki/List_of_giant_squid_specimens_and_sightings",
            "https://en.wikipedia.org/wiki/List_of_members_of_the_Lok_Sabha_(1952%E2%80%93present)",
            "https://en.wikipedia.org/wiki/1919_New_Year_Honours",
            "https://en.wikipedia.org/wiki/List_of_International_Organization_for_Standardization_standards"
    ).map(URI::create).collect(toList());

    private static final String SEARCH_TERM = "Foo";
    private static final HttpClient CLIENT = HttpUtils.createHttpClient();

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpRequest request = HttpUtils.createHttpRequest(URI.create("http://codefx.org"));
        HttpResponse<String> response = CLIENT.send(request, BodyHandlers.ofString(Charset.defaultCharset()));
        System.out.println(response.body());
        asyncSearch();
        reactiveSearch();
        blockingSearch();
    }

    private static void reactiveSearch() {
        URLS.forEach(Http2::reactiveSearch);
    }

    private static void reactiveSearch(URI url) {
        HttpRequest request = HttpUtils.createHttpRequest(url);
        StringFinder finder = new StringFinder();
        CLIENT.sendAsync(request, BodyHandlers.fromLineSubscriber(finder));
        finder.found().exceptionally(__ -> false).thenAccept(found -> System.out.println("Reactive Completed " + url + " / found: " + found));
    }

    private static void blockingSearch() {
        URLS.forEach(url -> { boolean found = blockingSearch(url);
            System.out.println("Blocking Completed " + url + " / found: " + found);
        });
    }

    private static boolean blockingSearch(URI url) {
        try {
            HttpRequest request = HttpUtils.createHttpRequest(url);
            HttpResponse<String> response = CLIENT.send(request, BodyHandlers.ofString());
            return response.body().contains(SEARCH_TERM);
        } catch (IOException | InterruptedException ex) {
            return false;
        }
    }

    private static void asyncSearch() {
        URLS.forEach(Http2::asyncSearch);
//        CompletableFuture.allOf(futures).join();
    }

    private static void asyncSearch(URI url) {
        HttpRequest request = HttpUtils.createHttpRequest(url);
        CLIENT
            .sendAsync(request, BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenApply(body -> body.contains(SEARCH_TERM))
            .exceptionally(__ -> {
                System.err.println("EXCEPTION");
                return false;
            })
            .thenAccept(found -> System.out.println("Async Completed " + url + " / found: " + found));
    }

    private static class StringFinder implements Flow.Subscriber<String> {

        private final CompletableFuture<Boolean> found;
        private Flow.Subscription subscription;

        private StringFinder() {
            this.found = new CompletableFuture<>();
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            requestLine();
        }

        private void requestLine() {
            subscription.request(1);
        }

        @Override
        public void onNext(String line) {
            // no cancelation
//			if (!found.isDone() && line.contains(search.term()))
//				found.complete(Result.completed(search, true));
            // with cancelation
            if (line.contains(SEARCH_TERM)) {
                found.complete(true);
                subscription.cancel();
            }
            requestLine();
        }

        @Override
        public void onError(Throwable ex) {
            found.completeExceptionally(ex);
        }

        @Override
        public void onComplete() {
            found.complete(false);
        }

        public CompletableFuture<Boolean> found() {
            return found;
        }

    }


}
