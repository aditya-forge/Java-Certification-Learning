public class PasswordRules {

    public static boolean isStrong(String p) {
        if (p.length() < 8 || p.contains(" ")) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        return hasUpper && hasLower && hasDigit;
    }

    public static void main(String[] args) {
        String[] tests = {"Java2026", "java2026", "JAVA2026", "Javaisfun", "Ja 2026xx", "Jv1"};
        for (String t : tests) {
            System.out.println(t + " -> " + isStrong(t));
        }
    }
}
