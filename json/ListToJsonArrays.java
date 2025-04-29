import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class ListToJsonArrays {
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 28));
        people.add(new Person("Bob", 32));
        people.add(new Person("Charlie", 25));

        Gson gson = new Gson();
        String jsonArray = gson.toJson(people);

        System.out.println("JSON Array:\n" + jsonArray);
    }
}
