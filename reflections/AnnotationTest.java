import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "Harshnie")
class Book {
    void display() {
        System.out.println("Book on Java Annotations");
    }
}

public class AnnotationTest {
    public static void main(String[] args) {
        Class<Book> obj = Book.class;
        if (obj.isAnnotationPresent(Author.class)) {
            Author author = obj.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        } else {
            System.out.println("No @Author annotation found.");
        }
    }
}
