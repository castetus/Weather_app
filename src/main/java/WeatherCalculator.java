import java.util.List;

public class WeatherCalculator {

    public double calculateAverageTemp(List<WeatherResponse.Forecast> forecasts) {
        if (forecasts.isEmpty()) {
            throw new IllegalArgumentException("Forecast list is empty");
        }

        double sum = forecasts.stream()
                .map(f -> f.parts().day().temp_avg())
                .reduce(0.0, Double::sum);

        return sum / forecasts.size();
    }
}