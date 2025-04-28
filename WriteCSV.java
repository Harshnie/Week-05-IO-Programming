import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {

    public static void main(String[] args) {
        String filePath = "employees.csv";

        
        String[] headers = {"ID", "Name", "Department", "Salary"};
        String[][] employees = {
            {"201", "John Doe", "HR", "50000"},
            {"202", "Jane Smith", "Finance", "60000"},
            {"203", "David Lee", "IT", "75000"},
            {"204", "Emily Clark", "Marketing", "55000"},
            {"205", "Michael Brown", "Sales", "58000"}
        };

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append(String.join(",", headers));
            writer.append("\n");
           
            for (String[] emp : employees) {
                writer.append(String.join(",", emp));
                writer.append("\n");
            }

            System.out.println(" Data written successfully to " + filePath);
        } catch (IOException e) {
            System.out.println(" Error writing to file: " + e.getMessage());
        }
    }
}
