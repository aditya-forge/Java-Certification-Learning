import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CheapestInStock {

    // returns null if nothing is in stock
    public static CSVRecord cheapestInStock(CSVParser parser) {
        CSVRecord cheapest = null;
        for (CSVRecord current : parser) {
            if (Integer.parseInt(current.get("Stock")) == 0) {
                continue;
            }
            if (cheapest == null) {
                cheapest = current;
            } else {
                double c = Double.parseDouble(current.get("Price"));
                double best = Double.parseDouble(cheapest.get("Price"));
                if (c < best) {
                    cheapest = current;
                }
            }
        }
        return cheapest;
    }

    public static void main(String[] args) throws IOException {
        CSVParser parser = CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).build()
                .parse(new FileReader("data/products.csv"));
        CSVRecord result = cheapestInStock(parser);
        if (result == null) {
            System.out.println("Nothing in stock");
        } else {
            System.out.println("Cheapest in stock: " + result.get("Name") + " at " + result.get("Price"));
        }
    }
}
