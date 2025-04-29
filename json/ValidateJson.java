import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ValidateJson {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Load and parse the JSON file
            JsonNode jsonNode = mapper.readTree(new File("data.json"));
            System.out.println("Valid JSON!");
        } catch (IOException e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}
