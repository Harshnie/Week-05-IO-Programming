import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {

    public static void main(String[] args) {
        String filePath = "students.csv"; 

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            
            if ((line = br.readLine()) != null) {
                System.out.println("Headers: " + line);
            }

            System.out.println("\nStudent Records:");
   
           
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

         
                if (data.length == 4) {
                    System.out.println("ID    : " + data[0]);
                    System.out.println("Name  : " + data[1]);
                    System.out.println("Age   : " + data[2]);
                    System.out.println("Marks : " + data[3]);
                } else {
                    System.out.println("Skipping malformed line: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
