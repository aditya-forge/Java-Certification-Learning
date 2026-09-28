/*
 * Worked 250 units by hand first:
 *   first 100 -> 100 * 5 = 500
 *   next 100  -> 100 * 7 = 700
 *   last 50   ->  50 * 10 = 500
 *   total 1700
 */
public class ElectricityBill {

    public static int billAmount(int units) {
        if (units <= 100) {
            return units * 5;
        } else if (units <= 200) {
            return 100 * 5 + (units - 100) * 7;
        } else {
            return 100 * 5 + 100 * 7 + (units - 200) * 10;
        }
    }

    public static void main(String[] args) {
        System.out.println(billAmount(80));   // 400
        System.out.println(billAmount(100));  // 500
        System.out.println(billAmount(150));  // 850
        System.out.println(billAmount(250));  // 1700
    }
}
