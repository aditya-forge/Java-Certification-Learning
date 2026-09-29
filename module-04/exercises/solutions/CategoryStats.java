import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CategoryStats {

    public static CSVParser openCsv(String path) throws IOException {
        return CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).build()
                .parse(new FileReader(path));
    }

    public static void printStats(String category) throws IOException {
        int count = 0;
        double stockValue = 0;
        for (CSVRecord r : openCsv("data/products.csv")) {
            if (r.get("Category").equals(category)) {
                count++;
                double price = Double.parseDouble(r.get("Price"));
                int stock = Integer.parseInt(r.get("Stock"));
                stockValue += price * stock;
            }
        }
        System.out.println(category + ": " + count + " products, stock value " + stockValue);
    }

    public static void main(String[] args) throws IOException {
        printStats("Electronics");
        printStats("Stationery");
        printStats("Toys");
    }
}
