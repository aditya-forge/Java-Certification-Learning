public class VariablesDemo {

    public static void main(String[] args) {
        int apples = 7;
        int people = 2;
        double pricePerKg = 120.50;
        boolean inStock = true;
        char grade = 'B';
        String shop = "Local Market";

        System.out.println(shop + " has apples: " + inStock);
        System.out.println("Grade: " + grade);

        // integer division drops the decimal part
        System.out.println("Apples each (int): " + apples / people);
        System.out.println("Apples each (double): " + (double) apples / people);

        // narrowing cast truncates, it does not round
        int roundedDown = (int) pricePerKg;
        System.out.println("Price as int: " + roundedDown);

        final int DAYS_IN_WEEK = 7;
        System.out.println("Days in a week: " + DAYS_IN_WEEK);
    }
}
