import com.google.gson.*;
import java.io.*;
import java.nio.file.*;

public class MergeJson {
    public static void main(String[] args) throws IOException {
        String json1 = new String(Files.readAllBytes(Paths.get("file1.json")));
        String json2 = new String(Files.readAllBytes(Paths.get("file2.json")));
        JsonObject obj1 = JsonParser.parseString(json1).getAsJsonObject();
        JsonObject obj2 = JsonParser.parseString(json2).getAsJsonObject();
        for (String key : obj2.keySet()) {
            obj1.add(key, obj2.get(key));
        }
        System.out.println("Merged JSON:");
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(obj1));
    }
}
