import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class WeatherResponseParser {
    private final ObjectMapper mapper = new ObjectMapper()
            .configure(
                    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                    false
            );

    public WeatherResponse parse(String json) throws JsonProcessingException {
        return mapper.readValue(json, WeatherResponse.class);
    }

    public String prettyPrint(String json) throws JsonProcessingException {
        JsonNode root = mapper.readTree(json);

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
    }
}
