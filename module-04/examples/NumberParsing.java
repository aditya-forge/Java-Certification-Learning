public class NumberParsing {

    // returns -1 for anything that isn't a valid rating
    public static double parseRating(String text) {
        if (text.equals("N/A") || text.isEmpty()) {
            return -1;
        }
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        int stock = Integer.parseInt("120");
        double price = Double.parseDouble("899");
        System.out.println("Stock + 5 = " + (stock + 5));
        System.out.println("Price with tax = " + price * 1.18);

        // comparing as strings gives the wrong order
        System.out.println("\"9\".compareTo(\"10\") > 0: " + ("9".compareTo("10") > 0));
        System.out.println("9 > 10: " + (9 > 10));

        String[] ratings = {"4.3", "N/A", "", "four", "5"};
        for (String r : ratings) {
            System.out.println("\"" + r + "\" -> " + parseRating(r));
        }

        try {
            Integer.parseInt("4.5");
        } catch (NumberFormatException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
