import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCSV {
    public static void main(String[] args) {
        String filePath = "students.csv"; 

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); 
            System.out.println("Qualifying Students (Marks > 80):");
            System.out.println(line); 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Ensure the CSV has exactly 3 columns: ID, Name, Marks
                if (data.length == 3) {
                    int marks = Integer.parseInt(data[2]);

                    if (marks > 80) {
                        System.out.println(line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in CSV.");
        }
    }
}
