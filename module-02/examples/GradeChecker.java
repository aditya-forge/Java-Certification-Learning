public class GradeChecker {

    public static String letterGrade(int marks) {
        if (marks < 0 || marks > 100) {
            return "Invalid";
        } else if (marks >= 90) {
            return "A";
        } else if (marks >= 75) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    public static boolean isPass(int marks) {
        return marks >= 40 && marks <= 100;
    }

    public static void main(String[] args) {
        int[] testMarks = {95, 75, 74, 40, 12, 105};

        for (int marks : testMarks) {
            String result = isPass(marks) ? "pass" : "fail";
            System.out.println(marks + " -> " + letterGrade(marks) + " (" + result + ")");
        }

        String input = "YES";
        if (input.equalsIgnoreCase("yes")) {
            System.out.println("Matched using equalsIgnoreCase");
        }
    }
}
