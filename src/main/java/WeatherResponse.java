import java.util.List;

public record WeatherResponse(
        Fact fact,
        List<Forecast> forecasts
) {
    public record Fact(int temp) {}
    public record Forecast(Parts parts) {}
    public record Parts(Day day) {}
    public record Day(int temp_avg) {}
}
