public class DigitSum {

    public static int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;  // take the last digit
            n /= 10;        // then drop it
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(digitSum(4827)); // 21
        System.out.println(digitSum(0));    // 0
        System.out.println(digitSum(9));    // 9
    }
}
