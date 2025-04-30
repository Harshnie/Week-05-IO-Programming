import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CustomObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object value = entry.getValue();

                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(instance, value);
                } catch (NoSuchFieldException e) {
                    System.out.println("No such field: " + fieldName + " in class " + clazz.getSimpleName());
                }
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create object", e);
        }
    }
    public static class Person {
        private String name;
        private int age;

        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }
    public static void main(String[] args) {
        Map<String, Object> props = new HashMap<>();
        props.put("name", "Alice");
        props.put("age", 30);

        Person p = toObject(Person.class, props);
        System.out.println(p);
    }
}
