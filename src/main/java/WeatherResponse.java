import java.util.List;

public record WeatherResponse(
        Fact fact,
        List<Forecast> forecasts
) {
    public record Fact(double temp) {}
    public record Forecast(Parts parts) {}
    public record Parts(Day day) {}
    public record Day(double temp_avg) {}
}
