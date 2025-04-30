import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String name;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "email_address")
    private String email;

    private String password; 

    public User(String name, int age, String email, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }
}

public class JsonSerializer {

    public static String convertToJson(Object obj) throws IllegalAccessException {
        Class<?> cls = obj.getClass();
        Map<String, String> jsonMap = new LinkedHashMap<>();

        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                String key = annotation.name();
                String value = String.valueOf(field.get(obj));
                jsonMap.put(key, value);
            }
        }

        StringBuilder json = new StringBuilder("{\n");
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            json.append("  \"").append(entry.getKey()).append("\": \"")
                .append(entry.getValue()).append("\",\n");
        }
        if (json.length() > 2) {
            json.setLength(json.length() - 2); 
        }
        json.append("\n}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        User user = new User("Harshnie", 22, "harshnie@example.com", "secret123");
        String json = convertToJson(user);
        System.out.println("JSON Output:");
        System.out.println(json);
    }
}
