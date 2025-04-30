import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

public class TodoAnnotation {

    @Todo(task = "Implement login authentication", assignedTo = "Harshnie", priority = "HIGH")
    public void loginFeature() {
        System.out.println("Login feature...");
    }

    @Todo(task = "Add profile update option", assignedTo = "Aarav")
    public void profileFeature() {
        System.out.println("Profile feature...");
    }

    public void completedFeature() {
        System.out.println("This feature is done.");
    }

    public static void main(String[] args) {
        Method[] methods = TodoAnnotation.class.getDeclaredMethods();
        System.out.println("Pending Tasks:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("- Method: " + method.getName());
                System.out.println("  Task: " + todo.task());
                System.out.println("  Assigned To: " + todo.assignedTo());
                System.out.println("  Priority: " + todo.priority());
                System.out.println();
            }
        }
    }
}
