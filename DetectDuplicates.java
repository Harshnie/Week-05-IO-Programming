import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "students.csv";
        Set<String> seenIDs = new HashSet<>();
        Set<String> duplicateLines = new LinkedHashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0].trim();

                if (seenIDs.contains(id)) {
                    duplicateLines.add(line);
                } else {
                    seenIDs.add(id);
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        if (duplicateLines.isEmpty()) {
            System.out.println(" No duplicate records found.");
        } else {
            System.out.println(" Duplicate Records:");
            for (String dup : duplicateLines) {
                System.out.println("Duplicate Record Found: " + dup);
            }
        }
    }
}
