import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class ListToJsonArray {

    static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22));
        students.add(new Student("Bob", 23));
        students.add(new Student("Charlie", 21));

        Gson gson = new Gson();
        String jsonArray = gson.toJson(students);

        System.out.println("JSON Array:\n" + jsonArray);
    }
}
