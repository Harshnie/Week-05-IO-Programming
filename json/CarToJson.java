import com.google.gson.Gson;

public class CarToJson {

    // Inner Car class
    static class Car {
        private String brand;
        private String model;
        private int year;

        public Car(String brand, String model, int year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }
    }

    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Camry", 2022);

        Gson gson = new Gson();
        String json = gson.toJson(myCar);

        System.out.println("Car as JSON: " + json);
    }
}
