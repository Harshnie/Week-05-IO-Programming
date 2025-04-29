import org.json.JSONArray;
import org.json.JSONObject;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;

public class IPLAnalyzer {
    public static void main(String[] args) {
        try {
            JSONArray matches = new JSONArray(new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("input.json"))));
            for (int i = 0; i < matches.length(); i++) {
                JSONObject match = matches.getJSONObject(i);
                match.put("team1", maskTeam(match.getString("team1")));
                match.put("team2", maskTeam(match.getString("team2")));
                match.put("winner", maskTeam(match.getString("winner")));
                match.put("player_of_match", "REDACTED");
            }
            try (FileWriter jsonOut = new FileWriter("output.json")) {
                jsonOut.write(matches.toString(4));
            }
            try (CSVReader reader = new CSVReader(new FileReader("input.csv"));
                 CSVWriter writer = new CSVWriter(new FileWriter("output.csv"))) {
                String[] header = reader.readNext();
                writer.writeNext(header);
                String[] row;
                while ((row = reader.readNext()) != null) {
                    row[1] = maskTeam(row[1]);
                    row[2] = maskTeam(row[2]);
                    row[5] = maskTeam(row[5]);
                    row[6] = "REDACTED";
                    writer.writeNext(row);
                }
            }

            System.out.println("Censorship complete. Output files generated.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String maskTeam(String teamName) {
        int spaceIndex = teamName.indexOf(" ");
        return spaceIndex != -1 ? teamName.substring(0, spaceIndex) + " ***" : "***";
    }
}
