import java.lang.reflect.Method;

class TestClass {
    public void fastMethod() {
        System.out.println("Fast method running...");
    }

    public void slowMethod() {
        try {
            Thread.sleep(500);
            System.out.println("Slow method done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int sum(int a, int b) {
        return a + b;
    }
}

public class MethodTiming {

    public static void measureExecutionTime(Object obj) {
        Class<?> class = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getParameterCount() > 0) {
                System.out.println("Skipping method with parameters: " + method.getName());
                continue;
            }

            try {
                method.setAccessible(true);

                long start = System.nanoTime();
                Object result = method.invoke(obj);
                long end = System.nanoTime();

                long durationMs = (end - start) / 1_000_000;

                System.out.printf("Method %s executed in %d ms", method.getName(), durationMs);
                if (method.getReturnType() != void.class) {
                    System.out.printf(", returned: %s", result);
                }
                System.out.println();

            } catch (Exception e) {
                System.out.println("Failed to invoke method " + method.getName());
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestClass test = new TestClass();
        measureExecutionTime(test);
    }
}
