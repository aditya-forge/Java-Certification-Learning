public class CsvFormatDemo {

    public static void main(String[] args) {
        String simple = "Notebook,Stationery,45,120,4.3";
        String quoted = "\"Desk Lamp, LED\",Electronics,899,25,4.6";

        String[] a = simple.split(",");
        String[] b = quoted.split(",");

        System.out.println("Simple line has " + a.length + " parts, name = " + a[0]);
        System.out.println("Quoted line has " + b.length + " parts, name = " + b[0]);
        // 6 parts instead of 5, and the name is cut in half,
        // which is why a proper CSV parser is used instead of split
    }
}
