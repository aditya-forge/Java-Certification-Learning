public class Compress {

    public static String compress(String s) {
        if (s.isEmpty()) {
            return "";
        }
        String result = "";
        char current = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == current) {
                count++;
            } else {
                result = result + current + count;
                current = s.charAt(i);
                count = 1;
            }
        }
        // the last run is still pending when the loop ends
        result = result + current + count;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(compress("aaabbcdddd"));  // a3b2c1d4
        System.out.println(compress("abc"));         // a1b1c1
        System.out.println(compress("zzzz"));        // z4
        System.out.println(compress(""));            // (empty)
    }
}
