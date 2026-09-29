import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ProductFilter {

    static final String FILE = "data/products.csv";

    public static CSVParser openCsv(String path) throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .build();
        return format.parse(new FileReader(path));
    }

    public static void printInCategory(CSVParser parser, String category) {
        for (CSVRecord record : parser) {
            if (record.get("Category").equals(category)) {
                System.out.println("  " + record.get("Name") + " - " + record.get("Price"));
            }
        }
    }

    public static int countOutOfStock(CSVParser parser) {
        int count = 0;
        for (CSVRecord record : parser) {
            if (record.get("Stock").equals("0")) {
                count++;
            }
        }
        return count;
    }

    public static String productInfo(CSVParser parser, String name) {
        for (CSVRecord record : parser) {
            if (record.get("Name").equals(name)) {
                return name + ": " + record.get("Category") + ", price " + record.get("Price");
            }
        }
        // only after checking every row
        return "NOT FOUND";
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Electronics:");
        // a new parser for each method, since each one reads the file to the end
        printInCategory(openCsv(FILE), "Electronics");

        System.out.println("Out of stock: " + countOutOfStock(openCsv(FILE)));
        System.out.println(productInfo(openCsv(FILE), "Desk Lamp, LED"));
        System.out.println(productInfo(openCsv(FILE), "Stapler"));
    }
}
