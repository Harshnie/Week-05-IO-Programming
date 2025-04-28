import java.io.*;
import java.util.*;

public class SortCSVBySalary {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        List<String[]> employeeData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine(); 

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                employeeData.add(data);
            }
            employeeData.sort((a, b) -> {
                double salaryA = Double.parseDouble(a[3]);
                double salaryB = Double.parseDouble(b[3]);
                return Double.compare(salaryB, salaryA); 
            });
            System.out.println("Top 5 Highest-Paid Employees:");
            System.out.println(header);
            for (int i = 0; i < Math.min(5, employeeData.size()); i++) {
                String[] record = employeeData.get(i);
                System.out.println(String.join(",", record));
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
