public class StringBasics {

    public static void main(String[] args) {
        String word = "banana";

        System.out.println("Length: " + word.length());
        System.out.println("First char: " + word.charAt(0));
        System.out.println("Last char: " + word.charAt(word.length() - 1));

        System.out.println("indexOf(\"an\"): " + word.indexOf("an"));
        System.out.println("indexOf(\"an\", 2): " + word.indexOf("an", 2));
        System.out.println("lastIndexOf(\"a\"): " + word.lastIndexOf("a"));
        System.out.println("indexOf(\"xyz\"): " + word.indexOf("xyz"));

        System.out.println("substring(1, 4): " + word.substring(1, 4));
        System.out.println("substring(3): " + word.substring(3));

        // strings are immutable: the result has to be stored
        String shout = "hello";
        shout.toUpperCase();
        System.out.println("Not stored: " + shout);
        shout = shout.toUpperCase();
        System.out.println("Stored: " + shout);

        String messy = "   Java Strings   ";
        System.out.println("[" + messy.trim() + "]");

        System.out.println("equalsIgnoreCase: " + "Java".equalsIgnoreCase("JAVA"));
    }
}
