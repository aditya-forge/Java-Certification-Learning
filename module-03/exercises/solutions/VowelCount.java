public class VowelCount {

    public static int countVowels(String s) {
        String vowels = "aeiou";
        int count = 0;
        String lower = s.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            // indexOf on a char returns -1 if it isn't one of the vowels
            if (vowels.indexOf(lower.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countVowels("Programming in Java"));  // 6
        System.out.println(countVowels("rhythm"));               // 0
        System.out.println(countVowels("AEIOU"));                // 5
    }
}
