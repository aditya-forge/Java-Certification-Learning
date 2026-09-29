import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class BestMonth {

    public static double monthTotal(File file) throws IOException {
        double total = 0;
        for (CSVRecord r : CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).build()
                .parse(new FileReader(file))) {
            String revenue = r.get("Revenue");
            if (!revenue.equals("N/A")) {
                total += Double.parseDouble(revenue);
            }
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        File[] files = new File("data/sales").listFiles();
        Arrays.sort(files);

        String bestName = null;
        double bestTotal = 0;
        for (File f : files) {
            double total = monthTotal(f);
            System.out.println(f.getName() + ": " + total);
            if (bestName == null || total > bestTotal) {
                bestName = f.getName();
                bestTotal = total;
            }
        }
        System.out.println("Best month: " + bestName + " (" + bestTotal + ")");
    }
}
