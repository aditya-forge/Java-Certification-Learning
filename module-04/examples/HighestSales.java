import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class HighestSales {

    public static CSVParser openCsv(File file) throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .build();
        return format.parse(new FileReader(file));
    }

    public static boolean isValid(CSVRecord record) {
        return !record.get("Revenue").equals("N/A");
    }

    // keeps whichever of the two has more revenue; largest may be null
    public static CSVRecord larger(CSVRecord current, CSVRecord largest) {
        if (largest == null) {
            return current;
        }
        double c = Double.parseDouble(current.get("Revenue"));
        double l = Double.parseDouble(largest.get("Revenue"));
        return c > l ? current : largest;
    }

    // returns null if the file has no valid rows
    public static CSVRecord largestInFile(CSVParser parser) {
        CSVRecord largest = null;
        for (CSVRecord current : parser) {
            if (isValid(current)) {
                largest = larger(current, largest);
            }
        }
        return largest;
    }

    public static CSVRecord largestInFolder(File folder) throws IOException {
        File[] files = folder.listFiles();
        Arrays.sort(files);
        CSVRecord overall = null;
        for (File f : files) {
            CSVRecord fileBest = largestInFile(openCsv(f));
            System.out.println("  best in " + f.getName() + ": " + describe(fileBest));
            if (fileBest != null) {
                overall = larger(fileBest, overall);
            }
        }
        return overall;
    }

    public static String describe(CSVRecord r) {
        if (r == null) {
            return "no valid rows";
        }
        return r.get("Date") + " at " + r.get("Store") + ", revenue " + r.get("Revenue");
    }

    public static void main(String[] args) throws IOException {
        CSVRecord best = largestInFolder(new File("data/sales"));
        System.out.println("Best day overall: " + describe(best));
    }
}
