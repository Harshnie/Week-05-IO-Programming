class Student {
    String name;
    int age;

    public Student() {
        this.name = "Default Name";
        this.age = 18;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Student");
        Object obj = cls.getDeclaredConstructor().newInstance();

        Student student = (Student) obj;
        student.display();
    }
}
