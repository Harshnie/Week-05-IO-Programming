import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        Map<String, String[]> studentInfo = new LinkedHashMap<>();

        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            String line1 = br1.readLine(); 

            while ((line1 = br1.readLine()) != null) {
                String[] data = line1.split(",");
                String id = data[0].trim();
                studentInfo.put(id, new String[] { data[1].trim(), data[2].trim() }); 
            }
            br1.close();
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            String line2 = br2.readLine(); 

            while ((line2 = br2.readLine()) != null) {
                String[] data = line2.split(",");
                String id = data[0].trim();
                String marks = data[1].trim();
                String grade = data[2].trim();

                if (studentInfo.containsKey(id)) {
                    String[] info = studentInfo.get(id);
                    studentInfo.put(id, new String[] { info[0], info[1], marks, grade }); 
                }
            }
            br2.close();
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            for (Map.Entry<String, String[]> entry : studentInfo.entrySet()) {
                String id = entry.getKey();
                String[] details = entry.getValue();
                bw.write(id + "," + String.join(",", details));
                bw.newLine();
            }
            bw.close();

            System.out.println("CSV files merged successfully into " + outputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
