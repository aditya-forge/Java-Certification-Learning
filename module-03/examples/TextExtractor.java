public class TextExtractor {

    // returns the text between the first `open` marker and the next `close` after it
    public static String between(String text, String open, String close) {
        int start = text.indexOf(open);
        if (start == -1) {
            return "";
        }
        int from = start + open.length();
        int end = text.indexOf(close, from);
        if (end == -1) {
            return "";
        }
        return text.substring(from, end);
    }

    public static void test(String text, String open, String close) {
        String result = between(text, open, close);
        System.out.println("\"" + text + "\" -> \"" + result + "\"");
    }

    public static void main(String[] args) {
        test("Order [A123] shipped", "[", "]");
        test("Order A123 shipped", "[", "]");          // no opening marker
        test("Order [A123 shipped", "[", "]");         // no closing marker
        test("] early close [X9]", "[", "]");          // close appears before open
        test("[]", "[", "]");                          // empty between
        test("Some <b>bold</b> text", "<b>", "</b>");  // longer markers
    }
}
