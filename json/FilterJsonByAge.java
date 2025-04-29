import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

public class FilterJsonByAge {
    public static void main(String[] args) {
        String json = "["
                + "{\"name\":\"Alice\",\"age\":22},"
                + "{\"name\":\"Bob\",\"age\":28},"
                + "{\"name\":\"Charlie\",\"age\":30}"
                + "]";

        // Parse JSON string to JsonArray
        JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();

        System.out.println("Filtered Records (age > 25):");
        for (JsonElement element : jsonArray) {
            JsonObject obj = element.getAsJsonObject();
            int age = obj.get("age").getAsInt();
            if (age > 25) {
                System.out.println(obj);
            }
        }
    }
}
