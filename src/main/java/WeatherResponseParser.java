import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherResponseParser {
    private final ObjectMapper mapper = new ObjectMapper();

    public JsonNode parse(String json) throws JsonProcessingException {
        return mapper.readTree(json);
    }
}
