import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MergeJsonExample {
    public static void main(String[] args) {
        // Sample JSON strings
        String json1 = "{\"name\":\"Alice\",\"email\":\"alice@example.com\"}";
        String json2 = "{\"age\":30,\"city\":\"New York\"}";

        // Parse the strings to JsonObjects
        JsonObject obj1 = JsonParser.parseString(json1).getAsJsonObject();
        JsonObject obj2 = JsonParser.parseString(json2).getAsJsonObject();

        // Merge obj2 into obj1
        for (String key : obj2.keySet()) {
            obj1.add(key, obj2.get(key));
        }

        // Convert merged object to JSON string
        Gson gson = new Gson();
        String mergedJson = gson.toJson(obj1);

        System.out.println("Merged JSON: " + mergedJson);
    }
}
