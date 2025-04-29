import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvToJson {
    public static void main(String[] args) {
        try {
            // Read CSV file into a String
            String csvData = new String(Files.readAllBytes(Paths.get("data.csv")));

            // Split the data into lines
            String[] lines = csvData.split("\n");

            // Extract column names (headers)
            String[] headers = lines[0].split(",");

            // Create a JSONArray to hold JSON objects
            JSONArray jsonArray = new JSONArray();

            // Iterate over the rows, starting from index 1 to skip headers
            for (int i = 1; i < lines.length; i++) {
                String[] values = lines[i].split(",");
                JSONObject jsonObject = new JSONObject();

                // Map the header (column name) to the corresponding value
                for (int j = 0; j < headers.length; j++) {
                    jsonObject.put(headers[j], values[j]);
                }

                // Add the JSON object to the JSON array
                jsonArray.put(jsonObject);
            }

            // Print the JSON output
            System.out.println(jsonArray.toString(4));

        } catch (Exception e) {
            // Handle any errors
            e.printStackTrace();
        }
    }
}
