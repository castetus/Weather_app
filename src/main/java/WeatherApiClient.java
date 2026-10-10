import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherApiClient {
    private static final String BASE_URL = "https://api.weather.yandex.ru/v2/forecast";
    private final String apiKey;
    private final HttpClient client;

    public WeatherApiClient() {
        this.apiKey = System.getenv("YANDEX_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException(
                    "YANDEX_API_KEY is not set"
            );
        }
        this.client = HttpClient.newHttpClient();
    }

    public String fetchData (
            double lat, double lon, int limit
    ) throws IOException, InterruptedException {

        URI uri = URI.create(
                this.BASE_URL
                        + "?lat=" + lat
                        + "&lon=" + lon
                        + "&limit=" + limit
        );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("X-Yandex-Weather-Key", this.apiKey)
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new IOException("status: " + response.statusCode());
        }

        return response.body();
    }
}
