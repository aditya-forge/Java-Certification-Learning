# Using a CSV library

The course uses **Apache Commons CSV**. It deals with the quoting rules, and it lets you get values by column name instead of by position.

## The two main classes

- `CSVParser` reads a whole file. It's `Iterable`, so a for-each loop goes through it one row at a time.
- `CSVRecord` is one row. `record.get("Price")` gets a value by header name, and `record.get(2)` gets it by column index.

Every value comes back as a `String`, even numbers. Converting them is covered in `strings-to-numbers.md`.

## In the course

The course's `FileResource` class opens a file and hands back a parser directly:

```java
FileResource fr = new FileResource();          // file chooser dialog
CSVParser parser = fr.getCSVParser();          // first line treated as header
for (CSVRecord record : parser) {
    System.out.println(record.get("Name"));
}
```

## In plain Java

Without the course library, the parser needs setting up by hand:

```java
Reader in = new FileReader("data/products.csv");
CSVFormat format = CSVFormat.DEFAULT.builder()
        .setHeader()               // read names from the first line
        .setSkipHeaderRecord(true) // don't return that line as a record
        .build();
CSVParser parser = format.parse(in);
```

That's what my examples do, so they run outside BlueJ as well.

## A parser can only be read once

After a for-each loop has gone through a parser, it's used up. A second loop over the same parser finds nothing, with no error. To go through the data again, make a new parser. With `FileResource` that means calling `getCSVParser()` again.

This one caught me: a method that loops over the parser works fine on its own, but gives empty results when it runs after another method that already used the same parser.

## Running my examples

The examples need the Commons CSV jar on the classpath. From the `module-04` folder:

```
java -cp commons-csv-1.10.0.jar examples/CsvLibraryDemo.java
```

The jar can be downloaded from Maven Central (search for `commons-csv`). In BlueJ, the course library already includes it.
