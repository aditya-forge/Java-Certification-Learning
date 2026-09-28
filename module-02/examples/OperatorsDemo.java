public class OperatorsDemo {

    public static void main(String[] args) {
        int number = 4827;

        // splitting a number into digits with % and /
        int lastDigit = number % 10;
        int withoutLast = number / 10;
        System.out.println("Last digit of " + number + " is " + lastDigit);
        System.out.println("Without last digit: " + withoutLast);

        boolean isEven = number % 2 == 0;
        System.out.println(number + " is even: " + isEven);

        int score = 10;
        score += 5;
        score *= 2;
        score--;
        System.out.println("Score: " + score); // 29

        int divisor = 0;
        // short-circuit: the division never runs because divisor != 0 is false
        if (divisor != 0 && 100 / divisor > 5) {
            System.out.println("Big result");
        } else {
            System.out.println("Skipped the division safely");
        }

        System.out.println("Sum: " + 1 + 2);
        System.out.println("Sum: " + (1 + 2));
    }
}
