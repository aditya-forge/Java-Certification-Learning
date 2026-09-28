public class NumberPattern {

    public static void printPattern(int n) {
        for (int row = 1; row <= n; row++) {
            // row number decides how many numbers go on the line
            for (int col = 1; col <= row; col++) {
                System.out.print(col);
                if (col < row) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPattern(4);
    }
}
