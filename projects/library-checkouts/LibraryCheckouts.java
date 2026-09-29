import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * Small analyser for yearly library checkout files.
 * Each file is data/checkouts-YEAR.csv with no header: title,genre,count
 */
public class LibraryCheckouts {

    static final int TITLE = 0;
    static final int GENRE = 1;
    static final int COUNT = 2;

    static final int FIRST_YEAR = 2023;
    static final int LAST_YEAR = 2025;

    public static File fileFor(int year) {
        return new File("data/checkouts-" + year + ".csv");
    }

    public static CSVParser open(int year) throws IOException {
        return CSVFormat.DEFAULT.parse(new FileReader(fileFor(year)));
    }

    public static int count(CSVRecord r) {
        return Integer.parseInt(r.get(COUNT));
    }

    public static void printYearSummary(int year) throws IOException {
        int total = 0;
        int titles = 0;
        for (CSVRecord r : open(year)) {
            total += count(r);
            titles++;
        }
        System.out.println(year + ": " + titles + " titles, " + total + " checkouts");
    }

    public static int genreTotal(int year, String genre) throws IOException {
        int total = 0;
        for (CSVRecord r : open(year)) {
            if (r.get(GENRE).equals(genre)) {
                total += count(r);
            }
        }
        return total;
    }

    // returns null if the genre has no titles that year
    public static CSVRecord topInGenre(int year, String genre) throws IOException {
        CSVRecord best = null;
        for (CSVRecord r : open(year)) {
            if (r.get(GENRE).equals(genre) && (best == null || count(r) > count(best))) {
                best = r;
            }
        }
        return best;
    }

    // checkouts for one title in a year, or 0 if it wasn't in that year's file
    public static int checkoutsFor(int year, String title) throws IOException {
        for (CSVRecord r : open(year)) {
            if (r.get(TITLE).equals(title)) {
                return count(r);
            }
        }
        return 0;
    }

    public static void printTrend(String title) throws IOException {
        int bestYear = -1;
        int bestCount = 0;
        System.out.print(title + ":");
        for (int year = FIRST_YEAR; year <= LAST_YEAR; year++) {
            int c = checkoutsFor(year, title);
            System.out.print(" " + year + "=" + c);
            if (c > bestCount) {
                bestCount = c;
                bestYear = year;
            }
        }
        if (bestYear == -1) {
            System.out.println("  (never borrowed)");
        } else {
            System.out.println("  -> peak in " + bestYear);
        }
    }

    public static String busiestGenreOverall(String[] genres) throws IOException {
        String best = null;
        int bestTotal = 0;
        for (String genre : genres) {
            int total = 0;
            for (int year = FIRST_YEAR; year <= LAST_YEAR; year++) {
                total += genreTotal(year, genre);
            }
            System.out.println("  " + genre + ": " + total);
            if (best == null || total > bestTotal) {
                best = genre;
                bestTotal = total;
            }
        }
        return best;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Yearly summary");
        for (int year = FIRST_YEAR; year <= LAST_YEAR; year++) {
            printYearSummary(year);
        }

        System.out.println();
        System.out.println("Top Fiction title each year");
        for (int year = FIRST_YEAR; year <= LAST_YEAR; year++) {
            CSVRecord top = topInGenre(year, "Fiction");
            System.out.println(year + ": " + (top == null ? "none" : top.get(TITLE) + " (" + top.get(COUNT) + ")"));
        }

        System.out.println();
        System.out.println("Trends");
        printTrend("The Silent River");
        printTrend("Glass City");
        printTrend("Empire Roads");
        printTrend("Unknown Book");

        System.out.println();
        System.out.println("Checkouts per genre, all years");
        String busiest = busiestGenreOverall(new String[] {"Fiction", "Science", "History", "Kids"});
        System.out.println("Busiest genre: " + busiest);
    }
}
