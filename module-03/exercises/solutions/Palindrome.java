public class Palindrome {

    public static boolean isPalindrome(String s) {
        String cleaned = s.toLowerCase().replace(" ", "");
        int left = 0;
        int right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] tests = {"Never odd or even", "Java", "madam", "a", ""};
        for (String t : tests) {
            System.out.println("\"" + t + "\" -> " + isPalindrome(t));
        }
    }
}
