import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.util.Map;

public class ReadJsonPrintKeysValues {
    public static void main(String[] args) {
        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader("data.json"));
            JsonObject jsonObject = fileElement.getAsJsonObject();

            printJson(jsonObject, "");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void printJson(JsonObject jsonObject, String prefix) {
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = prefix.isEmpty() ? entry.getKey() : prefix + "." + entry.getKey();
            JsonElement value = entry.getValue();

            if (value.isJsonObject()) {
                printJson(value.getAsJsonObject(), key); 
            } else {
                System.out.println(key + " : " + value);
            }
        }
    }
}
