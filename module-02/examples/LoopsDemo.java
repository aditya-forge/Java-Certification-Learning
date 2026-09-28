public class LoopsDemo {

    public static int sum(int[] values) {
        int total = 0;
        for (int v : values) {
            total += v;
        }
        return total;
    }

    public static int countAbove(int[] values, int limit) {
        int count = 0;
        for (int v : values) {
            if (v > limit) {
                count++;
            }
        }
        return count;
    }

    // starts from the first element so it also works when every value is negative
    public static int smallest(int[] values) {
        int min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] < min) {
                min = values[i];
            }
        }
        return min;
    }

    public static int countDigits(int n) {
        if (n == 0) {
            return 1;
        }
        n = Math.abs(n);
        int digits = 0;
        while (n > 0) {
            n /= 10;
            digits++;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] temps = {-3, 12, 7, -8, 15, 4};

        System.out.println("Sum: " + sum(temps));
        System.out.println("Above 5: " + countAbove(temps, 5));
        System.out.println("Smallest: " + smallest(temps));
        System.out.println("Digits in 4827: " + countDigits(4827));

        // index loop, since the position is needed
        for (int i = 0; i < temps.length; i++) {
            if (temps[i] < 0) {
                System.out.println("First negative at index " + i);
                break;
            }
        }
    }
}
