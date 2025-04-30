import java.lang.reflect.Field;

public class ObjectToJson {

    public static String toJson(Object obj) {
        if (obj == null) {
            return "null";
        }

        Class<?> clazz = obj.getClass();
        if (clazz == String.class) {
            return "\"" + obj + "\"";
        }
        if (clazz.isPrimitive() ||
            Number.class.isAssignableFrom(clazz) ||
            clazz == Boolean.class ||
            clazz == Character.class) {
            return obj.toString();
        }

        StringBuilder json = new StringBuilder();
        json.append("{");

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            try {
                Object value = field.get(obj);

                json.append("\"").append(field.getName()).append("\":");

                if (value == null) {
                    json.append("null");
                } else if (value.getClass() == String.class) {
                    json.append("\"").append(value).append("\"");
                } else if (value.getClass().isPrimitive() ||
                           Number.class.isAssignableFrom(value.getClass()) ||
                           value instanceof Boolean ||
                           value instanceof Character) {
                    json.append(value);
                } else {
                    json.append(toJson(value));
                }
            } catch (IllegalAccessException e) {
                json.append("\"ERROR\"");
            }

            if (i < fields.length - 1) {
                json.append(", ");
            }
        }

        json.append("}");
        return json.toString();
    }
    static class Address {
        private String city;
        private String country;

        public Address(String city, String country) {
            this.city = city;
            this.country = country;
        }
    }

    static class Person {
        private String name;
        private int age;
        private boolean isStudent;
        private Address address;

        public Person(String name, int age, boolean isStudent, Address address) {
            this.name = name;
            this.age = age;
            this.isStudent = isStudent;
            this.address = address;
        }
    }

    public static void main(String[] args) {
        Address addr = new Address("New York", "USA");
        Person p = new Person("Alice", 30, true, addr);
        String json = toJson(p);
        System.out.println(json);
    }
}
