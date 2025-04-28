import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String filePath = "contacts.csv";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^\\d{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine(); 
            System.out.println("Invalid Records:");

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length != 4) {
                    System.out.println("Malformed line: " + line);
                    continue;
                }

                String email = data[2].trim();
                String phone = data[3].trim();

                boolean emailValid = emailPattern.matcher(email).matches();
                boolean phoneValid = phonePattern.matcher(phone).matches();

                if (!emailValid || !phoneValid) {
                    System.out.println("Invalid row: " + line);
                    if (!emailValid) System.out.println("  ➤ Invalid Email: " + email);
                    if (!phoneValid) System.out.println("  ➤ Invalid Phone Number: " + phone);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
