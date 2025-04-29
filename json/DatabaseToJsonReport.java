import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONObject;

public class DatabaseToJsonReport{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/userdb"; 
        String user = "root";  
        String password = "root";  
        String query = "SELECT id, name, email, age FROM users"; 
        JSONArray jsonArray = new JSONArray();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", rs.getInt("id"));
                jsonObject.put("name", rs.getString("name"));
                jsonObject.put("email", rs.getString("email"));
                jsonObject.put("age", rs.getInt("age"));
                jsonArray.put(jsonObject);
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println(jsonArray.toString(4)); 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
