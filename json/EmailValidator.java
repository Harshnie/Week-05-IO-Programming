import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;

public class EmailValidator {
    public static void main(String[] args) {
        try {
            FileInputStream schemaStream = new FileInputStream("schema.json");
            FileInputStream dataStream = new FileInputStream("mail.json");

            JSONObject rawSchema = new JSONObject(new JSONTokener(schemaStream));
            Schema schema = SchemaLoader.load(rawSchema);

            JSONObject jsonData = new JSONObject(new JSONTokener(dataStream));

            schema.validate(jsonData); // throws ValidationException if invalid
            System.out.println(" JSON is valid!");

        } catch (Exception e) {
            System.out.println(" Validation error: " + e.getMessage());
        }
    }
}
