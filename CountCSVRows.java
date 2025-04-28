import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCSVRows {

    public static void main(String[] args) {
        String filePath = "employees.csv";  
        int recordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            if ((line = br.readLine()) != null) {
            }

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    recordCount++;
                }
            }

            System.out.println(" Number of records (excluding header): " + recordCount);

        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
        }
    }
}
