import java.io.IOException;
import java.io.StringReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class HeaderlessCsv {

    static final int CITY = 0;
    static final int STATE = 1;
    static final int VISITORS = 2;

    public static void main(String[] args) throws IOException {
        // no header line: the first line is already data
        String data = "Pune,Maharashtra,5400\n"
                + "Mysuru,Karnataka,3100\n"
                + "Nagpur,Maharashtra,2800\n"
                + "Hampi,Karnataka,1900\n";

        int total = 0;
        int maharashtra = 0;
        for (CSVRecord r : CSVFormat.DEFAULT.parse(new StringReader(data))) {
            int visitors = Integer.parseInt(r.get(VISITORS));
            total += visitors;
            if (r.get(STATE).equals("Maharashtra")) {
                maharashtra += visitors;
            }
            System.out.println(r.get(CITY) + " -> " + visitors);
        }
        System.out.println("Total visitors: " + total);
        System.out.println("Maharashtra only: " + maharashtra);

        // what goes wrong if the parser expects a header
        CSVFormat withHeader = CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).build();
        int rows = 0;
        for (CSVRecord r : withHeader.parse(new StringReader(data))) {
            rows++;
        }
        System.out.println("Rows read when expecting a header: " + rows + " (one lost)");
    }
}
