import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

public class RoleAccessControl {

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted successfully.");
    }

    @RoleAllowed("USER")
    public void viewProfile() {
        System.out.println("Viewing profile.");
    }

    public void generalInfo() {
        System.out.println("This is general information for all roles.");
    }

    public static void main(String[] args) throws Exception {
        String currentUserRole = "USER"; 
        RoleAccessControl obj = new RoleAccessControl();

        Method[] methods = RoleAccessControl.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (roleAllowed.value().equals(currentUserRole)) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied to method: " + method.getName());
                }
            } else {
                method.invoke(obj);
            }
        }
    }
}
