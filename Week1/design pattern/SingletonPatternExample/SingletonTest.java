public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Singleton Pattern ===");

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("Logger 1 reference: " + logger1);
        System.out.println("Logger 2 reference: " + logger2);

        logger1.log("First log message.");
        logger2.log("Second log message.");

        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both references point to the exact same instance.");
        } else {
            System.out.println("FAILURE: Different instances were created!");
        }
    }
}
