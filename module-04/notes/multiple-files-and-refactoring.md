# Multiple files and refactoring

## Maximum across many files

One file per month or per day is common, so the next step is "find the largest across all of them". It's the same algorithm one level up:

1. For each file, find that file's largest row, using the method that already works for one file.
2. Compare that row with the best across all files so far, using the same `null`-start idea.

```java
CSVRecord overall = null;
for (File f : files) {
    CSVRecord fileBest = largestInFile(openCsv(f));
    // compare fileBest with overall...
}
```

In the course, `DirectoryResource` shows a dialog to pick several files, and `selectedFiles()` gives them for a for-each loop. In plain Java, a folder's files can be listed with `new File("data/sales").listFiles()`.

## Refactoring

Once both methods existed, the "compare two records and keep the larger" logic appeared twice: once in the single-file loop and once in the all-files loop. Refactoring means restructuring code without changing what it does, and here that meant pulling the repeated part into its own method:

```java
public static CSVRecord larger(CSVRecord current, CSVRecord largest) {
    if (largest == null) {
        return current;
    }
    double c = Double.parseDouble(current.get("Revenue"));
    double l = Double.parseDouble(largest.get("Revenue"));
    return c > l ? current : largest;
}
```

Both loops then become one line inside: `largest = larger(current, largest);`.

Benefits:

- a fix, like skipping `N/A`, is made in one place instead of two
- the loops are shorter and say what they do
- the helper can be tested on its own

After refactoring, run the same tests as before. The results must be identical, since behaviour shouldn't change.

## Summary of the module's two problems

- **Filtering** (the export data problem): loop over rows, test a column, output or count matches.
- **Finding the maximum** (the weather problem): loop over rows, keep the best so far starting from `null`, return the whole record, then reuse it across files.

Most data questions are a mix of these two.
