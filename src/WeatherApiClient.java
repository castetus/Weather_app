import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherApiClient {
    private final String BASE_URL = "https://api.weather.yandex.ru/v2/forecast";
    private String apiKey = System.getenv("YANDEX_API_KEY");

    public String fetchData (
            double lat, double lon, int limit
    ) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(
                this.BASE_URL
                        + "?lat=" + lat
                        + "&lon=" + lon
                        + "&limit=" + limit
        );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(uri)))
                .header("X-Yandex-Weather-Key", this.apiKey)
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );
    }
}
