public class LogicalOperatorsDemo {

    // index of whichever of the words appears first, or -1 if none do
    public static int earliestOf(String text, String w1, String w2, String w3) {
        int first = -1;
        String[] words = {w1, w2, w3};
        for (String w : words) {
            int pos = text.indexOf(w);
            if (pos != -1 && (first == -1 || pos < first)) {
                first = pos;
            }
        }
        return first;
    }

    // simple check: exactly one @, something before it, and a dot somewhere after it
    public static boolean looksLikeEmail(String s) {
        int at = s.indexOf("@");
        if (at <= 0 || at != s.lastIndexOf("@")) {
            return false;
        }
        int dot = s.indexOf(".", at);
        return dot != -1 && dot > at + 1 && dot < s.length() - 1;
    }

    public static void main(String[] args) {
        String sentence = "the weather is cold, then warm, then hot";
        System.out.println("earliest of hot/warm/cold: "
                + earliestOf(sentence, "hot", "warm", "cold"));
        System.out.println("earliest of rain/snow/fog: "
                + earliestOf(sentence, "rain", "snow", "fog"));

        String[] emails = {"riya@mail.com", "@mail.com", "riya@@mail.com", "riya@mail", "riya@.com"};
        for (String e : emails) {
            System.out.println(e + " -> " + looksLikeEmail(e));
        }
    }
}
