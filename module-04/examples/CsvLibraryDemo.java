import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CsvLibraryDemo {

    public static CSVParser openCsv(String path) throws IOException {
        Reader in = new FileReader(path);
        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .build();
        return format.parse(in);
    }

    public static void main(String[] args) throws IOException {
        CSVParser parser = openCsv("data/products.csv");
        for (CSVRecord record : parser) {
            // by header name, and by index for the second column
            System.out.println(record.get("Name") + " | " + record.get(1) + " | " + record.get("Price"));
        }

        // the parser is used up now, so this loop prints nothing
        int count = 0;
        for (CSVRecord record : parser) {
            count++;
        }
        System.out.println("Records on second pass: " + count);

        // a fresh parser works again
        count = 0;
        for (CSVRecord record : openCsv("data/products.csv")) {
            count++;
        }
        System.out.println("Records with a new parser: " + count);
    }
}
