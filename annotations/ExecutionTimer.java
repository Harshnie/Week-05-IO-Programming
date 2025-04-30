import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

public class ExecutionTimer {

    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1000; i++) {
            int x = i * i;
        }
    }

    @LogExecutionTime
    public void slowMethod() {
        for (int i = 0; i < 1_000_000; i++) {
            int x = i * i;
        }
    }

    public void normalMethod() {
        System.out.println("Not logged.");
    }

    public static void main(String[] args) throws Exception {
        ExecutionTimer obj = new ExecutionTimer();
        Method[] methods = ExecutionTimer.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(obj);
                long end = System.nanoTime();
                long duration = end - start;
                System.out.println( method.getName() + " executed in " + duration / 1_000_000.0 + " ms");
            }
        }
    }
}
