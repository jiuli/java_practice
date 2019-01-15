package design;

public class AnonymousClass {
    public static void main( String[] args ) {
        new Thread(
            // Example of creating anonymous class which implements
            // Runnable interface
            new Runnable() {                
                @Override
                public void run() {
                    // Implementation here
                }
            }
        ).start();
    }
}
