import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class ReadJsonFields {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("users.json");
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            String name = jsonObject.get("name").getAsString();
            String email = jsonObject.get("email").getAsString();

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
