import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double lat;
        double lon;
        int limit;
        Scanner scanner = new Scanner(System.in);

        ConsoleReader consoleReader = new ConsoleReader(scanner);

        lat = consoleReader.readCoordinate("широту", -90, 90);
        lon = consoleReader.readCoordinate("долготу", -180, 180);
        limit = consoleReader.readLimit();

        WeatherApiClient apiClient = new WeatherApiClient();
        WeatherResponseParser parser = new WeatherResponseParser();
        WeatherCalculator weatherCalc = new WeatherCalculator();

        try {
            String data = apiClient.fetchData(lat, lon, limit);
            String formattedJson = parser.prettyPrint(data);
            WeatherResponse parsedResponse = parser.parse(data);

            double factTemp = parsedResponse.fact().temp();

            double avgTemp = weatherCalc.calculateAverageTemp(parsedResponse.forecasts());

            System.out.printf("Текущая температура: %.1f °C%n", factTemp);
            System.out.printf(
                    "Средняя дневная температура за %d дней: %.1f °C%n",
                    parsedResponse.forecasts().size(),
                    avgTemp
            );
            System.out.println("\nПолный ответ API:");
            System.out.println(data);
            System.out.println("\nФорматированный ответ API:");
            System.out.println(formattedJson);
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}