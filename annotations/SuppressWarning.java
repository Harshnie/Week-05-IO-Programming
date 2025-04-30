import java.util.ArrayList;

public class SuppressWarning{

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); 

        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        String fruit = (String) list.get(0);
        System.out.println("First fruit: " + fruit);
    }
}
