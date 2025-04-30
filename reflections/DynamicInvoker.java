import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}

public class DynamicInvoker {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter method name (add / subtract / multiply): ");
        String methodName = sc.nextLine();
        System.out.print("Enter first number: ");
        int x = sc.nextInt();
        System.out.print("Enter second number: ");
        int y = sc.nextInt();
        sc.close();

        MathOperations ops = new MathOperations();
        Method method = MathOperations.class.getMethod(methodName, int.class, int.class);
        int result = (int) method.invoke(ops, x, y);
        System.out.println("Result: " + result);
    }
}
