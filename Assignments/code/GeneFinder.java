import java.nio.file.*;

/** Gene counting used for the DNA quiz answers (ATG start, TAA/TAG/TGA in-frame stop). */
public class GeneFinder {
    static int findStopCodon(String dna, int startIndex, String stop) {
        int i = dna.indexOf(stop, startIndex + 3);
        while (i != -1) {
            if ((i - startIndex) % 3 == 0) return i;
            i = dna.indexOf(stop, i + 1);
        }
        return dna.length();
    }

    public static void main(String[] args) throws Exception {
        String dna = new String(Files.readAllBytes(Paths.get("dna_sequence.txt"))).trim().toUpperCase();
        int genes = 0, longerThan60 = 0, highCG = 0, longest = 0, start = 0;
        while (true) {
            int s = dna.indexOf("ATG", start);
            if (s == -1) break;
            int e = Math.min(findStopCodon(dna, s, "TAA"),
                    Math.min(findStopCodon(dna, s, "TAG"), findStopCodon(dna, s, "TGA")));
            if (e == dna.length()) { start = s + 3; continue; }
            String g = dna.substring(s, e + 3);
            genes++;
            if (g.length() > 60) longerThan60++;
            long cg = g.chars().filter(c -> c == 'C' || c == 'G').count();
            if ((double) cg / g.length() > 0.35) highCG++;
            longest = Math.max(longest, g.length());
            start = e + 3;
        }
        int ctg = 0;
        for (int i = dna.indexOf("CTG"); i != -1; i = dna.indexOf("CTG", i + 3)) ctg++;
        System.out.println("Genes: " + genes);
        System.out.println("Genes longer than 60: " + longerThan60);
        System.out.println("Genes with cgRatio > 0.35: " + highCG);
        System.out.println("CTG count: " + ctg);
        System.out.println("Longest gene: " + longest);
    }
}
