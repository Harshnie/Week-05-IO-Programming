import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "largefile.csv"; 
        int chunkSize = 100;
        int totalRecords = 0;
        int chunkCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineCount = 0;
            String header = br.readLine(); 

            while ((line = br.readLine()) != null) {


                lineCount++;
                totalRecords++;

                if (lineCount == chunkSize) {
                    chunkCount++;
                    System.out.println("Processed chunk " + chunkCount + ": " + lineCount + " lines");
                    lineCount = 0; 
                }
            }
            if (lineCount > 0) {
                chunkCount++;
                System.out.println("Processed final chunk " + chunkCount + ": " + lineCount + " lines");
            }

            System.out.println("✅ Total records processed: " + totalRecords);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
