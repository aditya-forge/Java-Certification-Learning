public class EmailParts {

    public static String username(String email) {
        int at = email.indexOf("@");
        if (at == -1) {
            return "";
        }
        return email.substring(0, at);
    }

    public static String domain(String email) {
        int at = email.indexOf("@");
        if (at == -1) {
            return "";
        }
        return email.substring(at + 1);
    }

    public static void main(String[] args) {
        String[] tests = {"riya.sharma@college.edu", "karan@mail.com", "not-an-email"};
        for (String e : tests) {
            System.out.println(e + " -> user: \"" + username(e) + "\", domain: \"" + domain(e) + "\"");
        }
    }
}
