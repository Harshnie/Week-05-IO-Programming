import java.lang.reflect.Field;

class Person {
    private int age = 25;
}

public class PersonReflection {
    public static void main(String[] args) throws Exception {
        Person p = new Person();

        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);

        System.out.println("Original age: " + ageField.getInt(p));

        ageField.setInt(p, 30);

        System.out.println("Modified age: " + ageField.getInt(p));
    }
}
