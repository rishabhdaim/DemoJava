package demo.java;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;

import static java.net.http.HttpClient.Redirect.ALWAYS;
import static java.net.http.HttpClient.Version.HTTP_2;

public class HttpUtils {
    private HttpUtils() { }

    public static HttpClient createHttpClient() {
        return HttpClient.newBuilder().version(HTTP_2).connectTimeout(Duration.ofSeconds(10)).
                followRedirects(ALWAYS).build(); // HttpClient.newHttpClient()
    }

    public static HttpRequest createHttpRequest(final URI url) {
        return HttpRequest.newBuilder(url)
                .GET() // default one though
                .header("Accept-Language", "en-US,en;q=0.5")
                .build();
    }
}
