import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

@Repeatable(BugReports.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReport {
    String description();
}

public class RepeatableAnnotation{

    @BugReport(description = "Null pointer exception when input is null")
    @BugReport(description = "Incorrect output for negative numbers")
    public void process() {
        System.out.println("Processing something...");
    }

    public static void main(String[] args) throws Exception {
        Method method = RepeatableAnnotation.class.getMethod("process");

        BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);
        System.out.println("Bug Reports:");
        for (BugReport bug : bugReports) {
            System.out.println("- " + bug.description());
        }

        new RepeatableAnnotation().process();
    }
}
