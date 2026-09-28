public class LeapYear {

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        int[] years = {2024, 1900, 2000, 2023};
        for (int year : years) {
            System.out.println(year + ": " + isLeapYear(year));
        }
    }
}
