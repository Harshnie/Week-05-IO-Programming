import java.io.*;
import java.util.*;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                   
                    bw.write(line);
                    bw.newLine();
                    isHeader = false;
                } else {
                    String department = data[2];
                    double salary = Double.parseDouble(data[3]);
                    if (department.equalsIgnoreCase("IT")) {
                        salary = salary * 1.10;
                        data[3] = String.format("%.2f", salary); 
                    }

                    // Write updated line
                    bw.write(String.join(",", data));
                    bw.newLine();
                }
            }

            System.out.println("Salaries updated and saved to " + outputFile);

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
