/**
 * First program, mainly to check that the JDK and BlueJ are set up correctly.
 *
 * Run from the terminal:
 *   javac HelloJava.java
 *   java HelloJava
 */
public class HelloJava {

    public static void main(String[] args) {
        System.out.println("Hello, Java!");

        // quick check of which Java version is actually running
        String version = System.getProperty("java.version");
        System.out.println("Running on Java " + version);
    }
}
