import java.util.ArrayList;

public class WordCollector {

    // finds every word in the text that starts with a capital letter
    public static ArrayList<String> capitalisedWords(String text) {
        ArrayList<String> results = new ArrayList<>();
        int start = 0;
        while (start < text.length()) {
            int space = text.indexOf(" ", start);
            if (space == -1) {
                space = text.length();
            }
            String word = text.substring(start, space);
            if (!word.isEmpty() && Character.isUpperCase(word.charAt(0))) {
                results.add(word);
            }
            start = space + 1;
        }
        return results;
    }

    public static String longest(ArrayList<String> words) {
        String best = "";
        for (String w : words) {
            if (w.length() > best.length()) {
                best = w;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        String text = "Last week Riya and Karan visited Mumbai and then Pune";
        ArrayList<String> names = capitalisedWords(text);

        System.out.println("Found: " + names);
        System.out.println("How many: " + names.size());
        System.out.println("Longest: " + longest(names));
        System.out.println("First: " + names.get(0));
    }
}
