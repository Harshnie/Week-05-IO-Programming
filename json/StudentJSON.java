import com.google.gson.Gson;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StudentJSON {
    public static void main(String[] args) {
        Map<String, Object> student = new HashMap<>();
        student.put("name", "John Doe");
        student.put("age", 20);
        student.put("subjects", Arrays.asList("Mathematics", "Physics", "Computer Science"));

        Gson gson = new Gson();
        String jsonOutput = gson.toJson(student);
        System.out.println(jsonOutput);
    }
}
