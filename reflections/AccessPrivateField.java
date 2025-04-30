import java.lang.reflect.Field;
import java.util.Scanner;

class Person {
    private int age = 25; 

    public Person() {
       
    }
}

public class AccessPrivateField {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Person person = new Person();
            Class<?> personClass = person.getClass();
            Field ageField = personClass.getDeclaredField("age");
            ageField.setAccessible(true);
            int currentAge = (int) ageField.get(person);
            System.out.println("Current age: " + currentAge);
            System.out.print("Enter new age: ");
            int newAge = scanner.nextInt();
            ageField.set(person, newAge);
            int updatedAge = (int) ageField.get(person);
            System.out.println("Updated age: " + updatedAge);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
