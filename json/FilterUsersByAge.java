import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FilterUsersByAge {
    public static void main(String[] args) {
        String json = "["
                + "{\"name\":\"Alice\",\"age\":22},"
                + "{\"name\":\"Bob\",\"age\":28},"
                + "{\"name\":\"Charlie\",\"age\":35},"
                + "{\"name\":\"David\",\"age\":25}"
                + "]";

        JsonArray users = JsonParser.parseString(json).getAsJsonArray();

        System.out.println("Users older than 25:");

        for (JsonElement element : users) {
            JsonObject user = element.getAsJsonObject();
            int age = user.get("age").getAsInt();
            if (age > 25) {
                System.out.println(user);
            }
        }
    }
}
