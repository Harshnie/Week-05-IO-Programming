import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class ServiceA {
    public void say() {
        System.out.println("ServiceA called");
    }
}

class ServiceB {
    @Inject
    ServiceA serviceA;

    public void callServiceA() {
        serviceA.say();
    }
}

class SimpleDIContainer {
    private Map<Class<?>, Object> instances = new HashMap<>();
    public <T> T getBean(Class<T> clazz) throws Exception {
        if (instances.containsKey(clazz)) {
            return clazz.cast(instances.get(clazz));
        }

        T obj = clazz.getDeclaredConstructor().newInstance();
        instances.put(clazz, obj);
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = getBean(field.getType());
                field.set(obj, dependency);
            }
        }
        return obj;
    }
}

public class DITest {
    public static void main(String[] args) throws Exception {
        SimpleDIContainer container = new SimpleDIContainer();

        ServiceB serviceB = container.getBean(ServiceB.class);
        serviceB.callServiceA();  
    }
}
