import java.util.ArrayList;

public class Hashtags {

    public static ArrayList<String> findHashtags(String post) {
        ArrayList<String> tags = new ArrayList<>();
        int hash = post.indexOf("#");
        while (hash != -1) {
            int end = post.indexOf(" ", hash);
            if (end == -1) {
                end = post.length();   // tag runs to the end of the text
            }
            String tag = post.substring(hash + 1, end);
            if (!tag.isEmpty()) {
                tags.add(tag);
            }
            hash = post.indexOf("#", end);
        }
        return tags;
    }

    public static void main(String[] args) {
        System.out.println(findHashtags("Loving the #monsoon in #Pune today #rain"));
        System.out.println(findHashtags("No tags here"));
        System.out.println(findHashtags("#start and a lonely # in the middle"));
    }
}
