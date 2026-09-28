public class ArraySummary {

    public static void printSummary(int[] values) {
        // start from the first element, not 0, so negative-only arrays work
        int max = values[0];
        int min = values[0];
        int total = 0;

        for (int v : values) {
            if (v > max) {
                max = v;
            }
            if (v < min) {
                min = v;
            }
            total += v;
        }

        // cast before dividing, otherwise it's integer division
        double average = (double) total / values.length;

        int aboveAverage = 0;
        for (int v : values) {
            if (v > average) {
                aboveAverage++;
            }
        }

        System.out.println("Max: " + max + ", Min: " + min
                + ", Average: " + average + ", Above average: " + aboveAverage);
    }

    public static void main(String[] args) {
        printSummary(new int[] {4, 8, 15, 16, 23, 42});
        printSummary(new int[] {-5, -12, -3});
    }
}
