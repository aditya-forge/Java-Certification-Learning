public class WhileLoopsDemo {

    public static void printPositions(String text, String target) {
        System.out.print("\"" + target + "\" in \"" + text + "\": ");
        int pos = text.indexOf(target);
        while (pos != -1) {
            System.out.print(pos + " ");
            pos = text.indexOf(target, pos + target.length());
        }
        System.out.println();
    }

    // same idea but counting, and allowing overlaps by moving on by one
    public static int countOverlapping(String text, String target) {
        int count = 0;
        int from = 0;
        while (true) {
            int pos = text.indexOf(target, from);
            if (pos == -1) {
                break;
            }
            count++;
            from = pos + 1;
        }
        return count;
    }

    public static int countDigits(String text) {
        int count = 0;
        int i = 0;
        while (i < text.length()) {
            if (Character.isDigit(text.charAt(i))) {
                count++;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        printPositions("the cat sat on the mat", "at");
        printPositions("aaaa", "aa");
        printPositions("hello", "z");

        System.out.println("overlapping \"aa\" in \"aaaa\": " + countOverlapping("aaaa", "aa"));
        System.out.println("digits in \"Room 204, floor 3\": " + countDigits("Room 204, floor 3"));
    }
}
