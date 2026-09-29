# Module 4 - CSV Files and Basic Statistics in Java

Reading real data files. The module works through two problems: filtering rows of trade data, and finding the hottest reading in weather data. Then it extends the second one to many files and cleans the code up. I practised the same ideas on my own product and sales data.

## Notes in lecture order

1. [CSV format](notes/csv-format.md) (CSV Data: Comma Separated Values)
2. [Using a CSV library](notes/csv-library.md) (Apache Commons CSV, `CSVParser`, `CSVRecord`)
3. [Filtering rows](notes/filtering-rows.md) (the pattern behind the export data lectures)
4. [Converting strings to numbers](notes/strings-to-numbers.md)
5. [Finding the maximum](notes/finding-the-maximum.md) (developing, translating and testing the algorithm)
6. [null](notes/null.md) (Java for Nothing: when you don't have an object)
7. [Multiple files and refactoring](notes/multiple-files-and-refactoring.md) (multiple datasets, refactored version, summary)

## Key concepts

- CSV structure, headers, and why splitting on commas isn't enough
- `CSVParser` is iterable, `CSVRecord.get("Column")` returns a `String`, and a parser can only be read once
- `Integer.parseInt` / `Double.parseDouble`, `NumberFormatException`, and placeholder values like `N/A`
- Best-so-far starting from `null`, returning the whole record
- Reusing a one-file method across many files, and refactoring the repeated comparison into a helper

## What I practiced

- `data/` has a small product list (including a quoted name with a comma and some `N/A` ratings) and three months of sales, with one bad row
- `examples/` has a runnable program for each topic
- `exercises/` has four problems on that data: category stats, average rating, cheapest in stock and best month

The course's own programming exercises (export data and weather data) are not included.

## Running the examples

Most examples need Apache Commons CSV. From this folder:

```
java -cp commons-csv-1.10.0.jar examples/HighestSales.java
```

`CsvFormatDemo` and `NumberParsing` run without it.

## Folder structure

```
module-04/
├── README.md
├── data/
│   ├── products.csv
│   └── sales/          (one file per month)
├── notes/          (see list above)
├── examples/
│   ├── CsvFormatDemo.java
│   ├── CsvLibraryDemo.java
│   ├── ProductFilter.java
│   ├── NumberParsing.java
│   └── HighestSales.java
└── exercises/
    ├── README.md
    └── solutions/
```

## Checklist

- [x] CSV format and the Commons CSV library
- [x] Filtering rows
- [x] Converting strings to numbers
- [x] Finding the maximum, with null
- [x] Multiple files and refactoring
- [x] Practice exercises
