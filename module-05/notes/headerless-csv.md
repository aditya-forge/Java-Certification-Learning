# CSV files without a header

In Module 4 every file had a header, so values were read by column name: `record.get("Price")`. Plenty of real files have no header line. The first line is already data.

## Telling the parser

If the parser is set up to expect a header, it treats the first data row as column names. That loses a row and gives nonsense column names. So the header option has to be turned off.

Course library:

```java
FileResource fr = new FileResource(file);
CSVParser parser = fr.getCSVParser(false);   // false = no header
```

Plain Commons CSV: use `CSVFormat.DEFAULT` as it is, without `setHeader()`.

## Reading by index

Without names, columns are read by position, starting at 0:

```java
String title = record.get(0);
String genre = record.get(1);
int count = Integer.parseInt(record.get(2));
```

Magic numbers like `0, 1, 2` scattered around are easy to mix up, so I put them in constants at the top of the class:

```java
static final int TITLE = 0;
static final int GENRE = 1;
static final int COUNT = 2;
```

Then `record.get(COUNT)` reads almost as well as a header name.

## Totals

The most basic question for any data file is a total. Loop over every record, parse the number column, add it up, and optionally split the total by a category column. It's the accumulate pattern from Module 2, just with parsing in the middle.
