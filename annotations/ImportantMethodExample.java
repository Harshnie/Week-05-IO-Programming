import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

public class ImportantMethodExample {

    @ImportantMethod
    public void saveData() {
        System.out.println("Saving data...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void loadData() {
        System.out.println("Loading data...");
    }

    public void helper() {
        System.out.println("Helper method...");
    }

    public static void main(String[] args) {
        Method[] methods = ImportantMethodExample.class.getDeclaredMethods();
        System.out.println("Important Methods:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("- " + method.getName() + " (Level: " + annotation.level() + ")");
            }
        }
    }
}
