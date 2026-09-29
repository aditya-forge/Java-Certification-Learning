import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class AverageRating {

    public static void main(String[] args) throws IOException {
        double total = 0;
        int counted = 0;
        int skipped = 0;

        for (CSVRecord r : CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).build()
                .parse(new FileReader("data/products.csv"))) {
            String rating = r.get("Rating");
            if (rating.equals("N/A")) {
                skipped++;
            } else {
                total += Double.parseDouble(rating);
                counted++;
            }
        }

        if (counted == 0) {
            System.out.println("No ratings to average");
        } else {
            System.out.printf("Average rating: %.2f (from %d products, %d skipped)%n",
                    total / counted, counted, skipped);
        }
    }
}
