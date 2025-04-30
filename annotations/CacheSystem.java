import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

public class CacheSystem {

    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int number) {
        System.out.println("Computing square for: " + number);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number * number;
    }

    public int invokeWithCache(String methodName, int input) throws Exception {
        Method method = this.getClass().getMethod(methodName, int.class);

        if (method.isAnnotationPresent(CacheResult.class)) {
            if (cache.containsKey(input)) {
                System.out.println("Returning cached result for: " + input);
                return cache.get(input);
            } else {
                int result = (int) method.invoke(this, input);
                cache.put(input, result);
                return result;
            }
        } else {
            return (int) method.invoke(this, input);
        }
    }

    public static void main(String[] args) throws Exception {
        CacheSystem system = new CacheSystem();
        System.out.println("Result: " + system.invokeWithCache("computeSquare", 5));
        System.out.println("Result: " + system.invokeWithCache("computeSquare", 10));
        System.out.println("Result: " + system.invokeWithCache("computeSquare", 5));
    }
}
