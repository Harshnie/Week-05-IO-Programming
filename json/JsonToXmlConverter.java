import org.json.JSONObject;
import org.json.XML;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonToXmlConverter {
    public static void main(String[] args) throws Exception {
        // Read JSON content from file
        String json = new String(Files.readAllBytes(Paths.get("data.json")));

        // Convert JSON string to JSONObject
        JSONObject jsonObj = new JSONObject(json);

        // Convert to XML string
        String xml = XML.toString(jsonObj);

        // Print XML
        System.out.println("Converted XML:\n" + xml);
    }
}
