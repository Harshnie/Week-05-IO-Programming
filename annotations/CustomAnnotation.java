import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

public class CustomAnnotation {

    @TaskInfo(priority = "High", assignedTo = "Harshnie")
    public void completeProject() {
        System.out.println("Project task is being executed...");
    }

    public static void main(String[] args) {
        try {

            Method method = CustomAnnotation.class.getMethod("completeProject");

            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo task = method.getAnnotation(TaskInfo.class);
                System.out.println("📌 Task Info:");
                System.out.println("Priority: " + task.priority());
                System.out.println("Assigned To: " + task.assignedTo());
            }
            CustomAnnotation obj = new CustomAnnotation();
            obj.completeProject();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
