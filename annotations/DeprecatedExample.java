public class DeprecatedExample {

    static class LegacyAPI {
        
        @Deprecated
        public void oldFeature() {
            System.out.println("oldFeature() is deprecated and should not be used.");
        }

        public void newFeature() {
            System.out.println("newFeature() is the recommended method.");
        }
    }

    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        api.oldFeature(); 
        api.newFeature();  
    }
}
