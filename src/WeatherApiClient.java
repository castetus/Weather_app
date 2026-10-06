import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherApiClient {

    private double lat;
    private double lon;
    private int limit;

    WeatherApiClient(double lat, double lon, int limit) {
        this.lat = lat;
        this.lon = lon;
        this.limit = limit;
    }

    private final String BASE_URL = "https://api.weather.yandex.ru/v2/forecast";
    private String apiKey = System.getenv("YANDEX_API_KEY");
    private URI uri = URI.create(
            BASE_URL
                    + "?lat=" + lat
                    + "&lon=" + lon
                    + "&limit=" + limit
    );

    private HttpClient client = HttpClient.newHttpClient();

    private HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(String.valueOf(uri)))
            .header("X-Yandex-Weather-Key", apiKey)
            .GET()
            .build();
}
