public class MethodsDemo {

    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static int maxOfThree(int a, int b, int c) {
        int largest = a;
        if (b > largest) {
            largest = b;
        }
        if (c > largest) {
            largest = c;
        }
        return largest;
    }

    public static void printDivider(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // reassigning a parameter only changes the local copy
    public static void tryToChange(int value) {
        value = 999;
    }

    public static void main(String[] args) {
        System.out.println("25 C = " + celsiusToFahrenheit(25) + " F");
        System.out.println("Is 14 even? " + isEven(14));
        System.out.println("Max of 3, 17, 9: " + maxOfThree(3, 17, 9));

        printDivider(20);

        int original = 5;
        tryToChange(original);
        System.out.println("After tryToChange: " + original); // still 5
    }
}
