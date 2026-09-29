public class MathDemo {

    public static int largestOfThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    // is the gap between two positions a whole number of 3-character chunks?
    public static boolean isChunkAligned(int start, int end) {
        return (end - start) % 3 == 0;
    }

    public static void main(String[] args) {
        System.out.println("abs(-7): " + Math.abs(-7));
        System.out.println("pow(2, 10): " + Math.pow(2, 10));
        System.out.println("sqrt(2): " + Math.sqrt(2));
        System.out.println("round(2.5): " + Math.round(2.5));
        System.out.println("ceil(2.1): " + Math.ceil(2.1));
        System.out.println("floor(2.9): " + Math.floor(2.9));
        System.out.println("largest of 4, 11, 7: " + largestOfThree(4, 11, 7));

        // dice roll: random() gives [0, 1), scale it then shift to 1-6
        int roll = (int) (Math.random() * 6) + 1;
        System.out.println("dice roll: " + roll);

        System.out.println("gap 3 to 12 aligned: " + isChunkAligned(3, 12));
        System.out.println("gap 3 to 13 aligned: " + isChunkAligned(3, 13));

        int big = Integer.MAX_VALUE;
        System.out.println("int overflow: " + (big + 1));
        System.out.println("as long: " + ((long) big + 1));

        double sum = 0.1 + 0.2;
        System.out.println("0.1 + 0.2 = " + sum);
        System.out.println("close to 0.3: " + (Math.abs(sum - 0.3) < 0.0001));
    }
}
